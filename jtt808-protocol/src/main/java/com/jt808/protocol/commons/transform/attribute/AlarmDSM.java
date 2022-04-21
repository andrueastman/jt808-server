package com.jt808.protocol.commons.transform.attribute;

import io.github.yezhihao.protostar.annotation.Field;
import com.jt808.protocol.jsatl12.AlarmId;

import java.time.LocalDateTime;

/**
 * 驾驶员状态监测 0x65
 */
public class AlarmDSM implements Alarm {

    public static final int key = 101;

    @Field(length = 4, desc = "Alarm ID")
    private long id;
    @Field(length = 1, desc = "Flag status: 0. Unavailable 1. Start flag 2. End flag")
    private int state;
    @Field(length = 1, desc = "Alarm event type：" +
            " 1.Fatigue driving alarm" +
            " 2.call the police" +
            " 3.smoking alarm" +
            " 4.Distracted driving alarm | do not look ahead alarm (Cantonese standard)" +
            " 5.Driver abnormal alarm" +
            " 6.Probe occlusion alarm (Cantonese standard)" +
            " 7.Custom" +
            " 8.Overtime driving alarm (Cantonese standard)" +
            " 9.Custom" +
            " 10.Not wearing seat belt alarm (Cantonese standard)" +
            " 11.Infrared blocking sunglasses failure alarm (Guangdong standard)" +
            " 12.Double off handle alarm (both hands off the steering wheel at the same time) (Cantonese standard)" +
            " 13.Play mobile phone alarm (Cantonese standard)" +
            " 14.Custom" +
            " 15.Custom" +
            " 16.Automatically capture events" +
            " 17.driver change event" +
            " 18~31.Custom")
    private int type;
    @Field(length = 1, desc = "Alarm level")
    private int level;
    @Field(length = 1, desc = "degree of fatigue")
    private int fatigueDegree;
    @Field(length = 4, desc = "Reserved")
    private int reserved;
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
    @Field(length = 2, desc = "VehicleStatus")
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
    public int getSerialNo() {
        return alarmId.getSerialNo();
    }

    @Override
    public int getFileTotal() {
        return alarmId.getFileTotal();
    }

    @Override
    public String getExtra() {
        return "fatigueDegree:" + fatigueDegree;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFatigueDegree() {
        return fatigueDegree;
    }

    public void setFatigueDegree(int fatigueDegree) {
        this.fatigueDegree = fatigueDegree;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
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
        final StringBuilder sb = new StringBuilder(400);
        sb.append("AlarmDSM{id=").append(id);
        sb.append(", state=").append(state);
        sb.append(", type=").append(type);
        sb.append(", level=").append(level);
        sb.append(", fatigueDegree=").append(fatigueDegree);
        sb.append(", reserved=").append(reserved);
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