package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.IssueTheTerminalUpgradePackage)
public class T8108 extends JTMessage {

    public static final int Terminal = 0;
    public static final int CardReader = 12;
    public static final int Beidou = 52;

    @Field(length = 1, desc = "upgrade type")
    private int type;
    @Field(length = 5, desc = "Manufacturer ID, terminal manufacturer code")
    private String makerId;
    @Field(lengthUnit = 1, desc = "version number")
    private String version;
    @Field(lengthUnit = 4, desc = "data pack")
    private byte[] packet;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMakerId() {
        return makerId;
    }

    public void setMakerId(String makerId) {
        this.makerId = makerId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public byte[] getPacket() {
        return packet;
    }

    public void setPacket(byte[] packet) {
        this.packet = packet;
    }
}