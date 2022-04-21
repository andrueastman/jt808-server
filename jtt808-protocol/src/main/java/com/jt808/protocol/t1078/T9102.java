package com.jt808.protocol.t1078;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message(JT1078.AudioAndVideoRealTimeTransmissionControl)
public class T9102 extends JTMessage {

    @Field(length = 1, desc = "logical channel number")
    private int channelNo;
    @Field(length = 1, desc = "Control instruction：" +
            " 0.Turn off audio and video transmission instructions" +
            " 1.Switch stream (add pause and resume)" +
            " 2.Pause the sending of all streams on this channel" +
            " 3.Resume the sending of the stream before the pause, consistent with the stream type before the pause" +
            " 4.Turn off two-way intercom")
    private int command;
    @Field(length = 1, desc = "turnOffAudioAndVideoTypes：" +
            " 0.Close the audio and video data related to this channel" +
            " 1.Turn off only the audio related to this channel, keep the video related to this channel" +
            " 2.Only close the video related to this channel, keep the audio related to this channel")
    private int closeType;
    @Field(length = 1, desc = "Switch stream type: 0. Main stream 1. Sub stream")
    private int streamType;

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getCloseType() {
        return closeType;
    }

    public void setCloseType(int closeType) {
        this.closeType = closeType;
    }

    public int getStreamType() {
        return streamType;
    }

    public void setStreamType(int streamType) {
        this.streamType = streamType;
    }
}