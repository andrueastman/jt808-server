package com.jt808.web.endpoint;

import com.jt808.commons.model.APIResult;
import com.jt808.commons.util.DateUtils;
import com.jt808.protocol.commons.transform.AttributeKey;
import com.jt808.protocol.commons.transform.attribute.AlarmDSM;
import com.jt808.protocol.jsatl12.AlarmId;
import com.jt808.protocol.jsatl12.T9208;
import io.github.yezhihao.netmc.core.annotation.Async;
import io.github.yezhihao.netmc.core.annotation.AsyncBatch;
import io.github.yezhihao.netmc.core.annotation.Endpoint;
import io.github.yezhihao.netmc.core.annotation.Mapping;
import io.github.yezhihao.netmc.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;
import com.jt808.protocol.t808.*;
import com.jt808.web.model.enums.SessionKey;
import com.jt808.web.model.vo.DeviceInfo;
import com.jt808.web.service.FileService;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

import static com.jt808.protocol.commons.JT808.*;

@Endpoint
@Component
public class JT808Endpoint {

    private static final Logger log = LoggerFactory.getLogger(JT808Endpoint.class.getSimpleName());

    @Autowired
    private FileService fileService;

    @Autowired
    private MessageManager messageManager;

    @Value("${jt-server.jt808.alarm-file.host}")
    private String host;

    @Value("${jt-server.jt808.alarm-file.port}")
    private int port;

    @Mapping(types = TerminalGeneralAnswer, desc = "Terminal general answer")
    public Object generalResponse(T0001 message, Session session) {
        session.response(message);
        return null;
    }

    @Mapping(types = TerminalHeartbeat, desc = "Terminal heartbeat")
    public void heartbeat(JTMessage message, Session session) {
    }

    @Mapping(types = TerminalLogout, desc = "Terminal logout")
    public void unregister(JTMessage message, Session session) {
        session.invalidate();
    }

    @Mapping(types = QueryServerTime, desc = "query server time")
    public T8004 serverTime(JTMessage message, Session session) {
        T8004 result = new T8004(LocalDateTime.now(ZoneOffset.UTC));
        return result;
    }

    @Mapping(types = TerminalRetransmissionSubPacketRequest, desc = "Terminal retransmission sub-packet request")
    public void retransmissionPacket(T8003 message, Session session) {
    }

    @Mapping(types = TerminalRegistration, desc = "Terminal registration")
    public T8100 register(T0100 message, Session session) {
        session.register(message);
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDeviceId(message.getDeviceId());
        session.setAttribute(SessionKey.DeviceInfo, deviceInfo);

        T8100 result = new T8100();
        result.setResponseSerialNo(message.getSerialNo());
        result.setToken(message.getDeviceId());
        result.setResultCode(T8100.Success);
        return result;
    }

    @Mapping(types = TerminalAuthentication, desc = "Terminal authentication")
    public T0001 authentication(T0102 message, Session session) {
        session.register(message);
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDeviceId(message.getToken());
        session.setAttribute(SessionKey.DeviceInfo, deviceInfo);

        T0001 result = new T0001();
        result.setResponseSerialNo(message.getSerialNo());
        result.setResponseMessageId(message.getMessageId());
        result.setResultCode(T0001.Success);
        return result;
    }

    @Mapping(types = QueryTerminalParameterResponse, desc = "Query terminal parameter response")
    public void parametersResponse(T0104 message, Session session) {
        session.response(message);
    }

    @Mapping(types = QueryTerminalPropertiesReply, desc = "Query Terminal Properties Reply")
    public void attributesResponse(T0107 message, Session session) {
        session.response(message);
    }

    @Mapping(types = TerminalUpgradeResultNotification, desc = "Terminal upgrade result notification")
    public void upgradeResponse(T0108 message, Session session) {
    }

