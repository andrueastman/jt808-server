package com.jt808.protocol.commons.transform.parameter;

import io.github.yezhihao.protostar.Schema;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;

public class ParamTPMS {

    public static final int key = 0xF366;

    public static final Schema<ParamTPMS> SCHEMA = new ParamTPMSSchema();

    @Field(desc = "Tire specification model (example: 19565 R 1591 V, 12 characters, default value '900 R 20')")
    private String tireType;
    @Field(desc = "Tire pressure unit: 0.kgcm2 1.bar 2.Kpa 3.PSI (default value 3)")
    private int pressureUnit = -1;
    @Field(desc = "Normal tire pressure value (same tire pressure unit, default value 140)")
    private int normalValue = -1;
    @Field(desc = "Tire pressure imbalance alarm threshold (percentage 0~100, reaching the cold air pressure value, the default value is 20)")
    private int imbalanceThreshold = -1;
    @Field(desc = "Slow air leakage alarm threshold (percentage 0~100, reaching the cold air pressure value, default value 5)")
    private int lowLeakThreshold = -1;
    @Field(desc = "Low pressure alarm threshold (same tire pressure unit, default value 110)")
    private int lowPressureThreshold = -1;
    @Field(desc = "High pressure alarm threshold (same tire pressure unit, default value 189)")
    private int highPressureThreshold = -1;
    @Field(desc = "High temperature alarm threshold (Celsius, default 80)")
    private int highTemperatureThreshold = -1;
    @Field(desc = "Voltage alarm threshold (percentage 0~100, default value 10)")
    private int voltageThreshold = -1;
    @Field(desc = "Timing reporting interval (seconds, the value is 0~3600, the default value is 60, 0 means no reporting)")
    private int reportInterval = -1;
    @Field(desc = "Reserved")
    private byte[] reserved = new byte[6];

    public String getTireType() {
        return tireType;
    }

    public void setTireType(String tireType) {
        this.tireType = tireType;
    }

    public int getPressureUnit() {
        return pressureUnit;
    }

    public void setPressureUnit(int pressureUnit) {
        this.pressureUnit = pressureUnit;
    }

    public int getNormalValue() {
        return normalValue;
    }

    public void setNormalValue(int normalValue) {
        this.normalValue = normalValue;
    }

    public int getImbalanceThreshold() {
        return imbalanceThreshold;
    }

    public void setImbalanceThreshold(int imbalanceThreshold) {
        this.imbalanceThreshold = imbalanceThreshold;
    }

    public int getLowLeakThreshold() {
        return lowLeakThreshold;
    }

    public void setLowLeakThreshold(int lowLeakThreshold) {
        this.lowLeakThreshold = lowLeakThreshold;
    }

    public int getLowPressureThreshold() {
        return lowPressureThreshold;
    }

    public void setLowPressureThreshold(int lowPressureThreshold) {
        this.lowPressureThreshold = lowPressureThreshold;
    }

    public int getHighPressureThreshold() {
        return highPressureThreshold;
    }

    public void setHighPressureThreshold(int highPressureThreshold) {
        this.highPressureThreshold = highPressureThreshold;
    }

    public int getHighTemperatureThreshold() {
        return highTemperatureThreshold;
    }

    public void setHighTemperatureThreshold(int highTemperatureThreshold) {
        this.highTemperatureThreshold = highTemperatureThreshold;
    }

    public int getVoltageThreshold() {
        return voltageThreshold;
    }

    public void setVoltageThreshold(int voltageThreshold) {
        this.voltageThreshold = voltageThreshold;
    }

    public int getReportInterval() {
        return reportInterval;
    }

    public void setReportInterval(int reportInterval) {
        this.reportInterval = reportInterval;
    }

    public byte[] getReserved() {
        return reserved;
    }

    public void setReserved(byte[] reserved) {
        this.reserved = reserved;
    }

    private static class ParamTPMSSchema implements Schema<ParamTPMS> {

        private ParamTPMSSchema() {
        }

        @Override
        public ParamTPMS readFrom(ByteBuf input) {
            ParamTPMS message = new ParamTPMS();
            message.tireType = input.readCharSequence(12, StandardCharsets.US_ASCII).toString();
            message.pressureUnit = input.readShort();
            message.normalValue = input.readShort();
            message.imbalanceThreshold = input.readShort();
            message.lowLeakThreshold = input.readShort();
            message.lowPressureThreshold = input.readShort();
            message.highPressureThreshold = input.readShort();
            message.highTemperatureThreshold = input.readShort();
            message.voltageThreshold = input.readShort();
            message.reportInterval = input.readShort();
            input.readBytes(message.reserved);
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, ParamTPMS message) {
            byte[] bytes = message.getTireType().getBytes(StandardCharsets.US_ASCII);
            ByteBufUtils.writeFixedLength(output, 12, bytes);
            output.writeShort(message.pressureUnit);
            output.writeShort(message.normalValue);
            output.writeShort(message.imbalanceThreshold);
            output.writeShort(message.lowLeakThreshold);
            output.writeShort(message.lowPressureThreshold);
            output.writeShort(message.highPressureThreshold);
            output.writeShort(message.highTemperatureThreshold);
            output.writeShort(message.voltageThreshold);
            output.writeShort(message.reportInterval);
            ByteBufUtils.writeFixedLength(output, 6, message.getReserved());
        }
    }
}