package com.jt808.protocol.commons.transform.parameter;

import io.github.yezhihao.protostar.Schema;
import io.github.yezhihao.protostar.annotation.Field;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class ParamChannels {

    public static final int key = 0x0076;

    public static final Schema<ParamChannels> SCHEMA = new ParamChannelsSchema();

    @Field(desc = "Total number of audio and video channels")
    private byte audioVideoChannels;
    @Field(desc = "Total number of audio channels")
    private byte audioChannels;
    @Field(desc = "Total number of video channels")
    private byte videoChannels;
    @Field(desc = "Audio and video channel comparison table")
    private List<ChannelInfo> channels;

    public ParamChannels() {
    }

    public byte getAudioVideoChannels() {
        return audioVideoChannels;
    }

    public void setAudioVideoChannels(byte audioVideoChannels) {
        this.audioVideoChannels = audioVideoChannels;
    }

    public byte getAudioChannels() {
        return audioChannels;
    }

    public void setAudioChannels(byte audioChannels) {
        this.audioChannels = audioChannels;
    }

    public byte getVideoChannels() {
        return videoChannels;
    }

    public void setVideoChannels(byte videoChannels) {
        this.videoChannels = videoChannels;
    }

    public List<ChannelInfo> getChannels() {
        return channels;
    }

    public void setChannels(List<ChannelInfo> channels) {
        this.channels = channels;
    }

    private static class ChannelInfo {
        @Field(desc = "Physical channel number (starting from 1)")
        private byte channelId;
        @Field(desc = "Logical channel number (as per table 2 in JTT 1076-2016)")
        private byte channelNo;
        @Field(desc = "Channel Type: 0. Audio Video 1. Audio 2. Video")
        private byte channelType;
        @Field(desc = "Whether the gimbal is connected (when the type is 0 and 2, this field is valid): 0. Not connected 1. Connected")
        private boolean hasPanTilt;

        public ChannelInfo() {
        }

        public ChannelInfo(byte channelId, byte channelNo, byte channelType, boolean hasPanTilt) {
            this.channelId = channelId;
            this.channelNo = channelNo;
            this.channelType = channelType;
            this.hasPanTilt = hasPanTilt;
        }

        public byte getChannelId() {
            return channelId;
        }

        public void setChannelId(byte channelId) {
            this.channelId = channelId;
        }

        public byte getChannelNo() {
            return channelNo;
        }

        public void setChannelNo(byte channelNo) {
            this.channelNo = channelNo;
        }

        public byte getChannelType() {
            return channelType;
        }

        public void setChannelType(byte channelType) {
            this.channelType = channelType;
        }

        public boolean isHasPanTilt() {
            return hasPanTilt;
        }

        public void setHasPanTilt(boolean hasPanTilt) {
            this.hasPanTilt = hasPanTilt;
        }
    }

    private static class ParamChannelsSchema implements Schema<ParamChannels> {

        private ParamChannelsSchema() {
        }

        @Override
        public ParamChannels readFrom(ByteBuf input) {
            ParamChannels message = new ParamChannels();
            message.audioVideoChannels = input.readByte();
            message.audioChannels = input.readByte();
            message.videoChannels = input.readByte();

            List<ChannelInfo> channels = new ArrayList<>(4);
            while (input.isReadable()) {
                byte channelId = input.readByte();
                byte channelNo = input.readByte();
                byte channelType = input.readByte();
                boolean hasPanTilt = input.readBoolean();
                channels.add(new ChannelInfo(channelId, channelNo, channelType, hasPanTilt));
            }
            message.setChannels(channels);
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, ParamChannels message) {
            output.writeByte(message.audioVideoChannels);
            output.writeByte(message.audioChannels);
            output.writeByte(message.videoChannels);

            List<ChannelInfo> channelInfos = message.getChannels();
            for (ChannelInfo channelInfo : channelInfos) {
                output.writeByte(channelInfo.channelId);
                output.writeByte(channelInfo.channelNo);
                output.writeByte(channelInfo.channelType);
                output.writeBoolean(channelInfo.hasPanTilt);
            }
        }
    }
}