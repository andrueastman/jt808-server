package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

import java.util.List;


@Message(JT808.BulkUploadOfPositioningData)
public class T0704 extends JTMessage {

    @Field(length = 2, desc = "number of data items")
    private int total;
    @Field(length = 1, desc = "Position data type: 0. Batch report of normal position 1. Blind area supplementary report")
    private int type;
    @Field(lengthUnit = 2, desc = "location reporting data item")
    private List<T0200> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<T0200> getItems() {
        return items;
    }

    public void setItems(List<T0200> items) {
        this.items = items;
        this.total = items.size();
    }
}