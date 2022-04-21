package com.jt808.protocol.t808;

import io.github.yezhihao.netmc.core.model.Response;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.TheCameraImmediatelyShootsTheCommandResponse)
public class T0805 extends JTMessage implements Response {

    @Field(length = 2, desc = "Reply serial number")
    private int responseSerialNo;
    @Field(length = 1, desc = "Result: 0. Success 1. Fail 2. Channel not supported")
    private int result;
    @Field(totalUnit = 2, desc = "Multimedia ID List")
    private int[] id;

    public int getResponseSerialNo() {
        return responseSerialNo;
    }

    public void setResponseSerialNo(int responseSerialNo) {
        this.responseSerialNo = responseSerialNo;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }
}