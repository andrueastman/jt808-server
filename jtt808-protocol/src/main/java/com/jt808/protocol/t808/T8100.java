package com.jt808.protocol.t808;

import io.github.yezhihao.netmc.core.model.Response;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.TerminalRegistrationResponse)
public class T8100 extends JTMessage implements Response {

    /** 0.success */
    public static final int Success = 0;
    /** 1.the vehicle has been registered */
    public static final int AlreadyRegisteredVehicle = 1;
    /** 2.The vehicle is not in the database */
    public static final int NotFoundVehicle = 2;
    /** 3.Terminal is already registered */
    public static final int AlreadyRegisteredTerminal = 3;
    /** 4.The terminal does not exist in the database */
    public static final int NotFoundTerminal = 4;

    @Field(length = 2, desc = "Reply serial number")
    private int responseSerialNo;
    @Field(length = 1, desc = "Result: 0. Success 1. The vehicle has been registered 2. The vehicle is not in the database 3. The terminal has been registered 4. The terminal is not in the database")
    private int resultCode;
    @Field(desc = "Authentication code (this field is only available after success)")
    private String token;

    public int getResponseSerialNo() {
        return responseSerialNo;
    }

    public void setResponseSerialNo(int responseSerialNo) {
        this.responseSerialNo = responseSerialNo;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}