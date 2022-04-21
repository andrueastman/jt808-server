package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.RecordingStartCommand)
public class T8804 extends JTMessage {

    @Field(length = 1, desc = "Recording command: 0. Stop recording 1. Start recording")
    private int command;
    @Field(length = 2, desc = "Recording time (seconds) 0. means recording all the time")
    private int time;
    @Field(length = 1, desc = "Save flag: 0. Real-time upload 1. Save")
    private int save;
    @Field(length = 1, desc = "Audio sampling rate: 0.8K 1.11K 2.23K 3.32K other reserved")
    private int audioSamplingRate;

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public int getAudioSamplingRate() {
        return audioSamplingRate;
    }

    public void setAudioSamplingRate(int audioSamplingRate) {
        this.audioSamplingRate = audioSamplingRate;
    }
}