package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.CameraShootsCommandImmediately)
public class T8801 extends JTMessage {

    @Field(length = 1, desc = "Channel ID (greater than 0)")
    private int channelId;
    @Field(length = 2, desc = "Shooting command: 0 means stop shooting; 65535 means video recording; other means the number of pictures taken")
    private int command;
    @Field(length = 2, desc = "Shooting interval recording time (seconds) 0 means taking photos at the minimum interval or recording all the time")
    private int time;
    @Field(length = 1, desc = "Save flag: 1. Save 0. Real-time upload")
    private int save;
    @Field(length = 1, desc = "resolution：" +
            " 1.320*240" +
            " 2.640*480" +
            " 3.800*600" +
            " 4.1024*768" +
            " 5.176*144 [QCIF]" +
            " 6.352*288 [CIF]" +
            " 7.704*288 [HALF D1]" +
            " 8.704*576 [D1]")
    private int resolution;
    @Field(length = 1, desc = "Image and video quality (1~10): 1. Represents the smallest quality loss 10. Represents the largest compression ratio")
    private int quality;
    @Field(length = 1, desc = "brightness(0~255)")
    private int brightness;
    @Field(length = 1, desc = "contrast(0~127)")
    private int contrast;
    @Field(length = 1, desc = "saturation(0~127)")
    private int saturation;
    @Field(length = 1, desc = "chroma(0~255)")
    private int chroma;

    public T8801() {
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getContrast() {
        return contrast;
    }

    public void setContrast(int contrast) {
        this.contrast = contrast;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public int getChroma() {
        return chroma;
    }

    public void setChroma(int chroma) {
        this.chroma = chroma;
    }
}