package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import io.github.yezhihao.protostar.util.KeyValuePair;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;
import com.jt808.protocol.commons.transform.PassthroughConverter;


@Message(JT808.DataDownlinkTransparentTransmission)
public class T8900 extends JTMessage {

    /** GNSS module detailed positioning data */
    public static final int GNSSLocation = 0x00;
    /** The upload message of the road transport permit IC card information is 64 Bytes, the downlink message is 24 Bytes, and the transparent transmission timeout time of the road transport permit IC card authentication is 30 s. After the timeout, it will not be resent. */
    public static final int ICCardInfo = 0x0B;
    /** Serial port 1 transparently transmits messages */
    public static final int SerialPortOne = 0x41;
    /** Serial port 2 transparently transmits messages */
    public static final int SerialPortTow = 0x42;
    /** User-defined transparent transmission 0xF0~0xFF */
    public static final int Custom = 0xF0;

    @Field(desc = "Transparent message", converter = PassthroughConverter.class)
    private KeyValuePair<Integer, Object> message;

    public T8900() {
    }

    public T8900(KeyValuePair<Integer, Object> message) {
        this.message = message;
    }

    public KeyValuePair<Integer, Object> getMessage() {
        return message;
    }

    public void setMessage(KeyValuePair<Integer, Object> message) {
        this.message = message;
    }
}