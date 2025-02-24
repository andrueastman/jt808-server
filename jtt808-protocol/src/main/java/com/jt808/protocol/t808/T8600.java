package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.Bit;
import com.jt808.protocol.commons.JT808;

import java.time.LocalDateTime;
import java.util.List;

@Message(JT808.SetCircularArea)
public class T8600 extends JTMessage {

    /** @see com.jt808.protocol.commons.ShapeAction */
    @Field(length = 1, desc = "set properties")
    private int action;
    @Field(totalUnit = 1, desc = "area item")
    private List<Circle> items;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public List<Circle> getItems() {
        return items;
    }

    public void setItems(List<Circle> items) {
        this.items = items;
    }

    public static class Circle {
        @Field(length = 4, desc = "area id")
        private int id;
        @Field(length = 2, desc = "regional properties")
        private int attribute;
        @Field(length = 4, desc = "center point latitude")
        private int latitude;
        @Field(length = 4, desc = "center point longitude")
        private int longitude;
        @Field(length = 4, desc = "Radius (m)")
        private int radius;
        @Field(length = 6, charset = "BCD", desc = "Start time (if the area attribute 0 bit is 0, there is no such field)")
        private LocalDateTime startTime;
        @Field(length = 6, charset = "BCD", desc = "End time (if the area attribute 0 bit is 0, there is no such field)")
        private LocalDateTime endTime;
        @Field(length = 2, desc = "Maximum speed (kilometers per hour, if the area attribute 1 bit is 0, there is no field)")
        private Integer maxSpeed;
        @Field(length = 1, desc = "Overspeed duration (seconds, if the zone attribute 1 bit is 0, there is no field)")
        private Integer duration;
        @Field(length = 2, desc = "Maximum speed at night (km/h, if the area attribute 1 bit is 0, there is no field)", version = 1)
        private Integer nightMaxSpeed;
        @Field(lengthUnit = 2, desc = "area name", version = 1)
        private String name;

        public Circle() {
        }

        public Circle(int id, int attribute, int latitude, int longitude, int radius, LocalDateTime startTime, LocalDateTime endTime, Integer maxSpeed, Integer duration) {
            this.id = id;
            this.attribute = attribute;
            this.latitude = latitude;
            this.longitude = longitude;
            this.radius = radius;
            this.setStartTime(startTime);
            this.setEndTime(endTime);
            this.setMaxSpeed(maxSpeed);
            this.setDuration(duration);
        }

        public Circle(int id, int attribute, int latitude, int longitude, int radius, LocalDateTime startTime, LocalDateTime endTime, Integer maxSpeed, Integer duration, Integer nightMaxSpeed, String name) {
            this(id, attribute, latitude, longitude, radius, startTime, endTime, maxSpeed, duration);
            this.setNightMaxSpeed(nightMaxSpeed);
            this.name = name;
        }

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

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
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

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(240);
            sb.append("{id=").append(id);
            sb.append(",attribute=[").append(Integer.toBinaryString(attribute)).append(']');
            sb.append(",longitude=").append(longitude);
            sb.append(",latitude=").append(latitude);
            sb.append(",radius=").append(radius);
            sb.append(",startTime=").append(startTime);
            sb.append(",endTime=").append(endTime);
            sb.append(",maxSpeed=").append(maxSpeed);
            sb.append(",duration=").append(duration);
            sb.append(",nightMaxSpeed=").append(nightMaxSpeed);
            sb.append(",name=").append(name);
            sb.append('}');
            return sb.toString();
        }
    }
}