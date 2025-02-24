package com.jt808.protocol.commons.transform.parameter;

import io.github.yezhihao.protostar.Schema;
import io.netty.buffer.ByteBuf;

import java.time.LocalTime;

import static io.github.yezhihao.protostar.util.DateTool.BCD;

public class TimeRange {

    public static final Schema<TimeRange> SCHEMA = new TimeRangeSchema();

    private LocalTime startTime;
    private LocalTime endTime;

    public TimeRange() {
    }

    public TimeRange(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return '{' +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    private static class TimeRangeSchema implements Schema<TimeRange> {

        private TimeRangeSchema() {
        }

        @Override
        public TimeRange readFrom(ByteBuf input) {
            TimeRange message = new TimeRange();
            message.startTime = BCD.readTime2(input);
            message.endTime = BCD.readTime2(input);
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, TimeRange message) {
            BCD.writeTime2(output, message.startTime);
            BCD.writeTime2(output, message.endTime);
        }
    }
}