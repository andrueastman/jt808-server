package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

import java.time.LocalDateTime;

@Message(JT808.StoreMultimediaDataUpload)
public class T8803 extends JTMessage {

    @Field(length = 1, desc = "Multimedia Type: 0. Image 1. Audio 2. Video")
    private int type;
    @Field(length = 1, desc = "channel ID")
    private int channelId;
    @Field(length = 1, desc = "Event item code: 0. Command issued by the platform 1. Timing action 2. Robbery alarm trigger 3. Collision rollover alarm trigger Other reserved")
    private int event;
    @Field(length = 6, charset = "BCD", desc = "start time(YYMMDDHHMMSS)")
    private LocalDateTime startTime;
    @Field(length = 6, charset = "BCD", desc = "End Time(YYMMDDHHMMSS)")
    private LocalDateTime endTime;
    @Field(length = 1, desc = "Delete flag: 0. Keep 1. Delete")
    private int delete;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}