package com.jt808.protocol.t808;

import io.github.yezhihao.netmc.core.model.Response;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.ManualAcknowledgmentOfAlarmMessages)
public class T8203 extends JTMessage implements Response {

    @Field(length = 2, desc = "message serial number")
    private int responseSerialNo;
    @Field(length = 4, desc = "alarm type：" +
            " [0]Acknowledge emergency alarm" +
            " [1~2]reservation" +
            " [3]Confirm hazard warning" +
            " [4~19]reservation" +
            " [20]Acknowledging entry and exit zone alarms" +
            " [21]Confirm the incoming and outgoing route alarm" +
            " [22]Confirm that the driving time of the road section is insufficient and too long to alarm" +
            " [23~26]reservation" +
            " [27]Confirm the vehicle illegal ignition alarm" +
            " [28]Confirmation of illegal vehicle displacement alarm" +
            " [29~31]reservation")
    private int type;

    public T8203() {
    }

    public T8203(int responseSerialNo, int type) {
        this.responseSerialNo = responseSerialNo;
        this.type = type;
    }

    public int getResponseSerialNo() {
        return responseSerialNo;
    }

    public void setResponseSerialNo(int responseSerialNo) {
        this.responseSerialNo = responseSerialNo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}