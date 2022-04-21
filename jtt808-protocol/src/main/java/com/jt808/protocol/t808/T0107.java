package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.QueryTerminalPropertiesReply)
public class T0107 extends JTMessage {

    @Field(length = 2, desc = "terminal type")
    private int deviceType;
    @Field(length = 5, desc = "Manufacturer ID, terminal manufacturer code")
    private String makerId;
    @Field(length = 20, desc = "Terminal model", version = {-1, 0})
    @Field(length = 30, desc = "Terminal model", version = 1)
    private String deviceModel;
    @Field(length = 7, desc = "Terminal ID", version = {-1, 0})
    @Field(length = 30, desc = "Terminal ID", version = 1)
    private String deviceId;
    @Field(length = 10, charset = "HEX", desc = "Terminal SIM card ICCID")
    private String iccid;
    @Field(lengthUnit = 1, desc = "Hardware version number")
    private String hardwareVersion;
    @Field(lengthUnit = 1, desc = "Firmware version number")
    private String firmwareVersion;
    @Field(length = 1, desc = "GNSS Module Properties")
    private int gnssAttribute;
    @Field(length = 1, desc = "Communication Module Properties")
    private int networkAttribute;

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getMakerId() {
        return makerId;
    }

    public void setMakerId(String makerId) {
        this.makerId = makerId;
    }

    /** Defined by the manufacturer, if the number of digits is insufficient, "0 x 00" will be added after */
    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    /** Composed of uppercase letters and numbers, the terminal ID is defined by the manufacturer. When the number of digits is insufficient, "0 x 00" will be added afterward. */
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public int getGnssAttribute() {
        return gnssAttribute;
    }

    public void setGnssAttribute(int gnssAttribute) {
        this.gnssAttribute = gnssAttribute;
    }

    public int getNetworkAttribute() {
        return networkAttribute;
    }

    public void setNetworkAttribute(int networkAttribute) {
        this.networkAttribute = networkAttribute;
    }
}