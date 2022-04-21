package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;
import com.jt808.protocol.commons.transform.AttributeConverter;
import com.jt808.protocol.commons.transform.AttributeConverterYue;

import java.util.Map;

@Message(JT808.LocationInformationReport)
public class T0200 extends JTMessage {

    @Field(length = 4, desc = "alarm sign")
    private int warnBit;
    @Field(length = 4, desc = "status")
    private int statusBit;
    @Field(length = 4, desc = "latitude")
    private int latitude;
    @Field(length = 4, desc = "longitude")
    private int longitude;
    @Field(length = 2, desc = "Elevation (m)")
    private int altitude;
    @Field(length = 2, desc = "Speed (110 km/h)")
    private int speed;
    @Field(length = 2, desc = "direction")
    private int direction;
    @Field(length = 6, charset = "BCD", desc = "time(YYMMDDHHMMSS)")
    private String dateTime;
    @Field(desc = "Location Additional Information", converter = AttributeConverter.class, version = {-1, 0})
    @Field(desc = "Additional Location Information (Cantonese Standard)", converter = AttributeConverterYue.class, version = 1)
    private Map<Integer, Object> attributes;

    public int getWarnBit() {
        return warnBit;
    }

    public void setWarnBit(int warnBit) {
        this.warnBit = warnBit;
    }

    public int getStatusBit() {
        return statusBit;
    }

    public void setStatusBit(int statusBit) {
        this.statusBit = statusBit;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Map<Integer, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<Integer, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        StringBuilder sb = toStringHead();
        sb.append("T0200{dateTime=").append(dateTime);
        sb.append(",longitude=").append(longitude);
        sb.append(",latitude=").append(latitude);
        sb.append(",altitude=").append(altitude);
        sb.append(",speed=").append(speed);
        sb.append(",direction=").append(direction);
        sb.append(",warnBit=").append(Integer.toBinaryString(warnBit));
        sb.append(",statusBit=").append(Integer.toBinaryString(statusBit));
        sb.append(",attributes=").append(attributes);
        sb.append('}');
        return sb.toString();
    }
}