package com.jt808.protocol.t1078;

import io.github.yezhihao.netmc.core.model.Response;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message(JT1078.FileUploadCompletionNotification)
public class T1206 extends JTMessage implements Response {

    @Field(length = 2, desc = "Reply serial number")
    private int responseSerialNo;
    @Field(length = 1, desc = "Result: 0. Success 1. Failure")
    private int result;

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
}
