package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.InformationOnDemandCancel)
public class T0303 extends JTMessage {

    @Field(length = 1, desc = "message type")
    private int type;
    @Field(length = 1, desc = "On-demand cancellation flag: 0. Cancel 1. On-demand")
    private int action;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}