package com.jt808.protocol.t1078;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message(JT1078.PtzRotation)
public class T9301 extends JTMessage {

    @Field(length = 1, desc = "logical channel number")
    private int channelNo;
    @Field(length = 1, desc = "Direction: 0. Stop 1. Up 2. Down 3. Left 4. Right")
    private int param1;
    @Field(length = 1, desc = "Speed (0~255)")
    private int param2;

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
    }

    public int getParam1() {
        return param1;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }
}
