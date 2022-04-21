package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.DriveRecorderParameterDownloadCommand)
public class T8701 extends JTMessage {

    @Field(length = 1, desc = "Command word：" +
            " 130.Set vehicle information" +
            " 131.Set the date when the recorder was first installed" +
            " 132.Set state child configuration information" +
            " 194.Set the recorder time" +
            " 195.Set the recorder pulse factor" +
            " 196.Set initial mileage" +
            " 197~207.Reserved")
    private int type;
    @Field(desc = "Data block (refer to GBT 19056)")
    private byte[] content;

    public T8701() {
    }

    public T8701(int type, byte[] content) {
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}