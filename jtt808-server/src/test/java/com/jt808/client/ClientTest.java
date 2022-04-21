package com.jt808.client;

import com.jt808.client.netty.ClientConfig;
import com.jt808.client.netty.HandlerMapping;
import com.jt808.client.netty.TCPClient;
import com.jt808.commons.util.StrUtils;
import com.jt808.protocol.codec.JTMessageAdapter;
import com.jt808.commons.util.DateUtils;
import com.jt808.protocol.commons.JT808;
import com.jt808.protocol.t808.T0100;
import com.jt808.protocol.t808.T0200;

import java.time.LocalDateTime;

public class ClientTest {

    public static final JTMessageAdapter messageAdapter = new JTMessageAdapter("com.jt808.protocol");

    public static final ClientConfig jtConfig = new ClientConfig.Builder()
            .setIp("127.0.0.1")
            .setPort(7611)
            .setMaxFrameLength(2 + 21 + 1023 * 2 + 1 + 2)
            .setDelimiters(new byte[]{0x7e})
            .setDecoder(messageAdapter)
            .setEncoder(messageAdapter)
            .setHandlerMapping(new HandlerMapping("org.yzh.client"))
            .build();

    public static void main(String[] args) {
        TCPClient tcpClient = new TCPClient("0", jtConfig).start();
        tcpClient.writeObject(T0100("1"));
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tcpClient.writeObject(T0200("1"));
        }
    }

    public static T0100 T0100(String id) {
        String deviceId = "T" + StrUtils.leftPad(id, 6, '0');
        String clientId = "1" + StrUtils.leftPad(id, 10, '0');
        String plateNo = "测A" + StrUtils.leftPad(id, 5, '0');

        T0100 message = new T0100();
        message.setMessageId(JT808.TerminalRegistration);
        message.setProtocolVersion(1);
        message.setVersion(true);
        message.setClientId(clientId);

        message.setProvinceId(31);
        message.setCityId(115);
        message.setMakerId("yzh");
        message.setDeviceModel("www.jtt808.cn");
        message.setDeviceId(deviceId);
        message.setPlateColor(1);
        message.setPlateNo(plateNo);
        return message;
    }

    public static T0200 T0200(String id) {
        String clientId = "1" + StrUtils.leftPad(id, 10, '0');

        T0200 message = new T0200();
        message.setMessageId(JT808.LocationInformationReport);
        message.setProtocolVersion(1);
        message.setVersion(true);
        message.setClientId(clientId);

        message.setWarnBit(1024);
        message.setStatusBit(2048);
        message.setLongitude(123);
        message.setLatitude(32);
        message.setAltitude(312);
        message.setSpeed(111);
        message.setDirection(99);
        message.setDateTime(DateUtils.yyMMddHHmmss.format(LocalDateTime.now()));
        return message;
    }
}