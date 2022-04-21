package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message({JT808.PlatformRSAPublicKey, JT808.TerminalRSAPublicKey})
public class T0A00_8A00 extends JTMessage {

    @Field(length = 4, desc = "e in RSA public key {e,n}")
    private int e;
    @Field(length = 128, desc = "n in RSA public key {e,n}")
    private byte[] n;

    public T0A00_8A00() {
    }

    public T0A00_8A00(int e, byte[] n) {
        this.e = e;
        this.n = n;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public byte[] getN() {
        return n;
    }

    public void setN(byte[] n) {
        this.n = n;
    }
}