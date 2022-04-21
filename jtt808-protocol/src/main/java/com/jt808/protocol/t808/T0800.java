package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.MultimediaEventInformationUpload)
public class T0800 extends JTMessage {

    @Field(length = 4, desc = "multimedia data ID")
    private int id;
    @Field(length = 1, desc = "Multimedia Type: 0. Image 1. Audio 2. Video")
    private int type;
    @Field(length = 1, desc = "Multimedia format encoding: 0.JPEG 1.TIF 2.MP3 3.WAV 4.WMV")
    private int format;
    @Field(length = 1, desc = "event item code")
    private int event;
    @Field(length = 1, desc = "channel ID")
    private int channelId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
}