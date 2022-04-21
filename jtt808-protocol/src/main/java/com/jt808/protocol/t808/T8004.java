package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

import java.time.LocalDateTime;

@Message(JT808.QueryServerTimeResponse)
public class T8004 extends JTMessage {

    @Field(length = 6, charset = "BCD", desc = "UTC time")
    private LocalDateTime dateTime;

    public T8004() {
    }

    public T8004(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}