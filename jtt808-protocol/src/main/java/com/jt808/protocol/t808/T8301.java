package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

import java.util.ArrayList;
import java.util.List;

@Message(JT808.EventSettings)
public class T8301 extends JTMessage {

    /** @see com.jt808.protocol.commons.Action */
    @Field(length = 1, desc = "Setting type: 0. Clear 1. Update (clear first, then append) 2. Append 3. Modify 4. Specify delete")
    private int type;
    @Field(totalUnit = 1, desc = "event item")
    private List<Event> events;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void addEvent(int id, String content) {
        if (events == null)
            events = new ArrayList<>(2);
        events.add(new Event(id, content));
    }

    public static class Event {
        @Field(length = 1, desc = "event id")
        private int id;
        @Field(lengthUnit = 1, desc = "content")
        private String content;

        public Event() {
        }

        public Event(int id, String content) {
            this.id = id;
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(40);
            sb.append("{id=").append(id);
            sb.append(",content=").append(content);
            sb.append('}');
            return sb.toString();
        }
    }
}