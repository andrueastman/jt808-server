package com.jt808.protocol.t1078;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;

@Message(JT1078.TerminalUploadAudioAndVideoAttributes)
public class T1003 extends JTMessage {

    @Field(length = 1, desc = "input audio codec")
    private int audioFormat;
    @Field(length = 1, desc = "Number of input audio channels")
    private int audioChannels;
    @Field(length = 1, desc = "Input audio sample rate：0.8kHz 1.22.05kHz 2.44.1kHz 3.48kHz")
    private int audioSamplingRate;
    @Field(length = 1, desc = "Input audio sample bits：0.8位 1.16位 2.32位")
    private int audioBitDepth;
    @Field(length = 2, desc = "audio frame length")
    private int audioFrameLength;
    @Field(length = 1, desc = "Whether to support audio output")
    private int audioSupport;
    @Field(length = 1, desc = "Video encoding method")
    private int videoFormat;
    @Field(length = 1, desc = "The maximum audio physical channel supported by the terminal")
    private int maxAudioChannels;
    @Field(length = 1, desc = "The maximum video physical channel supported by the terminal")
    private int maxVideoChannels;

    public int getAudioFormat() {
        return audioFormat;
    }

    public void setAudioFormat(int audioFormat) {
        this.audioFormat = audioFormat;
    }

    public int getAudioChannels() {
        return audioChannels;
    }

    public void setAudioChannels(int audioChannels) {
        this.audioChannels = audioChannels;
    }

    public int getAudioSamplingRate() {
        return audioSamplingRate;
    }

    public void setAudioSamplingRate(int audioSamplingRate) {
        this.audioSamplingRate = audioSamplingRate;
    }

    public int getAudioBitDepth() {
        return audioBitDepth;
    }

    public void setAudioBitDepth(int audioBitDepth) {
        this.audioBitDepth = audioBitDepth;
    }

    public int getAudioFrameLength() {
        return audioFrameLength;
    }

    public void setAudioFrameLength(int audioFrameLength) {
        this.audioFrameLength = audioFrameLength;
    }

    public int getAudioSupport() {
        return audioSupport;
    }

    public void setAudioSupport(int audioSupport) {
        this.audioSupport = audioSupport;
    }

    public int getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(int videoFormat) {
        this.videoFormat = videoFormat;
    }

    public int getMaxAudioChannels() {
        return maxAudioChannels;
    }

    public void setMaxAudioChannels(int maxAudioChannels) {
        this.maxAudioChannels = maxAudioChannels;
    }

    public int getMaxVideoChannels() {
        return maxVideoChannels;
    }

    public void setMaxVideoChannels(int maxVideoChannels) {
        this.maxVideoChannels = maxVideoChannels;
    }
}