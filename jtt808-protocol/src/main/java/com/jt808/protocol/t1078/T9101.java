package com.jt808.protocol.t1078;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message(JT1078.RealTimeAudioAndVideoTransmissionRequest)
public class T9101 extends JTMessage {

    @Field(lengthUnit = 1, desc = "Server IP address")
    private String ip;
    @Field(length = 2, desc = "Real-time video server TCP port number")
    private int tcpPort;
    @Field(length = 2, desc = "Live video server UDP port number")
    private int udpPort;
    @Field(length = 1, desc = "logical channel number")
    private int channelNo;
    @Field(length = 1, desc = "Data type: 0. Audio and video 1. Video 2. Two-way intercom 3. Monitoring 4. Central broadcast 5. Transparent transmission")
    private int mediaType;
    @Field(length = 1, desc = "Stream type: 0. Main stream 1. Sub stream")
    private int streamType;

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
}