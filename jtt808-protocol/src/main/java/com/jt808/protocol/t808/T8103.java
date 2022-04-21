package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;
import com.jt808.protocol.commons.transform.ParameterConverter;

import java.util.Map;
import java.util.TreeMap;

@Message(JT808.SetTerminalParameters)
public class T8103 extends JTMessage {

    @Field(length = 1, desc = "Total number of parameters")
    private int total;
    @Field(desc = "parameter list", converter = ParameterConverter.class)
    private Map<Integer, Object> parameters;

    public T8103() {
    }

    public T8103(Map<Integer, Object> parameters) {
        this.parameters = parameters;
        this.total = parameters.size();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Map<Integer, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<Integer, Object> parameters) {
        this.parameters = parameters;
        this.total = parameters.size();
    }

    public void addParameter(Integer key, Object value) {
        if (parameters == null)
            parameters = new TreeMap();
        parameters.put(key, value);
        total = parameters.size();
    }
}