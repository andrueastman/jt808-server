package com.jt808.protocol.jsatl12;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JSATL12;

@Message(JSATL12.AlarmAttachmentUploadInstruction)
public class T9208 extends JTMessage {

    private static final byte[] RESERVED = new byte[16];

    @Field(lengthUnit = 1, desc = "Server IP address")
    private String ip;
    @Field(length = 2, desc = "TCP port")
    private int tcpPort;
    @Field(length = 2, desc = "UDP port")
    private int udpPort;
    @Field(length = 16, desc = "Alarm identification number", version = {-1, 0})
    @Field(length = 40, desc = "Alarm identification number (Cantonese standard)", version = 1)
    private AlarmId alarmId;
    @Field(length = 32, desc = "alarmNumber")
    private String platformAlarmId;
    @Field(length = 16, desc = "reserved")
    private byte[] reserved = RESERVED;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public int getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }

    public AlarmId getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(AlarmId alarmId) {
        this.alarmId = alarmId;
    }

    public String getPlatformAlarmId() {
        return platformAlarmId;
    }

    public void setPlatformAlarmId(String platformAlarmId) {
        this.platformAlarmId = platformAlarmId;
    }

    public byte[] getReserved() {
        return reserved;
    }

    public void setReserved(byte[] reserved) {
        this.reserved = reserved;
    }
}