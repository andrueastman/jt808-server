package com.jt808.protocol.t1078;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message({JT1078.PtzAdjustmentFocusControl, JT1078.GimbalAdjustmentApertureControl, JT1078.PtzWiperControl, JT1078.InfraredFillLightControl, JT1078.PtzZoomControl})
public class T9302 extends JTMessage {

    @Field(length = 1, desc = "logical channel number")
    private int channelNo;
    @Field(length = 1, desc = "Parameter(0. Increase 1. Decrease)|(0. Stop 1. Start)")
    private int param;

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
    }

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }
}