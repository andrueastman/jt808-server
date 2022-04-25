package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.CallBack)
public class T8400 extends JTMessage {

    /** Normal */
    public static final int Normal = 0;
    /** Listen */
    public static final int Listen = 1;

    @Field(length = 1, desc = "Type: 0. Call 1. Monitor")
    private int type;
    @Field(length = 20, desc = "telephoneNumber")
    private String phoneNumber;

    public T8400() {
    }

    public T8400(int type, String phoneNumber) {
        this.type = type;
        this.phoneNumber = phoneNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}