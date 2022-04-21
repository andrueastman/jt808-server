package com.jt808.protocol.commons.transform.attribute;

import io.github.yezhihao.protostar.annotation.Field;
import com.jt808.protocol.jsatl12.AlarmId;

import java.time.LocalDateTime;

/**
 * Blind spot monitoring 0x67
 */
public class AlarmBSD implements Alarm {

    public static final int key = 103;

    @Field(length = 4, desc = "Alarm ID")
    private long id;
    @Field(length = 1, desc = "Flag status: 0. Unavailable 1. Start flag 2. End flag")
    private int state;
    @Field(length = 1, desc = "Alarm event type: 1. Rear proximity alarm 2. Left rear proximity alarm 3. Right rear proximity alarm")
    private int type;
    @Field(length = 1, desc = "speed of a motor vehicle")
    private int speed;
    @Field(length = 2, desc = "Elevation")
    private int altitude;
    @Field(length = 4, desc = "Latitude")
    private int latitude;
    @Field(length = 4, desc = "Longitude")
    private int longitude;
    @Field(length = 6, charset = "BCD", desc = "Datetime")
    private LocalDateTime dateTime;
    @Field(length = 2, desc = "vehicle status")
    private int statusBit;
    @Field(length = 16, desc = "Alarm identification number", version = {-1, 0})
    @Field(length = 40, desc = "Alarm identification number (Cantonese standard)", version = 1)
    private AlarmId alarmId;

    @Override
    public int getCategory() {
        return key;
    }

    @Override
    public int getAlarmType() {
        return Alarm.buildType(key, type);
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getSerialNo() {
        return alarmId.getSerialNo();
    }

    @Override
    public int getFileTotal() {
        return alarmId.getFileTotal();
    }

    @Override
    public String getExtra() {
        return null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getStatusBit() {
        return statusBit;
    }

    public void setStatusBit(int statusBit) {
        this.statusBit = statusBit;
    }

    public AlarmId getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(AlarmId alarmId) {
        this.alarmId = alarmId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(300);
        sb.append("AlarmBSD{id=").append(id);
        sb.append(", state=").append(state);
        sb.append(", type=").append(type);
        sb.append(", speed=").append(speed);
        sb.append(", altitude=").append(altitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", statusBit=").append(statusBit);
        sb.append(", alarmId=").append(alarmId);
        sb.append('}');
        return sb.toString();
    }
}