package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.TemporaryPositionTrackingControl)
public class T8202 extends JTMessage {

    @Field(length = 2, desc = "time interval (seconds)")
    private int interval;
    @Field(length = 4, desc = "Validity period (seconds)")
    private int validityPeriod;

    public T8202() {
    }

    public T8202(int interval, int validityPeriod) {
        this.interval = interval;
        this.validityPeriod = validityPeriod;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(int validityPeriod) {
        this.validityPeriod = validityPeriod;
    }
}