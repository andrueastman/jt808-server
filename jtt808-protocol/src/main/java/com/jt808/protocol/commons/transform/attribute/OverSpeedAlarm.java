package com.jt808.protocol.commons.transform.attribute;

import io.github.yezhihao.protostar.Schema;
import io.netty.buffer.ByteBuf;

/**
 * Overspeed alarm 0x11
 * length 1 或 5
 */
public class OverSpeedAlarm {

    public static final int key = 17;

    public static final Schema<OverSpeedAlarm> SCHEMA = new OverSpeedAlarmSchema();

    /** Location type: 0. No specific location 1. Circular area 2. Rectangular area 3. Polygonal area 4. Road segment*/
    private byte areaType;
    /** Area or segment ID */
    private int areaId;

    public OverSpeedAlarm() {
    }

    public OverSpeedAlarm(byte areaType, int areaId) {
        this.areaType = areaType;
        this.areaId = areaId;
    }

    public byte getAreaType() {
        return areaType;
    }

    public void setAreaType(byte areaType) {
        this.areaType = areaType;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(80);
        sb.append("OverSpeedAlarm{areaType=").append(areaType);
        sb.append(",areaId=").append(areaId);
        sb.append('}');
        return sb.toString();
    }

    private static class OverSpeedAlarmSchema implements Schema<OverSpeedAlarm> {

        private OverSpeedAlarmSchema() {
        }

        @Override
        public OverSpeedAlarm readFrom(ByteBuf input) {
            OverSpeedAlarm message = new OverSpeedAlarm();
            message.areaType = input.readByte();
            if (message.areaType > 0)
                message.areaId = input.readInt();
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, OverSpeedAlarm message) {
            output.writeByte(message.areaType);
            if (message.areaType > 0)
                output.writeInt(message.areaId);
        }
    }
}