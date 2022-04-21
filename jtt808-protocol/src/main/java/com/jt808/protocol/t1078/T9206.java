package com.jt808.protocol.t1078;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message(JT1078.FileUploadInstruction)
public class T9206 extends JTMessage {

    @Field(lengthUnit = 1, desc = "server address")
    private String ip;
    @Field(length = 2, desc = "Port")
    private int port;
    @Field(lengthUnit = 1, desc = "user name")
    private String username;
    @Field(lengthUnit = 1, desc = "password")
    private String password;
    @Field(lengthUnit = 1, desc = "fileUploadPath")
    private String path;
    @Field(length = 1, desc = "logicalChannelNumber")
    private int channelNo;
    @Field(length = 6, charset = "BCD", desc = "startingTime(YYMMDDHHMMSS)")
    private String startTime;
    @Field(length = 6, charset = "BCD", desc = "endTime(YYMMDDHHMMSS)")
    private String endTime;
    @Field(length = 4, desc = "Alarm flag 0~31 (refer to the 808 protocol document for the definition of alarm flag bits)")
    private int warnBit1;
    @Field(length = 4, desc = "Alarm signs 32~63")
    private int warnBit2;
    @Field(length = 1, desc = "Audio and video resource type: 0. Audio and video 1. Audio 2. Video 3. Video or audio and video")
    private int mediaType;
    @Field(length = 1, desc = "Stream type: 0. All streams 1. Main stream 2. Sub stream")
    private int streamType;
    @Field(length = 1, desc = "Storage location: 0. All storage 1. Main storage 2. Disaster recovery storage")
    private int storageType;
    @Field(length = 1, desc = "Task execution conditions (represented by bits): [0] Downloadable under WIFI [1] Downloadable under LAN connection [2] Downloadable under 3G4G connection")
    private int condition;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getWarnBit1() {
        return warnBit1;
    }

    public void setWarnBit1(int warnBit1) {
        this.warnBit1 = warnBit1;
    }

    public int getWarnBit2() {
        return warnBit2;
    }

    public void setWarnBit2(int warnBit2) {
        this.warnBit2 = warnBit2;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public int getStreamType() {
        return streamType;
    }

    public void setStreamType(int streamType) {
        this.streamType = streamType;
    }

    public int getStorageType() {
        return storageType;
    }

    public void setStorageType(int storageType) {
        this.storageType = storageType;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
}