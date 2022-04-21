package com.jt808.protocol.jsatl12;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import io.netty.buffer.ByteBuf;
import com.jt808.protocol.basics.JTMessage;

@Message
public class DataPacket extends JTMessage {

    @Field(length = 4, desc = "frame header identifier")
    private int flag;
    @Field(length = 50, desc = "file name")
    private String name;
    @Field(length = 4, desc = "data offset")
    private int offset;
    @Field(length = 4, desc = "Data length")
    private int length;
    @Field(desc = "data body")
    private ByteBuf data;

    @Override
    public String getClientId() {
        if (session != null)
            return session.getClientId();
        return null;
    }

    @Override
    public int getMessageId() {
        return flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ByteBuf getData() {
        return data;
    }

    public void setData(ByteBuf data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(120);
        sb.append("DataPacket{name=").append(name);
        sb.append(",offset=").append(offset);
        sb.append(",length=").append(length);
        sb.append(",data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}