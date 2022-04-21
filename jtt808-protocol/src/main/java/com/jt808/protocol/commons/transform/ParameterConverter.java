package com.jt808.protocol.commons.transform;

import io.github.yezhihao.protostar.PrepareLoadStrategy;
import io.github.yezhihao.protostar.schema.ArraySchema;
import io.github.yezhihao.protostar.schema.MapSchema;
import io.github.yezhihao.protostar.schema.NumberSchema;
import io.github.yezhihao.protostar.schema.StringSchema;
import com.jt808.protocol.commons.transform.parameter.*;

public class ParameterConverter extends MapSchema<Integer, Object> {

    public ParameterConverter() {
        super(NumberSchema.DWORD_INT, 1);
    }

    @Override
    protected void addSchemas(PrepareLoadStrategy<Integer> schemaRegistry) {
        schemaRegistry
                .addSchema(0x0001, NumberSchema.DWORD_LONG)//Terminal heartbeat sending interval, in seconds (s)
                .addSchema(0x0002, NumberSchema.DWORD_LONG)//TCP message response timeout, in seconds (s)
                .addSchema(0x0003, NumberSchema.DWORD_LONG)//TCP message retransmission times
                .addSchema(0x0004, NumberSchema.DWORD_LONG)//UDP message response timeout, in seconds (s)
                .addSchema(0x0005, NumberSchema.DWORD_LONG)//UDP message retransmission times
                .addSchema(0x0006, NumberSchema.DWORD_LONG)//SMS message response timeout, in seconds (s)
                .addSchema(0x0007, NumberSchema.DWORD_LONG)//Number of SMS message retransmissions

                .addSchema(0x0010, StringSchema.GBK)//Main server APN, wireless communication dial-up access point. If the network standard is CDMA, this is the PPP dial-up number
                .addSchema(0x0011, StringSchema.GBK)//Primary server wireless communication dial-up user name
                .addSchema(0x0012, StringSchema.GBK)//Main server wireless communication dial-up password
                .addSchema(0x0013, StringSchema.GBK)//Primary server address, IP or domain name
                .addSchema(0x0014, StringSchema.GBK)//Backup server APN, wireless communication dial-up access point
                .addSchema(0x0015, StringSchema.GBK)//Backup server wireless communication dial-up username
                .addSchema(0x0016, StringSchema.GBK)//Backup server wireless communication dial-up password
                .addSchema(0x0017, StringSchema.GBK)//Backup server address, IP or domain name (2019 version uses colon to separate host and port, multiple servers use semicolon to separate)
                .addSchema(0x0018, NumberSchema.DWORD_LONG)//Server TCP port (version 2013)
                .addSchema(0x0019, NumberSchema.DWORD_LONG)//Server UDP Port (version 2013)


                .addSchema(0x001A, StringSchema.GBK)//IP address or domain name of the main server for road transport license IC card authentication
                .addSchema(0x001B, NumberSchema.DWORD_LONG)//Road transport license IC card authentication main server TCP port
                .addSchema(0x001C, NumberSchema.DWORD_LONG)//UDP port of main server for road transport license IC card authentication
                .addSchema(0x001D, StringSchema.GBK)//The IP address or domain name of the main server for road transport license IC card authentication, the port is the same as that of the main server

                .addSchema(0x0020, NumberSchema.DWORD_LONG)//Location reporting strategy: 0. Scheduled reporting 1. Fixed-distance reporting 2. Scheduled and fixed-distance reporting
                .addSchema(0x0021, NumberSchema.DWORD_LONG)//Location reporting scheme: 0. According to the ACC status 1. According to the login status and ACC status, first judge the login status, if logged in, then according to the ACC status
                .addSchema(0x0022, NumberSchema.DWORD_LONG)//The time interval for reporting that the driver is not logged in, the unit is seconds (s), > 0

                //JT808 2019
                .addSchema(0x0023, StringSchema.GBK)//Slave server APN. When this value is empty, the terminal should use the same configuration of the master server
                .addSchema(0x0024, StringSchema.GBK)//Slave server wireless communication dial-up user name. When this value is empty, the terminal should use the same configuration as the master server
                .addSchema(0x0025, StringSchema.GBK)//Slave server wireless communication dial-up password. When this value is empty, the terminal should use the same configuration as the master server
                .addSchema(0x0026, StringSchema.GBK)//The slave server backup address, IP or domain name. The master server IP address or domain name, the port is the same as the master server
                //JT808 2019

                .addSchema(0x0027, NumberSchema.DWORD_LONG)//Report time interval when sleeping, the unit is second (s), > 0
                .addSchema(0x0028, NumberSchema.DWORD_LONG)//Report time interval when emergency alarm occurs, the unit is second (s), > 0
                .addSchema(0x0029, NumberSchema.DWORD_LONG)//Default time reporting interval, in seconds (s), > 0

                .addSchema(0x002C, NumberSchema.DWORD_LONG)//Default distance reporting interval, the unit is meters (m), > 0
                .addSchema(0x002D, NumberSchema.DWORD_LONG)//The driver does not log in to report the distance interval, the unit is meters (m), > 0
                .addSchema(0x002E, NumberSchema.DWORD_LONG)//Report distance interval when sleeping, the unit is meters (m), > 0
                .addSchema(0x002F, NumberSchema.DWORD_LONG)//Report distance interval when emergency alarm, the unit is meters (m), > 0
                .addSchema(0x0030, NumberSchema.DWORD_LONG)//Inflection point supplementary transmission angle, <180°
                .addSchema(0x0031, NumberSchema.WORD_INT)//The radius of the electronic fence, in meters
                //JT808 2019
                .addSchema(0x0032, TimeRange.SCHEMA)//Illegal driving time range, accurate to the minute

                .addSchema(0x0040, StringSchema.GBK)//Monitoring platform phone number
                .addSchema(0x0041, StringSchema.GBK)//Reset phone number, you can use this phone number to call the terminal to reset the terminal
                .addSchema(0x0042, StringSchema.GBK)//Factory reset phone number, you can use this phone number to call the terminal to restore the factory settings
                .addSchema(0x0043, StringSchema.GBK)//Monitoring Platform SMS Phone Number
                .addSchema(0x0044, StringSchema.GBK)//Receiving terminal SMS text alarm number
                .addSchema(0x0045, NumberSchema.DWORD_LONG)//Terminal phone answering strategy, 0. Automatic answering 1. Automatic answering when ACC is ON, manual answering when OFF
                .addSchema(0x0046, NumberSchema.DWORD_LONG)//The longest call time each time, the unit is seconds (s), 0 means no call is allowed, 0 x FFFFFFFF means no limit
                .addSchema(0x0047, NumberSchema.DWORD_LONG)//The longest talk time in the current month, the unit is seconds (s), 0 means no calls are allowed, 0 x FFFFFFFF means no limit
                .addSchema(0x0048, StringSchema.GBK)//Monitor phone number
                .addSchema(0x0049, StringSchema.GBK)//Supervision platform privileged SMS number

                .addSchema(0x0050, NumberSchema.DWORD_LONG)//Alarm mask word. Corresponding to the alarm flag in the location information report message, if the corresponding bit is 1, the corresponding alarm is masked
                .addSchema(0x0051, NumberSchema.DWORD_LONG)//Alarm sending text SMS switch, which corresponds to the alarm flag in the position information report message, when the corresponding bit is 1, the text SMS is sent when the corresponding alarm occurs.
                .addSchema(0x0052, NumberSchema.DWORD_LONG)//Alarm shooting switch, corresponding to the alarm flag in the position information report message, the corresponding bit is 1, the camera shoots when the corresponding alarm
                .addSchema(0x0053, NumberSchema.DWORD_LONG)//The alarm shooting storage flag corresponds to the alarm flag in the location information report message. If the corresponding bit is 1, the photo of the corresponding alarm card will be stored, otherwise it will be transmitted in real time.
                .addSchema(0x0054, NumberSchema.DWORD_LONG)//The key flag corresponds to the alarm flag in the location information report message. If the corresponding bit is 1, the corresponding alarm is a key alarm.
                .addSchema(0x0055, NumberSchema.DWORD_LONG)//Maximum speed in kilometers per hour (kmh)
                .addSchema(0x0056, NumberSchema.DWORD_LONG)//Overspeed duration, in seconds (s)
                .addSchema(0x0057, NumberSchema.DWORD_LONG)//Continuous driving time threshold, in seconds (s)
                .addSchema(0x0058, NumberSchema.DWORD_LONG)//The cumulative driving time threshold of the day, in seconds (s)
                .addSchema(0x0059, NumberSchema.DWORD_LONG)//Minimum rest time, in seconds (s)
                .addSchema(0x005A, NumberSchema.DWORD_LONG)//The longest parking time, in seconds (s)

                .addSchema(0x005B, NumberSchema.WORD_INT)//Overspeed warning difference
                .addSchema(0x005C, NumberSchema.WORD_INT)//Fatigue driving warning interpolation
                .addSchema(0x005D, NumberSchema.WORD_INT)//Collision Alarm Parameters
                .addSchema(0x005E, NumberSchema.WORD_INT)//Rollover Alarm Parameters

                .addSchema(0x0064, NumberSchema.DWORD_LONG)//Timing photo parameters
                .addSchema(0x0065, NumberSchema.DWORD_LONG)//Fixed distance photography parameters

                .addSchema(0x0070, NumberSchema.DWORD_LONG)//Image video quality, 1~10, 1 is the best
                .addSchema(0x0071, NumberSchema.DWORD_LONG)//Brightness, 0~255
                .addSchema(0x0072, NumberSchema.DWORD_LONG)//Contrast, 0~127
                .addSchema(0x0073, NumberSchema.DWORD_LONG)//Saturation, 0~127
                .addSchema(0x0074, NumberSchema.DWORD_LONG)//Chroma, 0~255

                //JT1078 start
                .addSchema(ParamVideo.key, ParamVideo.SCHEMA)//Audio and video parameter settings, see Table 2 for description
                .addSchema(ParamChannels.key, ParamChannels.SCHEMA)//Audio and video channel list settings, see Table 3 for description
                .addSchema(ParamVideoSingle.key, ParamVideoSingle.SCHEMA)//Individual video channel parameter settings, see Table 5 for description
                .addSchema(ParamVideoSpecialAlarm.key, ParamVideoSpecialAlarm.SCHEMA)//Special alarm recording parameter settings, see Table 7 for description
                .addSchema(0x007A, NumberSchema.DWORD_LONG)//Video-related alarm mask word, corresponding to the video alarm flag bit definition in Table 13, if the corresponding bit is 1, the corresponding type of alarm is masked
                .addSchema(ParamImageIdentifyAlarm.key, ParamImageIdentifyAlarm.SCHEMA)// The description of image analysis alarm parameter settings is shown in Table 8
                .addSchema(ParamSleepWake.key, ParamSleepWake.SCHEMA)//Terminal sleep and wake-up mode settings, see Table 9 for description
                //JT1078 end

                .addSchema(0x0080, NumberSchema.DWORD_LONG)//Vehicle odometer reading,1/10km
                .addSchema(0x0081, NumberSchema.WORD_INT)//The ID of the province where the vehicle is located
                .addSchema(0x0082, NumberSchema.WORD_INT)//ID of the city where the vehicle is located
                .addSchema(0x0083, StringSchema.GBK)//Motor vehicle license plate issued by public security traffic management department
                .addSchema(0x0084, NumberSchema.BYTE_INT)//License plate color, according to 5.4.12 of JTT 415-2006

                .addSchema(0x0090, NumberSchema.BYTE_INT)//positioning mode
                .addSchema(0x0091, NumberSchema.BYTE_INT)//baud rate
                .addSchema(0x0092, NumberSchema.BYTE_INT)//Module detailed positioning data output frequency
                .addSchema(0x0093, NumberSchema.DWORD_LONG)//The frequency of the module's detailed positioning data collection, the unit is seconds, the default is 1
                .addSchema(0x0094, NumberSchema.BYTE_INT)//Module detailed positioning data upload method
                .addSchema(0x0095, NumberSchema.DWORD_LONG)//Module detailed positioning data upload settings
                .addSchema(0x0100, NumberSchema.DWORD_LONG)//Bus channel 1 acquisition time interval (ms), 0 means no acquisition
                .addSchema(0x0101, NumberSchema.WORD_INT)//Bus channel 1 upload time interval (s), 0 means no upload
                .addSchema(0x0102, NumberSchema.DWORD_LONG)//Bus channel 2 acquisition time interval (ms), 0 means no acquisition
                .addSchema(0x0103, NumberSchema.WORD_INT)//总线通道2 上传时间间隔(s),0 表示不上传
                .addSchema(0x0110, ArraySchema.BYTES)//总线ID 单独采集设置

                //JSATL12 start
                .addSchema(ParamADAS.key, ParamADAS.SCHEMA)//高级驾驶辅助系统参数,见表4-10
                .addSchema(ParamDSM.key, ParamDSM.SCHEMA)//驾驶员状态监测系统参数,见表4-11
                .addSchema(ParamTPMS.key, ParamTPMS.SCHEMA)//胎压监测系统参数,见表4-12
                .addSchema(ParamBSD.key, ParamBSD.SCHEMA)//盲区监测系统参数,见表4-13
                //粤标
                .addSchema(0xF370, NumberSchema.BYTE_INT)//智能视频协议版本信息,引入此智能视频协议版本信息方便平台进行版本控制初始版本是1,每次修订版本号都会递增（注：只支持获取,不支持设置）
        ;
    }
}