package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.Bit;
import com.jt808.protocol.commons.JT808;

import java.time.LocalDateTime;
import java.util.List;

@Message(JT808.SetRoute)
public class T8606 extends JTMessage {

    @Field(length = 4, desc = "route ID")
    private int id;
    @Field(length = 2, desc = "route properties")
    private int attribute;
    @Field(length = 6, charset = "BCD", desc = "Start time (if the area attribute 0 bit is 0, there is no such field)")
    private LocalDateTime startTime;
    @Field(length = 6, charset = "BCD", desc = "End time (if the area attribute 0 bit is 0, there is no such field)")
    private LocalDateTime endTime;
    @Field(totalUnit = 2, desc = "Inflection point list")
    private List<Line> items;
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

    public List<Line> getItems() {
        return items;
    }

    public void setItems(List<Line> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Line {
        @Field(length = 4, desc = "Inflection point ID")
        private int id;
        @Field(length = 4, desc = "Segment ID")
        private int routeId;
        @Field(length = 4, desc = "Latitude")
        private int latitude;
        @Field(length = 4, desc = "Longitude")
        private int longitude;
        @Field(length = 1, desc = "Width (m)")
        private int width;
        @Field(length = 1, desc = "attribute")
        private int attribute;
        @Field(length = 2, desc = "The road section is too long to drive the threshold (seconds, if the area attribute 0 bit is 0, there is no such field)")
        private Integer upperLimit;
        @Field(length = 2, desc = "Insufficient driving threshold of the road segment (seconds, if the 0 bit of the area attribute is 0, there is no such field)")
        private Integer lowerLimit;
        @Field(length = 2, desc = "The maximum speed of the road section (km/h, if the area attribute 1 bit is 0, there is no such field)")
        private Integer maxSpeed;
        @Field(length = 1, desc = "Duration of speeding on the road section (seconds, if the area attribute 1 bit is 0, there is no such field)")
        private Integer duration;
        @Field(length = 2, desc = "Maximum speed at night (km/h, if the area attribute 1 bit is 0, there is no field)", version = 1)
        private Integer nightMaxSpeed;

        public Line() {
        }

        public Line(int id, int routeId, int latitude, int longitude, int width, int attribute, Integer upperLimit, Integer lowerLimit, Integer maxSpeed, Integer duration) {
            this.id = id;
            this.routeId = routeId;
            this.latitude = latitude;
            this.longitude = longitude;
            this.width = width;
            this.attribute = attribute;
            this.setUpperLimit(upperLimit);
            this.setLowerLimit(lowerLimit);
            this.setMaxSpeed(maxSpeed);
            this.setDuration(duration);
        }

        public Line(int id, int routeId, int latitude, int longitude, int width, int attribute, Integer upperLimit, Integer lowerLimit, Integer maxSpeed, Integer duration, Integer nightMaxSpeed) {
            this(id, routeId, latitude, longitude, width, attribute, upperLimit, lowerLimit, maxSpeed, duration);
            this.setNightMaxSpeed(nightMaxSpeed);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRouteId() {
            return routeId;
        }

        public void setRouteId(int routeId) {
            this.routeId = routeId;
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

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getAttribute() {
            return attribute;
        }

        public void setAttribute(int attribute) {
            this.attribute = attribute;
        }

        public Integer getUpperLimit() {
            return upperLimit;
        }

        public void setUpperLimit(Integer upperLimit) {
            this.attribute = Bit.set(attribute, 0, upperLimit != null);
            this.upperLimit = upperLimit;
        }

        public Integer getLowerLimit() {
            return lowerLimit;
        }

        public void setLowerLimit(Integer lowerLimit) {
            this.attribute = Bit.set(attribute, 0, lowerLimit != null);
            this.lowerLimit = lowerLimit;
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

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(240);
            sb.append("{id=").append(id);
            sb.append(",routeId=").append(routeId);
            sb.append(",longitude=").append(longitude);
            sb.append(",latitude=").append(latitude);
            sb.append(",width=").append(width);
            sb.append(",attribute=[").append(Integer.toBinaryString(attribute)).append(']');
            sb.append(",upperLimit=").append(upperLimit);
            sb.append(",lowerLimit=").append(lowerLimit);
            sb.append(",maxSpeed=").append(maxSpeed);
            sb.append(",duration=").append(duration);
            sb.append('}');
            return sb.toString();
        }
    }
}