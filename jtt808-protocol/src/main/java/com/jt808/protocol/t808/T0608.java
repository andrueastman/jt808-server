package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.InquiryAreaOrLineDataAnswer)
public class T0608 extends JTMessage {

    /** @see com.jt808.protocol.commons.Shape */
    @Field(length = 1, desc = "query type")
    private int type;
    @Field(totalUnit = 4, desc = "Data returned by the query")
    private byte[] bytes;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}