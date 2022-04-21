package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.Bit;
import com.jt808.protocol.commons.JT808;

@Message(JT808.TextMessageDelivery)
public class T8300 extends JTMessage {

    @Field(length = 1, desc = "sign：" +
            " [0]urgent" +
            " [1]reservation" +
            " [2]terminal display" +
            " [3]Terminal TTS play and read" +
            " [4]Advertising screen display" +
            " [5]0. Center navigation information | 1. CAN fault code information" +
            " [6~7]reservation")
    private int sign;
    @Field(length = 1, desc = "Type: 1. Notification 2. Service", version = 1)
    private int type;
    @Field(desc = "content", version = {0, 1})
    private String content;

    public T8300() {
    }

    public T8300(String content, int... sign) {
        this.content = content;
        this.sign = Bit.writeInt(sign);
    }

    public T8300(int type, String content, int... sign) {
        this.type = type;
        this.content = content;
        this.sign = Bit.writeInt(sign);
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}