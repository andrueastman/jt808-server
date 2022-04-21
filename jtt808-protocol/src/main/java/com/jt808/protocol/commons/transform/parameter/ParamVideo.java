package com.jt808.protocol.commons.transform.parameter;

import io.github.yezhihao.protostar.Schema;
import io.github.yezhihao.protostar.annotation.Field;
import io.netty.buffer.ByteBuf;

public class ParamVideo {

    public static final int key = 0x0075;

    public static final Schema<ParamVideo> SCHEMA = new ParamVideoSchema();

    protected static final Schema<ParamVideo> SCHEMA_2 = new ParamVideoSchema2();

    @Field(desc = "Real-time stream encoding mode: 0.CBR (fixed bit rate) 1.VBR (variable bit rate) 2.ABR (average bit rate) 100~ 127.Custom")
    private byte realtimeEncode;
    @Field(desc = "Live Streaming Resolution: 0.QCIF 1.CIF 2.WCIF 3.D1 4.WD1 5.720P 6.1080P 100~127.Custom")
    private byte realtimeResolution;
    @Field(desc = "Live stream key frame interval (1~1000 frames)")
    private short realtimeFrameInterval;
    @Field(desc = "Real-time streaming target frame rate (1~120 frames)")
    private byte realtimeFrameRate;
    @Field(desc = "Real-time streaming target bit rate (kbps)")
    private int realtimeBitRate;

    @Field(desc = "Stored stream encoding mode: 0.CBR (fixed bit rate) 1.VBR (variable bit rate) 2.ABR (average bit rate) 100~ 127.Custom")
    private byte storageEncode;
    @Field(desc = "Store stream resolution: 0.QCIF 1.CIF 2.WCIF 3.D1 4.WD1 5.720P 6.1080P 100~127.Custom")
    private byte storageResolution;
    @Field(desc = "Store stream key frame interval (1~1000 frames)")
    private short storageFrameInterval;
    @Field(desc = "Store stream target frame rate (1~120 frames)")
    private byte storageFrameRate;
    @Field(desc = "Store stream target bit rate (kbps)")
    private int storageBitRate;

    @Field(desc = "OSD subtitle overlay settings (bitwise, 0. means no overlay 1. means overlay):" +
            " [0]date and time" +
            " [1]License plate number" +
            " [2]logical channel number" +
            " [3]latitude and longitude" +
            " [4]driving record speed" +
            " [5]satellite positioning speed" +
            " [6]Continuous driving time" +
            " [7~l0]Reserve" +
            " [11~l5]Customize")
    private short odsConfig;
    @Field(desc = "Whether to enable audio output: 0. not enabled 1. enabled")
    private byte audioEnable;

    public ParamVideo() {
    }

    public byte getRealtimeEncode() {
        return realtimeEncode;
    }

    public void setRealtimeEncode(byte realtimeEncode) {
        this.realtimeEncode = realtimeEncode;
    }

    public byte getRealtimeResolution() {
        return realtimeResolution;
    }

    public void setRealtimeResolution(byte realtimeResolution) {
        this.realtimeResolution = realtimeResolution;
    }

    public short getRealtimeFrameInterval() {
        return realtimeFrameInterval;
    }

    public void setRealtimeFrameInterval(short realtimeFrameInterval) {
        this.realtimeFrameInterval = realtimeFrameInterval;
    }

    public byte getRealtimeFrameRate() {
        return realtimeFrameRate;
    }

    public void setRealtimeFrameRate(byte realtimeFrameRate) {
        this.realtimeFrameRate = realtimeFrameRate;
    }

    public int getRealtimeBitRate() {
        return realtimeBitRate;
    }

    public void setRealtimeBitRate(int realtimeBitRate) {
        this.realtimeBitRate = realtimeBitRate;
    }

    public byte getStorageEncode() {
        return storageEncode;
    }

    public void setStorageEncode(byte storageEncode) {
        this.storageEncode = storageEncode;
    }

    public byte getStorageResolution() {
        return storageResolution;
    }

    public void setStorageResolution(byte storageResolution) {
        this.storageResolution = storageResolution;
    }

    public short getStorageFrameInterval() {
        return storageFrameInterval;
    }

    public void setStorageFrameInterval(short storageFrameInterval) {
        this.storageFrameInterval = storageFrameInterval;
    }

    public byte getStorageFrameRate() {
        return storageFrameRate;
    }

    public void setStorageFrameRate(byte storageFrameRate) {
        this.storageFrameRate = storageFrameRate;
    }

    public int getStorageBitRate() {
        return storageBitRate;
    }

    public void setStorageBitRate(int storageBitRate) {
        this.storageBitRate = storageBitRate;
    }

    public short getOdsConfig() {
        return odsConfig;
    }

    public void setOdsConfig(short odsConfig) {
        this.odsConfig = odsConfig;
    }

    public byte getAudioEnable() {
        return audioEnable;
    }

    public void setAudioEnable(byte audioEnable) {
        this.audioEnable = audioEnable;
    }

    private static class ParamVideoSchema implements Schema<ParamVideo> {

        private ParamVideoSchema() {
        }

        @Override
        public ParamVideo readFrom(ByteBuf input) {
            ParamVideo message = new ParamVideo();
            message.realtimeEncode = input.readByte();
            message.realtimeResolution = input.readByte();
            message.realtimeFrameInterval = input.readShort();
            message.realtimeFrameRate = input.readByte();
            message.realtimeBitRate = input.readInt();

            message.storageEncode = input.readByte();
            message.storageResolution = input.readByte();
            message.storageFrameInterval = input.readShort();
            message.storageFrameRate = input.readByte();
            message.storageBitRate = input.readInt();

            message.odsConfig = input.readShort();
            message.audioEnable = input.readByte();
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, ParamVideo message) {
            output.writeByte(message.realtimeEncode);
            output.writeByte(message.realtimeResolution);
            output.writeShort(message.realtimeFrameInterval);
            output.writeByte(message.realtimeFrameRate);
            output.writeInt(message.realtimeBitRate);

            output.writeByte(message.storageEncode);
            output.writeByte(message.storageResolution);
            output.writeShort(message.storageFrameInterval);
            output.writeByte(message.storageFrameRate);
            output.writeInt(message.storageBitRate);

            output.writeShort(message.odsConfig);
            output.writeByte(message.audioEnable);
        }
    }

    public static class ParamVideoSchema2 implements Schema<ParamVideo> {

        private ParamVideoSchema2() {
        }

        @Override
        public ParamVideo readFrom(ByteBuf input) {
            ParamVideo message = new ParamVideo();
            message.realtimeEncode = input.readByte();
            message.realtimeResolution = input.readByte();
            message.realtimeFrameInterval = input.readShort();
            message.realtimeFrameRate = input.readByte();
            message.realtimeBitRate = input.readInt();

            message.storageEncode = input.readByte();
            message.storageResolution = input.readByte();
            message.storageFrameInterval = input.readShort();
            message.storageFrameRate = input.readByte();
            message.storageBitRate = input.readInt();

            message.odsConfig = input.readShort();
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, ParamVideo message) {
            output.writeByte(message.realtimeEncode);
            output.writeByte(message.realtimeResolution);
            output.writeShort(message.realtimeFrameInterval);
            output.writeByte(message.realtimeFrameRate);
            output.writeInt(message.realtimeBitRate);

            output.writeByte(message.storageEncode);
            output.writeByte(message.storageResolution);
            output.writeShort(message.storageFrameInterval);
            output.writeByte(message.storageFrameRate);
            output.writeInt(message.storageBitRate);

            output.writeShort(message.odsConfig);
        }
    }
}