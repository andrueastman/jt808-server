package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.QueryAreaOrLineData)
public class T8608 extends JTMessage {

    /** @see com.jt808.protocol.commons.Shape */
    @Field(length = 1, desc = "Query type: 1. Circle 2. Rectangle 3. Polygon 4. Route")
    private int type;
    @Field(totalUnit = 4, desc = "area list")
    private int[] id;

    public T8608() {
    }

    public T8608(int type, int... id) {
        this.type = type;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }
}