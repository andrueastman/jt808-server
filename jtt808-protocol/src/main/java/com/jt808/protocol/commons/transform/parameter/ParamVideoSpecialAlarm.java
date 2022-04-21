package com.jt808.protocol.commons.transform.parameter;

import io.github.yezhihao.protostar.Schema;
import io.github.yezhihao.protostar.annotation.Field;
import io.netty.buffer.ByteBuf;

public class ParamVideoSpecialAlarm {

    public static final int key = 0x0079;

    public static final Schema<ParamVideoSpecialAlarm> SCHEMA = new ParamVideoSpecialAlarmSchema();

    @Field(desc = "Special alarm recording storage threshold (occupy the main memory storage threshold percentage, the value is 1~99. The default value is 20)")
    private byte storageThreshold;
    @Field(desc = "The duration of special alarm recording, the maximum duration of special alarm recording (minutes), the default value is 5")
    private byte duration;
    @Field(desc = "The start time of the special alarm mark, the recording time (minutes) marked before the special alarm occurs, the default value is 1")
    private byte startTime;

    public byte getStorageThreshold() {
        return storageThreshold;
    }

    public void setStorageThreshold(byte storageThreshold) {
        this.storageThreshold = storageThreshold;
    }

    public byte getDuration() {
        return duration;
    }

    public void setDuration(byte duration) {
        this.duration = duration;
    }

    public byte getStartTime() {
        return startTime;
    }

    public void setStartTime(byte startTime) {
        this.startTime = startTime;
    }

    private static class ParamVideoSpecialAlarmSchema implements Schema<ParamVideoSpecialAlarm> {

        private ParamVideoSpecialAlarmSchema() {
        }

        @Override
        public ParamVideoSpecialAlarm readFrom(ByteBuf input) {
            ParamVideoSpecialAlarm message = new ParamVideoSpecialAlarm();
            message.storageThreshold = input.readByte();
            message.duration = input.readByte();
            message.startTime = input.readByte();
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, ParamVideoSpecialAlarm message) {
            output.writeByte(message.storageThreshold);
            output.writeByte(message.duration);
            output.writeByte(message.startTime);
        }
    }
}