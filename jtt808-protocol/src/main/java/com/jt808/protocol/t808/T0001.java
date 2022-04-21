package com.jt808.protocol.t808;

import io.github.yezhihao.netmc.core.model.Response;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message({JT808.PlatformUniversalResponse, JT808.TerminalGeneralAnswer})
public class T0001 extends JTMessage implements Response {

    public static final int Success = 0; //success confirmed
    public static final int Failure = 1;//fail
    public static final int MessageError = 2;//WRONG MESSAGE
    public static final int NotSupport = 3;//not support
    public static final int AlarmAck = 4;//Alarm processing confirmation

    @Field(length = 2, desc = "Reply serial number")
    private int responseSerialNo;
    @Field(length = 2, desc = "Reply ID")
    private int responseMessageId;
    @Field(length = 1, desc = "Result: 0. Success 1. Failure 2. Message is wrong 3. Not supported 4. Alarm processing confirmation")
    private int resultCode;

    public int getResponseSerialNo() {
        return responseSerialNo;
    }

    public void setResponseSerialNo(int responseSerialNo) {
        this.responseSerialNo = responseSerialNo;
    }

    public int getResponseMessageId() {
        return responseMessageId;
    }

    public void setResponseMessageId(int responseMessageId) {
        this.responseMessageId = responseMessageId;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}