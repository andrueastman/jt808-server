package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.DataCompressionReport)
public class T0901 extends JTMessage {

    @Field(length = 4, desc = "Compressed message length")
    private int length;
    @Field(desc = "compressed message body")
    private byte[] body;

    public T0901() {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
        this.length = body.length;
    }
}