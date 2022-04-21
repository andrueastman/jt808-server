package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.MultimediaDataUploadResponse)
public class T8800 extends JTMessage {

    @Field(length = 4, desc = "Multimedia ID (greater than 0) No subsequent fields if all packets are received")
    private int mediaId;
    @Field(totalUnit = 1, desc = "List of retransmission packet IDs")
    private short[] id;

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public short[] getId() {
        return id;
    }

    public void setId(short[] id) {
        this.id = id;
    }
}