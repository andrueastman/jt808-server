package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.SingleStoredMultimediaDataRetreivalCommand)
public class T8805 extends JTMessage {

    @Field(length = 4, desc = "Multimedia ID (greater than 0)")
    private int id;
    @Field(length = 1, desc = "Delete flag: 0. Keep 1. Delete")
    private int delete;

    public T8805() {
    }

    public T8805(int id, int delete) {
        this.id = id;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}