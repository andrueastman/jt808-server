package com.jt808.protocol.commons.transform.attribute;

import io.github.yezhihao.protostar.annotation.Field;
import com.jt808.protocol.jsatl12.AlarmId;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 轮胎气压监测系统 0x66
 */
public class AlarmTPMS implements Alarm {

    public static final int key = 102;

    @Field(length = 4, desc = "Alarm ID")
    private long id;
    @Field(length = 1, desc = "flag status")
    private int state;
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
    @Field(totalUnit = 1, desc = "Event information list")
    private List<Item> items;

    @Override
    public int getCategory() {
        return key;
    }

    @Override
    public int getAlarmType() {
        return Alarm.buildType(key, 0);
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {
        @Field(length = 1, desc = "Tire pressure alarm position (numbered from 00 in a zigzag pattern from the left front wheel, the number has nothing to do with whether TPMS is installed)")
        private int position;
        @Field(length = 2, desc = "alarm type：" +
                " 0.Tire pressure (reported regularly)" +
                " 1.High tire pressure alarm" +
                " 2.Low tire pressure alarm" +
                " 3.Tire temperature alarm" +
                " 4.Sensor abnormal alarm" +
                " 5.Tire pressure imbalance alarm" +
                " 6.Slow leak alarm" +
                " 7.Low battery alarm" +
                " 8~31.Reserved")
        private int type;
        @Field(length = 2, desc = "tire pressure(Kpa)")
        private int pressure;
        @Field(length = 2, desc = "Temperature(℃)")
        private int temperature;
        @Field(length = 2, desc = "battery power(%)")
        private int batteryLevel;

        public Item() {
        }

        public Item(int position, int type, int pressure, int temperature, int batteryLevel) {
            this.position = position;
            this.type = type;
            this.pressure = pressure;
            this.temperature = temperature;
            this.batteryLevel = batteryLevel;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public int getBatteryLevel() {
            return batteryLevel;
        }

        public void setBatteryLevel(int batteryLevel) {
            this.batteryLevel = batteryLevel;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Item{");
            sb.append("position=").append(position);
            sb.append(", type=").append(type);
            sb.append(", pressure=").append(pressure);
            sb.append(", temperature=").append(temperature);
            sb.append(", batteryLevel=").append(batteryLevel);
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(400);
        sb.append("AlarmTPMS{id=").append(id);
        sb.append(", state=").append(state);
        sb.append(", speed=").append(speed);
        sb.append(", altitude=").append(altitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", statusBit=").append(statusBit);
        sb.append(", alarmId=").append(alarmId);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}