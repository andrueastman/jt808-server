package com.jt808.protocol.t808;

import io.github.yezhihao.netmc.core.model.Response;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message({JT808.TheServerRetransmitsTheSubcontractingRequest, JT808.TerminalRetransmissionSubPacketRequest})
public class T8003 extends JTMessage implements Response {

    @Field(length = 2, desc = "original message serial number")
    private int responseSerialNo;
    @Field(totalUnit = 1, desc = "List of retransmission packet IDs", version = {-1, 0})
    @Field(totalUnit = 2, desc = "List of retransmission packet IDs", version = 1)
    private short[] id;

    public int getResponseSerialNo() {
        return responseSerialNo;
    }

    public void setResponseSerialNo(int responseSerialNo) {
        this.responseSerialNo = responseSerialNo;
    }

    public short[] getId() {
        return id;
    }

    public void setId(short[] id) {
        this.id = id;
    }
}