package com.jt808.protocol.jsatl12;

import io.github.yezhihao.protostar.annotation.Field;

import java.time.LocalDateTime;

public class AlarmId {

    @Field(length = 7, desc = "Terminal ID", version = {-1, 0})
    @Field(length = 30, desc = "Terminal ID(Cantonese standard)", version = 1)
    private String deviceId;
    @Field(length = 6, charset = "BCD", desc = "time(YYMMDDHHMMSS)")
    private LocalDateTime dateTime;
    @Field(length = 1, desc = "Serial number (the serial number of the alarm at the same time point, cyclically accumulated from 0)")
    private int serialNo;
    @Field(length = 1, desc = "Number of attachments")
    private int fileTotal;
    @Field(length = 1, desc = "reserved", version = {-1, 0})
    @Field(length = 2, desc = "Reserved (Cantonese Standard)", version = 1)
    private int reserved;

    private transient String platformAlarmId;

    public AlarmId() {
    }

    public AlarmId(String deviceId, LocalDateTime dateTime, int serialNo, int fileTotal, int reserved) {
        this.deviceId = deviceId;
        this.dateTime = dateTime;
        this.serialNo = serialNo;
        this.fileTotal = fileTotal;
        this.reserved = reserved;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public int getFileTotal() {
        return fileTotal;
    }

    public void setFileTotal(int fileTotal) {
        this.fileTotal = fileTotal;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public String getPlatformAlarmId() {
        return platformAlarmId;
    }

    public void setPlatformAlarmId(String platformAlarmId) {
        this.platformAlarmId = platformAlarmId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(100);
        sb.append("AlarmId{deviceId=").append(deviceId);
        sb.append(",dateTime=").append(dateTime);
        sb.append(",serialNo=").append(serialNo);
        sb.append(",fileTotal=").append(fileTotal);
        sb.append(",reserved=").append(reserved);
        sb.append('}');
        return sb.toString();
    }
}