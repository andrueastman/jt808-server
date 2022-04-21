package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.QueryTheSpecifiedTerminalParameters)
public class T8106 extends JTMessage {

    @Field(totalUnit = 1, desc = "List of parameter IDs")
    private int[] id;

    public T8106() {
    }

    public T8106(int... id) {
        this.id = id;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }
}