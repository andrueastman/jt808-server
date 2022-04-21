package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message({JT808.DeleteCircularArea, JT808.DeleteRectangularArea, JT808.DeletePolygonArea, JT808.DeleteRoute})
public class T8601 extends JTMessage {

    @Field(totalUnit = 1, desc = "area list")
    private int[] id;

    public T8601() {
    }

    public T8601(int... id) {
        this.id = id;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }
}