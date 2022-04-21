package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.Bit;
import com.jt808.protocol.commons.JT808;

@Message(JT808.VehicleControl)
public class T8500 extends JTMessage {

    @Field(length = 1, desc = "control sign：" +
            " [0  ]0. Door unlock 1. Door lock" +
            " [1~7]RESERVE")
    private int sign;

    public T8500() {
    }

    public T8500(int... sign) {
        this.sign = Bit.writeInt(sign);
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }
}