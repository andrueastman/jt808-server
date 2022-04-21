package com.jt808.protocol.commons.transform.parameter;

import io.github.yezhihao.protostar.Schema;
import io.github.yezhihao.protostar.annotation.Field;
import io.netty.buffer.ByteBuf;

import java.time.LocalTime;

import static io.github.yezhihao.protostar.util.DateTool.BCD;

public class ParamSleepWake {

    public static final int key = 0x007C;

    public static final Schema<ParamSleepWake> SCHEMA = new ParamSleepWakeSchema();

    @Field(desc = "Sleep wake-up mode: [0] Conditional wake-up [1] Timing wake-up [2] Manual wake-up")
    private int mode;
    @Field(desc = "Wake-up condition type: [0] Emergency alarm [1] Collision rollover alarm [2] Vehicle door open, this field is valid when [0] is 1 in sleep wake-up mode, otherwise it is set to 0")
    private int conditionType;
    @Field(desc = "Weekly wake-up day setting: [0]Monday [1]Tuesday [2]Wednesday [3]Thursday [4]Friday [5]Saturday [6]Sunday")
    private int dayOfWeek;
    @Field(desc = "Daytime wake-up enable flag: [0] Enable period 1 [1] Enable period 2 [2] Enable period 3 [3] Enable period 4)")
    private int timeFlag;
    @Field(desc = "Time period 1 wake-up time")
    private LocalTime wakeTime1;
    @Field(desc = "Time period 1 closing time")
    private LocalTime sleepTime1;
    @Field(desc = "Time period 2 wake-up time")
    private LocalTime wakeTime2;
    @Field(desc = "Time period 2 closing time")
    private LocalTime sleepTime2;
    @Field(desc = "Time period 3 wake-up time")
    private LocalTime wakeTime3;
    @Field(desc = "Time period 3 closing time")
    private LocalTime sleepTime3;
    @Field(desc = "Time period 4 wake-up time")
    private LocalTime wakeTime4;
    @Field(desc = "Time period 4 closing time")
    private LocalTime sleepTime4;

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getConditionType() {
        return conditionType;
    }

    public void setConditionType(int conditionType) {
        this.conditionType = conditionType;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getTimeFlag() {
        return timeFlag;
    }

    public void setTimeFlag(int timeFlag) {
        this.timeFlag = timeFlag;
    }

    public LocalTime getWakeTime1() {
        return wakeTime1;
    }

    public void setWakeTime1(LocalTime wakeTime1) {
        this.wakeTime1 = wakeTime1;
    }

    public LocalTime getSleepTime1() {
        return sleepTime1;
    }

    public void setSleepTime1(LocalTime sleepTime1) {
        this.sleepTime1 = sleepTime1;
    }

    public LocalTime getWakeTime2() {
        return wakeTime2;
    }

    public void setWakeTime2(LocalTime wakeTime2) {
        this.wakeTime2 = wakeTime2;
    }

    public LocalTime getSleepTime2() {
        return sleepTime2;
    }

    public void setSleepTime2(LocalTime sleepTime2) {
        this.sleepTime2 = sleepTime2;
    }

    public LocalTime getWakeTime3() {
        return wakeTime3;
    }

    public void setWakeTime3(LocalTime wakeTime3) {
        this.wakeTime3 = wakeTime3;
    }

    public LocalTime getSleepTime3() {
        return sleepTime3;
    }

    public void setSleepTime3(LocalTime sleepTime3) {
        this.sleepTime3 = sleepTime3;
    }

    public LocalTime getWakeTime4() {
        return wakeTime4;
    }

    public void setWakeTime4(LocalTime wakeTime4) {
        this.wakeTime4 = wakeTime4;
    }

    public LocalTime getSleepTime4() {
        return sleepTime4;
    }

    public void setSleepTime4(LocalTime sleepTime4) {
        this.sleepTime4 = sleepTime4;
    }

    private static class ParamSleepWakeSchema implements Schema<ParamSleepWake> {

        private ParamSleepWakeSchema() {
        }

        @Override
        public ParamSleepWake readFrom(ByteBuf input) {
            ParamSleepWake message = new ParamSleepWake();
            message.mode = input.readByte();
            message.conditionType = input.readByte();
            message.dayOfWeek = input.readByte();
            message.timeFlag = input.readByte();
            message.wakeTime1 = BCD.readTime2(input);
            message.sleepTime1 = BCD.readTime2(input);
            message.wakeTime2 = BCD.readTime2(input);
            message.sleepTime2 = BCD.readTime2(input);
            message.wakeTime3 = BCD.readTime2(input);
            message.sleepTime3 = BCD.readTime2(input);
            message.wakeTime4 = BCD.readTime2(input);
            message.sleepTime4 = BCD.readTime2(input);
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, ParamSleepWake message) {
            output.writeByte(message.mode);
            output.writeByte(message.conditionType);
            output.writeByte(message.dayOfWeek);
            output.writeByte(message.timeFlag);
            BCD.writeTime2(output, message.wakeTime1);
            BCD.writeTime2(output, message.sleepTime1);
            BCD.writeTime2(output, message.wakeTime2);
            BCD.writeTime2(output, message.sleepTime2);
            BCD.writeTime2(output, message.wakeTime3);
            BCD.writeTime2(output, message.sleepTime3);
            BCD.writeTime2(output, message.wakeTime4);
            BCD.writeTime2(output, message.sleepTime4);
        }
    }
}