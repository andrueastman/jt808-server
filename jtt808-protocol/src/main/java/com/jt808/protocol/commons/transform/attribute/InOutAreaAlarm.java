package com.jt808.protocol.commons.transform.attribute;

import io.github.yezhihao.protostar.Schema;
import io.netty.buffer.ByteBuf;

/**
 * Route alarm in and out of the area 0x12
 * length 6
 */
public class InOutAreaAlarm {

    public static final int key = 18;

    public static final Schema<InOutAreaAlarm> SCHEMA = new InOutAreaAlarmSchema();

    /** Location type: 1. Circular area 2. Rectangular area 3. Polygonal area 4. Route */
    private byte areaType;
    /** Area or segment ID */
    private int areaId;
    /** Direction: 0. In 1. Out*/
    private byte direction;

    public InOutAreaAlarm() {
    }

    public InOutAreaAlarm(byte areaType, int areaId, byte direction) {
        this.areaType = areaType;
        this.areaId = areaId;
        this.direction = direction;
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

    public byte getDirection() {
        return direction;
    }

    public void setDirection(byte direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(80);
        sb.append("InOutAreaAlarm{areaType=").append(areaType);
        sb.append(",areaId=").append(areaId);
        sb.append(",direction=").append(direction);
        sb.append('}');
        return sb.toString();
    }

    private static class InOutAreaAlarmSchema implements Schema<InOutAreaAlarm> {

        private InOutAreaAlarmSchema() {
        }

        @Override
        public InOutAreaAlarm readFrom(ByteBuf input) {
            InOutAreaAlarm message = new InOutAreaAlarm();
            message.areaType = input.readByte();
            message.areaId = input.readInt();
            message.direction = input.readByte();
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, InOutAreaAlarm message) {
            output.writeByte(message.areaType);
            output.writeInt(message.areaId);
            output.writeByte(message.direction);
        }
    }
}