package com.jt808.protocol.jsatl12;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JSATL12;

@Message({JSATL12.FileInformationUpload, JSATL12.FileUploadCompleteMessage})
public class T1211 extends JTMessage {

    @Field(lengthUnit = 1, desc = "file name")
    private String name;
    @Field(length = 1, desc = "File Type 0.Picture 1.Audio 2.Video 3.Text 4.Facial Feature Picture (Cantonese Standard) 5.Other")
    private int type;
    @Field(length = 4, desc = "File size")
    private long size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}