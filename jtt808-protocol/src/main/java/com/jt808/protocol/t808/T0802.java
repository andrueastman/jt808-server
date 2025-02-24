package com.jt808.protocol.t808;

import io.github.yezhihao.netmc.core.model.Response;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

import java.util.List;

@Message(JT808.StoreMultimediaDataRetrievalResponse)
public class T0802 extends JTMessage implements Response {

    @Field(length = 2, desc = "Reply serial number")
    private int responseSerialNo;
    @Field(totalUnit = 2, desc = "search term")
    private List<Item> items;

    public int getResponseSerialNo() {
        return responseSerialNo;
    }

    public void setResponseSerialNo(int responseSerialNo) {
        this.responseSerialNo = responseSerialNo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {
        @Field(length = 4, desc = "multimedia data ID")
        private int id;
        @Field(length = 1, desc = "Multimedia Type: 0. Image 1. Audio 2. Video")
        private int type;
        @Field(length = 1, desc = "channel ID")
        private int channelId;
        @Field(length = 1, desc = "event item code")
        private int event;
        @Field(length = 28, desc = "location information")
        private T0200 location;

        public Item() {
        }

        public Item(int id, int type, int channelId, int event, T0200 location) {
            this.id = id;
            this.type = type;
            this.channelId = channelId;
            this.event = event;
            this.location = location;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getChannelId() {
            return channelId;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }

        public int getEvent() {
            return event;
        }

        public void setEvent(int event) {
            this.event = event;
        }

        public T0200 getLocation() {
            return location;
        }

        public void setLocation(T0200 location) {
            this.location = location;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(768);
            sb.append("{id=").append(id);
            sb.append(",type=").append(type);
            sb.append(",channelId=").append(channelId);
            sb.append(",event=").append(event);
            sb.append(",location=").append(location);
            sb.append('}');
            return sb.toString();
        }
    }
}