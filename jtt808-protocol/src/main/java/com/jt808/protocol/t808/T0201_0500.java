package com.jt808.protocol.t808;

import io.github.yezhihao.netmc.core.model.Response;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.MergeSuperclass;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.commons.JT808;

@MergeSuperclass
@Message({JT808.LocationInformationQueryResponse, JT808.VehicleControlResponse})
public class T0201_0500 extends T0200 implements Response {

    @Field(length = 2, desc = "Reply serial number")
    private int responseSerialNo;

    @Override
    public int getResponseSerialNo() {
        return responseSerialNo;
    }

    public void setResponseSerialNo(int responseSerialNo) {
        this.responseSerialNo = responseSerialNo;
    }
}