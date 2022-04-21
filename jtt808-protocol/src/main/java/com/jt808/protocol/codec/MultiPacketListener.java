package com.jt808.protocol.codec;

public class MultiPacketListener {

    protected long timeout;

    public MultiPacketListener() {
        this(30);
    }

    public MultiPacketListener(int timeout) {
        this.timeout = timeout * 1000;
    }

    public boolean receiveTimeout(MultiPacket multiPacket) {
        return false;
    }
}