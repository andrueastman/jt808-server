package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.TerminalUpgradeResultNotification)
public class T0108 extends JTMessage {

    /** terminal */
    public static final int Terminal = 0;
    /** Road Transport Permit IC Card Reader */
    public static final int CardReader = 12;
    /** Beidou satellite positioning module Beidou satellite positioning module */
    public static final int Beidou = 52;

    @Field(length = 1, desc = "Upgrade type: 0. Terminal 12. Road transport card IC card reader 52. Beidou satellite positioning module")
    private int type;
    @Field(length = 1, desc = "Upgrade result: 0. Success 1. Fail 2. Cancel")
    private int result;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}