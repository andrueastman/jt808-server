package com.jt808.protocol.commons.transform.attribute;

import java.time.LocalDateTime;

public interface Alarm {

    static int buildType(int key, int type) {
        return (key * 100) + type;
    }

    LocalDateTime getDateTime();//Alarm time

    //Alarm source: 0. Equipment alarm 127. Platform alarm
    default int getSource() {
        return 0;
    }

    int getCategory();//Alarm category

    int getAlarmType();//alarm type

    int getLevel();//Alarm level

    int getLongitude();//gps longitude

    int getLatitude();//gps latitude

    int getAltitude();//Altitude (m)

    int getSpeed();//Speed (km/h)

    int getStatusBit();//vehicle status

    int getSerialNo();//Serial number (the serial number of the alarm at the same time point, cyclically accumulated from 0)

    int getFileTotal();//Total number of attachments

    String getExtra();//Extended Information
}