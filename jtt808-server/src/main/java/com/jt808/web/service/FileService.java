package com.jt808.web.service;

import com.jt808.protocol.jsatl12.AlarmId;
import com.jt808.protocol.jsatl12.DataPacket;
import com.jt808.protocol.jsatl12.T1210;
import com.jt808.protocol.jsatl12.T1211;
import com.jt808.protocol.t808.T0801;

public interface FileService {

    boolean saveMediaFile(T0801 message);

    void createDir(T1210 alarmInfo);

    void createFile(AlarmId alarmId, T1211 fileInfo);

    void writeFile(AlarmId alarmId, DataPacket fileData);

    int[] checkFile(AlarmId alarmId, T1211 fileInfo);

}