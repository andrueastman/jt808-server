package com.jt808.protocol.jsatl12;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JSATL12;

import java.util.List;

@Message(JSATL12.AlarmAttachmentInformationMessage)
public class T1210 extends JTMessage {

    @Field(length = 7, desc = "Terminal ID", version = {-1, 0})
    @Field(length = 30, desc = "Terminal ID (Cantonese standard)", version = 1)
    private String deviceId;
    @Field(length = 16, desc = "Alarm identification number", version = {-1, 0})
    @Field(length = 40, desc = "Alarm identification number (Cantonese standard)", version = 1)
    private AlarmId alarmId;
    @Field(length = 32, desc = "Alarm number")
    private String platformAlarmId;
    @Field(length = 1, desc = "Information type: 0. Normal alarm file information 1. Supplementary alarm file information")
    private int type;
    @Field(totalUnit = 1, desc = "Attachment information list")
    private List<Item> items;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public AlarmId getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(AlarmId alarmId) {
        this.alarmId = alarmId;
    }

    public String getPlatformAlarmId() {
        return platformAlarmId;
    }

    public void setPlatformAlarmId(String platformAlarmId) {
        this.platformAlarmId = platformAlarmId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {
        @Field(lengthUnit = 1, desc = "文件名称")
        private String name;
        @Field(length = 4, desc = "文件大小")
        private long size;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(80);
            sb.append("{name=").append(name);
            sb.append(",size=").append(size);
            sb.append('}');
            return sb.toString();
        }
    }
}