    /**
     * Asynchronous batch processing
     * poolSize：Reference database CPU core count
     * maxElements：A maximum of 4000 records are accumulated and processed once
     * maxWait：Maximum waiting time 1 second
     */
    @AsyncBatch(poolSize = 2, maxElements = 4000, maxWait = 1000)
    @Mapping(types = LocationInformationReport, desc = "location information report")
    public void locationReport(List<T0200> list) {
        for (T0200 information:list) {
            if(information.getAttributes().containsKey(AttributeKey.AlarmDSM)){
                log.info("Found alarm event");
                AlarmDSM alarmDSM = (AlarmDSM)information.getAttributes().get(AttributeKey.AlarmDSM);
                if(alarmDSM != null){
                    log.info("Requesting for image upload ... ");
                    T9208 request = new T9208();
                    request.setIp(host);
                    request.setTcpPort(port);
                    request.setUdpPort(0);
                    request.setAlarmId(new AlarmId(alarmDSM.getAlarmId().getDeviceId(), alarmDSM.getAlarmId().getDateTime(), alarmDSM.getSerialNo(), alarmDSM.getFileTotal(), 0));
                    request.setPlatformAlarmId(UUID.randomUUID().toString().replaceAll("-", ""));

                    Mono<APIResult<T0001>> response = messageManager.requestR(information.getClientId(), request, T0001.class);
                    response.subscribe( (value) -> {
                        log.info("Response status: "+ value.isSuccess());
                        log.info("Response message: "+ value.getMsg());
                    });

                }


            }
        }
    }

    @Mapping(types = BulkUploadOfPositioningData, desc = "Bulk upload of positioning data")
    public void locationBatchReport(T0704 message) {
    }

    @Mapping(types = {LocationInformationQueryResponse, VehicleControlResponse}, desc = "Location information query response/vehicle control response")
    public void locationResponse(T0201_0500 message, Session session) {
        session.response(message);
    }

    @Mapping(types = IncidentReport, desc = "Incident report")
    public void eventReport(T0301 message, Session session) {
    }

    @Mapping(types = QuestionAndAnswer, desc = "question and answer")
    public void questionResponse(T0302 message, Session session) {
    }

    @Mapping(types = InformationOnDemandCancel, desc = "Cancellation of information on demand")
    public void newsCancel(T0303 message, Session session) {
    }

    @Mapping(types = InquiryAreaOrLineDataAnswer, desc = "Inquiry Area or Line Data Answer")
    public void areaLocationResponse(T0608 message, Session session) {
        session.response(message);
    }

    @Mapping(types = DrivingRecordDataUpload, desc = "Driving recorder data upload")
    public void driveRecorderResponse(T0700 message, Session session) {
        session.response(message);
    }

    @Mapping(types = ElectronicWaybillReporting, desc = "Electronic Waybill Reporting")
    public void ewaybillReport(JTMessage message, Session session) {
    }

    @Mapping(types = CollectAndReportDriverIdentityInformation, desc = "Collect and report driver identity information")
    public void driverInfoResponse(T0702 message, Session session) {
        session.response(message);
    }

    @Mapping(types = CANBusDataUpload, desc = "CAN bus data upload")
    public void canBusDataReport(T0705 message, Session session) {
    }

    @Mapping(types = MultimediaEventInformationUpload, desc = "Multimedia event information upload")
    public void mediaEventReport(T0800 message, Session session) {
    }

    @Async
    @Mapping(types = MultimediaDataUpload, desc = "Multimedia data upload")
    public JTMessage mediaUploadResponse(T0801 message, Session session) {
        if (message.getPacket() == null) {
            T0001 result = new T0001();
            result.copyBy(message);
            result.setMessageId(JT808.PlatformUniversalResponse);
            result.setSerialNo(session.nextSerialNo());

            result.setResponseSerialNo(message.getSerialNo());
            result.setResponseMessageId(message.getMessageId());
            result.setResultCode(T0001.Success);
            return result;
        }
        fileService.saveMediaFile(message);
        T8800 result = new T8800();
        result.setMediaId(message.getId());
        return result;
    }

    @Mapping(types = StoreMultimediaDataRetrievalResponse, desc = "Store Multimedia Data Retrieval Response")
    public void mediaSearchResponse(T0802 message, Session session) {
        session.response(message);
    }

    @Mapping(types = TheCameraImmediatelyShootsTheCommandResponse, desc = "The camera immediately shoots the command response")
    public void mediaVideoRecordResponse(T0805 message, Session session) {
        session.response(message);
    }

    @Mapping(types = DataUplinkTransparentTransmission, desc = "Data uplink transparent transmission")
    public void passthrough(T0900 message, Session session) {
    }

    @Mapping(types = DataCompressionReport, desc = "data compression report")
    public void gzipPackReport(T0901 message, Session session) {
    }

    @Mapping(types = TerminalRSAPublicKey, desc = "Terminal RSA public key")
    public void rsaSwap(T0A00_8A00 message, Session session) {
        session.response(message);
    }
}