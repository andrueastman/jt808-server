package com.jt808.protocol.commons.transform.parameter;

import io.github.yezhihao.protostar.Schema;
import io.github.yezhihao.protostar.annotation.Field;
import io.netty.buffer.ByteBuf;

public class ParamImageIdentifyAlarm {

    public static final int key = 0x007B;

    public static final Schema<ParamImageIdentifyAlarm> SCHEMA = new ParamImageIdentifyAlarmSchema();

    @Field(desc = "The number of passengers verified by the vehicle, the number of passengers verified by the passenger vehicle, and the alarm will be generated when the video analysis result exceeds the number of passengers.")
    private byte overloadThreshold;
    @Field(desc = "Fatigue level threshold, video analysis fatigue driving alarm threshold, when it exceeds the alarm threshold, an alarm will be generated")
    private byte fatigueThreshold;

    public ParamImageIdentifyAlarm() {
    }

    public byte getOverloadThreshold() {
        return overloadThreshold;
    }

    public void setOverloadThreshold(byte overloadThreshold) {
        this.overloadThreshold = overloadThreshold;
    }

    public byte getFatigueThreshold() {
        return fatigueThreshold;
    }

    public void setFatigueThreshold(byte fatigueThreshold) {
        this.fatigueThreshold = fatigueThreshold;
    }

    private static class ParamImageIdentifyAlarmSchema implements Schema<ParamImageIdentifyAlarm> {

        private ParamImageIdentifyAlarmSchema() {
        }

        @Override
        public ParamImageIdentifyAlarm readFrom(ByteBuf input) {
            ParamImageIdentifyAlarm message = new ParamImageIdentifyAlarm();
            message.overloadThreshold = input.readByte();
            message.fatigueThreshold = input.readByte();
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, ParamImageIdentifyAlarm message) {
            output.writeByte(message.overloadThreshold);
            output.writeByte(message.fatigueThreshold);
        }
    }
}