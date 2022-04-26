package com.jt808.web.endpoint;

import com.azure.storage.blob.BlobClientBuilder;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.yezhihao.netmc.core.annotation.Endpoint;
import io.github.yezhihao.netmc.core.annotation.Mapping;
import io.github.yezhihao.netmc.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jt808.commons.util.StrUtils;
import com.jt808.protocol.commons.JSATL12;
import com.jt808.protocol.jsatl12.*;
import com.jt808.web.service.FileService;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@Endpoint
@Component
public class JSATL12Endpoint {

    @Autowired
    private FileService fileService;

    @Autowired
    BlobClientBuilder blobClientBuilder;

    private final Cache<String, Map<String, AlarmId>> cache = Caffeine.newBuilder().expireAfterAccess(30, TimeUnit.MINUTES).build();

    private AlarmId getAlarmId(String clientId, String filename) {
        Map<String, AlarmId> alarmIdMap = cache.getIfPresent(clientId);
        if (alarmIdMap != null)
            return alarmIdMap.get(filename);
        return null;
    }

    @Mapping(types = JSATL12.AlarmAttachmentInformationMessage, desc = "Alarm attachment information message")
    public void alarmFileInfoList(T1210 message, Session session) {
        session.register(message.getDeviceId(), message);

        List<T1210.Item> items = message.getItems();
        if (items == null)
            return;

        AlarmId alarmId = message.getAlarmId();

        if (StrUtils.isBlank(alarmId.getDeviceId()))
            alarmId.setDeviceId(message.getDeviceId());

        if (StrUtils.isBlank(alarmId.getDeviceId()))
            alarmId.setDeviceId(message.getClientId());

        alarmId.setPlatformAlarmId(message.getPlatformAlarmId());
        Map<String, AlarmId> alarmIdMap = cache.get(message.getClientId(), s -> new TreeMap<>());

        for (T1210.Item item : items)
            alarmIdMap.put(item.getName(), alarmId);
        fileService.createDir(message);
    }

    @Mapping(types = JSATL12.FileInformationUpload, desc = "File information upload")
    public void alarmFileInfo(T1211 message, Session session) {
        if (!session.isRegistered())
            session.register(message);

        AlarmId alarmId = getAlarmId(message.getClientId(), message.getName());
        if (alarmId == null)
            throw new RuntimeException("alarmId not found");
        fileService.createFile(alarmId, message);
    }

    @Mapping(types = JSATL12.FileDataUpload, desc = "file data upload")
    public Object alarmFile(DataPacket message, Session session) {
        AlarmId alarmId = getAlarmId(session.getClientId(), message.getName().trim());
        if (alarmId != null)
            fileService.writeFile(alarmId, message);
        return null;
    }

    @Mapping(types = JSATL12.FileUploadCompleteMessage, desc = "File upload complete message")
    public T9212 alarmFileComplete(T1211 message) {
        Map<String, AlarmId> alarmIdMap = cache.getIfPresent(message.getClientId());
        AlarmId alarmId = alarmIdMap.get(message.getName());
        T9212 result = new T9212();
        result.setName(message.getName());
        result.setType(message.getType());

        int[] items = fileService.checkFile(alarmId, message);
        if (items == null) {
            alarmIdMap.remove(message.getName());
            result.setResult(0);
            // move file to blob storage
            File savedFile = fileService.getFile(alarmId,message);
            String fileName = getDir(alarmId) + message.getName();
            try {
                final InputStream targetStream = new DataInputStream(new FileInputStream(savedFile));
                blobClientBuilder.blobName(fileName).buildClient().upload(targetStream, savedFile.length());

                savedFile.delete();

                // TODO save file info to database
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else {
            result.setItems(items);
            result.setResult(1);
        }
        return result;
    }

    private String getDir(AlarmId alarmId) {
        StringBuilder sb = new StringBuilder(55);
        sb.append(alarmId.getDeviceId()).append('/');
        sb.append(alarmId.getDateTime()).append('_').append(alarmId.getSerialNo()).append('/');
        return sb.toString();
    }
}