package com.jt808.protocol.t1078;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message(JT1078.RealTimeAudioAndVideoTransmissionStatusNotification)
public class T9105 extends JTMessage {

    @Field(length = 1, desc = "logical channel number")
    private int channelNo;
    @Field(length = 1, desc = "Packet loss rate")
    private int packetLossRate;

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
    }

    public int getPacketLossRate() {
        return packetLossRate;
    }

    public void setPacketLossRate(int packetLossRate) {
        this.packetLossRate = packetLossRate;
    }
}
