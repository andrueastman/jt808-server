package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.TerminalAuthentication)
public class T0102 extends JTMessage {

    /** 终端重连后上报鉴权码 */
    @Field(desc = "Authentication code", version = {-1, 0})
    @Field(lengthUnit = 1, desc = "Authentication code", version = 1)
    private String token;
    @Field(length = 15, desc = "Terminal IMEI", version = 1)
    private String imei;
    @Field(length = 20, desc = "software version number", version = 1)
    private String softwareVersion;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }
}