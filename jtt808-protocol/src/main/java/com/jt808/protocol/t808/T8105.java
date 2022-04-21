package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.TerminalControl)
public class T8105 extends JTMessage {

    @Field(length = 1, desc = "Command word：" +
            " 1.Wireless upgrade" +
            " 2.Control terminal to connect to the specified server" +
            " 3.Terminal shutdown" +
            " 4.terminal reset" +
            " 5.Terminal reset to factory settings" +
            " 6.Turn off data communication" +
            " 7.Turn off all wireless communications")
    private int command;
    @Field(desc = "Command parameters")
    private String parameter;

    public T8105() {
    }

    public T8105(int command, String parameter) {
        this.command = command;
        this.parameter = parameter;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}