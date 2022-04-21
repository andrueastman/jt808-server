package com.jt808.protocol.t1078;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message(JT1078.RemoteVideoPlaybackControlIssuedByThePlatform)
public class T9202 extends JTMessage {

    @Field(length = 1, desc = "logical channel number")
    private int channelNo;
    @Field(length = 1, desc = "Playback control: 0. Start playback 1. Pause playback 2. End playback 3. Fast forward playback 4. Key frame fast rewind playback 5. Drag playback 6. Key frame playback")
    private int playbackMode;
    @Field(length = 1, desc = "Fast forward or fast reverse multiple: 0. Invalid 1.1 times 2.2 times 3.4 times 4.8 times 5.16 times (When the playback control is 3 and 4, the content of this field is valid, otherwise set to 0)")
    private int playbackSpeed;
    @Field(length = 6, charset = "BCD", desc = "Drag playback position (YYMMDDHHMMSS, when playback control is 5, this field is valid)")
    private String playbackTime;

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
    }

    public int getPlaybackMode() {
        return playbackMode;
    }

    public void setPlaybackMode(int playbackMode) {
        this.playbackMode = playbackMode;
    }

    public int getPlaybackSpeed() {
        return playbackSpeed;
    }

    public void setPlaybackSpeed(int playbackSpeed) {
        this.playbackSpeed = playbackSpeed;
    }

    public String getPlaybackTime() {
        return playbackTime;
    }

    public void setPlaybackTime(String playbackTime) {
        this.playbackTime = playbackTime;
    }
}