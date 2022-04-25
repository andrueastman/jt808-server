package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.Bit;
import com.jt808.protocol.commons.JT808;

import java.util.List;

@Message(JT808.IssueAQuestion)
public class T8302 extends JTMessage {

    @Field(length = 1, desc = "sign：" +
            " [0]urgent" +
            " [1]retain" +
            " [2]terminal Display" +
            " [3]terminal tts read" +
            " [4]Advertising screen display" +
            " [5]0. Center navigation information | 1. CAN fault code information" +
            " [6~7]reservation")
    private int sign;
    @Field(lengthUnit = 1, desc = "content")
    private String content;
    @Field(desc = "options")
    private List<Option> options;

    public T8302() {
    }

    public T8302(String content, int... sign) {
        this.content = content;
        this.sign = Bit.writeInt(sign);
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public static class Option {

        @Field(length = 1, desc = "Answer ID")
        private int id;
        @Field(lengthUnit = 2, desc = "answer content")
        private String content;

        public Option() {
        }

        public Option(int id, String content) {
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