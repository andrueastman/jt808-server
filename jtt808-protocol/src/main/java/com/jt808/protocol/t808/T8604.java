package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.Bit;
import com.jt808.protocol.commons.JT808;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Message(JT808.SetPolygonArea)
public class T8604 extends JTMessage {

    @Field(length = 4, desc = "Area ID")
    private int id;
    @Field(length = 2, desc = "Regional properties")
    private int attribute;
    @Field(length = 6, charset = "BCD", desc = "Start time (if the area attribute 0 bit is 0, there is no such field)")
    private LocalDateTime startTime;
    @Field(length = 6, charset = "BCD", desc = "End time (if the area attribute 0 bit is 0, there is no such field)")
    private LocalDateTime endTime;
    @Field(length = 2, desc = "Maximum speed (kilometers per hour, if the area attribute 1 bit is 0, there is no field)")
    private Integer maxSpeed;
    @Field(length = 1, desc = "Overspeed duration (seconds, if the zone attribute 1 bit is 0, there is no field)")
    private Integer duration;
    @Field(totalUnit = 2, desc = "vertex item")
    private List<Point> points;
    @Field(length = 2, desc = "Maximum speed at night (km/h, if the area attribute 1 bit is 0, there is no field)", version = 1)
    private Integer nightMaxSpeed;
    @Field(lengthUnit = 2, desc = "area name", version = 1)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.attribute = Bit.set(attribute, 0, startTime != null);
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.attribute = Bit.set(attribute, 0, endTime != null);
        this.endTime = endTime;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.attribute = Bit.set(attribute, 1, maxSpeed != null);
        this.maxSpeed = maxSpeed;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.attribute = Bit.set(attribute, 1, duration != null);
        this.duration = duration;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPoint(int longitude, int latitude) {
        if (points == null)
            points = new ArrayList<>(4);
        points.add(new Point(latitude, longitude));
    }

    public Integer getNightMaxSpeed() {
        return nightMaxSpeed;
    }

    public void setNightMaxSpeed(Integer nightMaxSpeed) {
        this.attribute = Bit.set(attribute, 1, nightMaxSpeed != null);
        this.nightMaxSpeed = nightMaxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Point {
        @Field(length = 4, desc = "纬度")
        private int latitude;
        @Field(length = 4, desc = "经度")
        private int longitude;

        public Point() {
        }

        public Point(int latitude, int longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
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

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(32);
            sb.append('{');
            sb.append("lng=").append(longitude);
            sb.append(",lat=").append(latitude);
            sb.append('}');
            return sb.toString();
        }
    }
}