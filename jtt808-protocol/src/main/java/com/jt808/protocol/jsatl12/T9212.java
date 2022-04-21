package com.jt808.protocol.jsatl12;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JSATL12;

@Message(JSATL12.FileUploadCompleteMessageResponse)
public class T9212 extends JTMessage {

    @Field(lengthUnit = 1, desc = "file name")
    private String name;
    @Field(length = 1, desc = "File type: 0. Picture 1. Audio 2. Video 3. Text 4. Facial feature picture (Cantonese standard) 5. Others")
    private int type;
    @Field(length = 1, desc = "Upload result: 0. Completed 1. Supplementary upload required")
    private int result;
    @Field(length = 1, desc = "Number of supplementary packets")
    private int total;
    @Field(desc = "Complementary packet list [offset,length,offset,length...]")
    private int[] items;

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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        if (items != null && items.length > 1) {
            this.items = items;
            this.total = items.length / 2;
        }
    }
}