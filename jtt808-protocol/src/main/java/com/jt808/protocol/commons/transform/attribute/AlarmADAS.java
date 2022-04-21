package com.jt808.protocol.commons.transform.attribute;

import io.github.yezhihao.protostar.annotation.Field;
import com.jt808.protocol.jsatl12.AlarmId;

import java.time.LocalDateTime;

/**
 * 高级驾驶辅助系统报警 0x64
 */
public class AlarmADAS implements Alarm {

    public static final int key = 100;

    @Field(length = 4, desc = "Alarm ID")
    private long id;
    @Field(length = 1, desc = "Flag status: 0. Unavailable 1. Start flag 2. End flag")
    private int state;
    @Field(length = 1, desc = "Alarm event type:" +
            " 1. Forward Collision Alarm" +
            " 2.Lane Departure Warning" +
            " 3.car too close alarm" +
            " 4.Pedestrian Collision Alarm" +
            " 5.Frequent lane change alarm" +
            " 6.Road sign overrun alarm" +
            " 7.Obstacle Alarm" +
            " 8~15.Custom" +
            " 16.Road Sign Recognition Incident" +
            " 17.Actively capture events" +
            " 18.Solid line lane change alarm (Cantonese standard)" +
            " 19.Pedestrian detection alarm in carriage aisle (Cantonese standard)" +
            " 18~31.Custom")
    private int type;
    @Field(length = 1, desc = "Alarm level")
    private int level;
    @Field(length = 1, desc = "The speed of the preceding vehicle (Kmh) ranges from 0 to 250, only valid when the alarm type is 1 and 2")
    private int frontSpeed;
    @Field(length = 1, desc = "Pedestrian distance from the preceding vehicle (100 ms), the range is 0~100, only valid when the alarm type is 1, 2 and 4")
    private int frontDistance;
    @Field(length = 1, desc = "Deviation type: 1. Left deviation 2. Right deviation (valid when alarm type is 2)")
    private int deviateType;
    @Field(length = 1, desc = "Types of road sign recognition: 1. Speed limit sign 2. Height limit sign 3. Weight limit sign 4. No-travel sign (Cantonese standard) 5. No-stop sign (Cantonese standard) (valid when the alarm type is 6 and 10)")
    private int roadSign;
    @Field(length = 1, desc = "Road Sign Recognition Data")
    private int roadSignValue;
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
        final StringBuilder sb = new StringBuilder(64);
        if (type == 1 || type == 2) {
            sb.append("frontSpeed:").append(frontSpeed).append(',');
        }
        if (type == 1 || type == 2 || type == 4) {
            sb.append("frontDistance:").append(frontDistance).append(',');
        }
        if (type == 2) {
            sb.append("deviateType:").append(deviateType).append(',');
        }
        if (type == 6 || type == 10) {
            sb.append("roadSign:").append(roadSign).append(',');
            sb.append("roadSignValue:").append(roadSignValue).append(',');
        }
        int length = sb.length();
        if (length > 0)
            return sb.substring(0, length - 1);
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFrontSpeed() {
        return frontSpeed;
    }

    public void setFrontSpeed(int frontSpeed) {
        this.frontSpeed = frontSpeed;
    }

    public int getFrontDistance() {
        return frontDistance;
    }

    public void setFrontDistance(int frontDistance) {
        this.frontDistance = frontDistance;
    }

    public int getDeviateType() {
        return deviateType;
    }

    public void setDeviateType(int deviateType) {
        this.deviateType = deviateType;
    }

    public int getRoadSign() {
        return roadSign;
    }

    public void setRoadSign(int roadSign) {
        this.roadSign = roadSign;
    }

    public int getRoadSignValue() {
        return roadSignValue;
    }

    public void setRoadSignValue(int roadSignValue) {
        this.roadSignValue = roadSignValue;
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
        final StringBuilder sb = new StringBuilder(512);
        sb.append("AlarmADAS{id=").append(id);
        sb.append(", state=").append(state);
        sb.append(", type=").append(type);
        sb.append(", level=").append(level);
        sb.append(", frontSpeed=").append(frontSpeed);
        sb.append(", frontDistance=").append(frontDistance);
        sb.append(", deviateType=").append(deviateType);
        sb.append(", roadSign=").append(roadSign);
        sb.append(", roadSignValue=").append(roadSignValue);
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