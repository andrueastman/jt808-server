package com.jt808.protocol.t1078;

import io.github.yezhihao.netmc.core.model.Response;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message(JT1078.FileUploadControl)
public class T9207 extends JTMessage implements Response {

    @Field(length = 2, desc = "Reply serial number")
    private int responseSerialNo;
    @Field(length = 1, desc = "Upload control: 0. Pause 1. Continue 2. Cancel")
    private int command;

    public int getResponseSerialNo() {
        return responseSerialNo;
    }

    public void setResponseSerialNo(int responseSerialNo) {
        this.responseSerialNo = responseSerialNo;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }
}
