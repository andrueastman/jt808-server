package com.jt808.protocol.t1078;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message(JT1078.ThePlatformIssuesARemoteVideoPlaybackRequest)
public class T9201 extends JTMessage {

    @Field(lengthUnit = 1, desc = "Server IP address")
    private String ip;
    @Field(length = 2, desc = "Real-time video server TCP port number")
    private int tcpPort;
    @Field(length = 2, desc = "Live video server UDP port number")
    private int udpPort;
    @Field(length = 1, desc = "logical channel number")
    private int channelNo;
    @Field(length = 1, desc = "Audio and video resource type: 0. Audio and video 1. Audio 2. Video 3. Video or audio and video")
    private int mediaType;
    @Field(length = 1, desc = "Stream type: 0. All streams 1. Main stream 2. Sub stream (if this channel only transmits audio, this field is set to 0)")
    private int streamType;
    @Field(length = 1, desc = "Storage type: 0. All storage 1. Main storage 2. Disaster recovery storage")
    private int storageType;
    @Field(length = 1, desc = "Playback mode: 0. Normal playback 1. Fast forward playback 2. Key frame fast rewind playback 3. Key frame playback 4. Single frame upload")
    private int playbackMode;
    @Field(length = 1, desc = "Fast forward or fast reverse multiple: 0. Invalid 1.1 times 2.2 times 3.4 times 4.8 times 5.16 times (When the playback control is 1 and 2, the content of this field is valid, otherwise it is set to 0)")
    private int playbackSpeed;
    @Field(length = 6, charset = "BCD", desc = "Start time (YYMMDDHHMMSS, when the playback mode is 4, this field indicates the upload time of a single frame)")
    private String startTime;
    @Field(length = 6, charset = "BCD", desc = "End time (YYMMDDHHMMSS, when the playback mode is 4, this field is invalid, and 0 means playback all the time)")
    private String endTime;

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

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
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

    public int getPlaybackMode() {
        return playbackMode;
    }

    public void setPlaybackMode(int playbackMode) {
        this.playbackMode = playbackMode;
    }

    public int getPlaybackSpeed() {
        return playbackSpeed;
    }

    public void setPlaybackSpeed(int playbackSpeed) {
        this.playbackSpeed = playbackSpeed;
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
}