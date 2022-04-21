package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

import java.util.ArrayList;
import java.util.List;

@Message(JT808.InformationOnDemandMenuSettings)
public class T8303 extends JTMessage {

    /** @see com.jt808.protocol.commons.Action */
    @Field(length = 1, desc = "setType")
    private int type;
    @Field(totalUnit = 1, desc = "information item")
    private List<Info> infos;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Info> getInfos() {
        return infos;
    }

    public void setInfos(List<Info> infos) {
        this.infos = infos;
    }

    public void addInfo(int type, String name) {
        if (infos == null)
            infos = new ArrayList<>(2);
        infos.add(new Info(type, name));
    }

    public static class Info {
        @Field(length = 1, desc = "信息类型")
        private int type;
        @Field(lengthUnit = 2, desc = "信息名称")
        private String name;

        public Info() {
        }

        public Info(int type, String name) {
            this.type = type;
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(40);
            sb.append("{type=").append(type);
            sb.append(",name=").append(name);
            sb.append('}');
            return sb.toString();
        }
    }
}