package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.TerminalRegistration)
public class T0100 extends JTMessage {

    @Field(length = 2, desc = "Province ID")
    private int provinceId;
    @Field(length = 2, desc = "City and county ID")
    private int cityId;
    @Field(length = 5, desc = "Manufacturer ID", version = {-1, 0})
    @Field(length = 11, desc = "Manufacturer ID", version = 1)
    private String makerId;
    @Field(length = 8, desc = "Terminal model", version = -1)
    @Field(length = 20, desc = "Terminal model", version = 0)
    @Field(length = 30, desc = "Terminal model", version = 1)
    private String deviceModel;
    @Field(length = 7, desc = "Terminal ID", version = {-1, 0})
    @Field(length = 30, desc = "Terminal ID", version = 1)
    private String deviceId;
    @Field(length = 1, desc = "License plate color: 0. No license plate 1. Blue 2. Yellow 3. Black 4. White 9. Others")
    private int plateColor;
    @Field(desc = "vehicle identification")
    private String plateNo;

    /** The province where the equipment is installed and the vehicle is located, the provincial ID adopts the first two of the 6 digits of the administrative division code specified in GBT 2260 */
    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    /** The city or county where the equipment is installed and the vehicle is located. The city and county ID adopts the last four digits of the 6-digit administrative division code specified in GBT 2260. */
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    /** Terminal Manufacturer Code */

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

    /** Composed of capital letters and numbers, this terminal ID is defined by the manufacturer*/
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /** According to 5.4.12 of JTT 415-2006 */
    public int getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(int licensePlate) {
        this.plateColor = licensePlate;
    }

    /** When the color of the license plate is 0, it means the vehicle VIN; otherwise, it means the motor vehicle number plate issued by the public security traffic management department*/
    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    @Override
    public int getProtocolVersion() {
        int bodyLength = getBodyLength();
        if (bodyLength > 0 && bodyLength < 37)
            return -1;
        return super.getProtocolVersion();
    }
}