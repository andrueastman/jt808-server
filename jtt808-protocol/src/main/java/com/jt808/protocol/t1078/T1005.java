package com.jt808.protocol.t1078;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message(JT1078.TerminalUploadPassengerTraffic)
public class T1005 extends JTMessage {

    @Field(length = 6, charset = "BCD", desc = "start time(YYMMDDHHMMSS)")
    private String startTime;
    @Field(length = 6, charset = "BCD", desc = "End Time(YYMMDDHHMMSS)")
    private String endTime;
    @Field(length = 2, desc = "Number of people getting on board from start time to end time")
    private int getOnCount;
    @Field(length = 2, desc = "Number of people getting off from the start time to the end time")
    private int getOffCount;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getGetOnCount() {
        return getOnCount;
    }

    public void setGetOnCount(int getOnCount) {
        this.getOnCount = getOnCount;
    }

    public int getGetOffCount() {
        return getOffCount;
    }

    public void setGetOffCount(int getOffCount) {
        this.getOffCount = getOffCount;
    }
}