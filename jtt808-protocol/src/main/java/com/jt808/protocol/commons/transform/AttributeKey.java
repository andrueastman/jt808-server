package com.jt808.protocol.commons.transform;

public interface AttributeKey {
    int Mileage = 1;                 // 0x01 Mileage, the data type is DWORD, the unit is 110 km, corresponding to the reading of the odometer on the car
    int Gas = 2;                     // 0x02 Fuel quantity, the data type is WORD, the unit is 110 L, corresponding to the reading of the fuel gauge on the vehicle
    int Speed = 3;                   // 0x03 The speed obtained by the driving record function, the data type is WORD, and the unit is 110 kmh
    int AlarmEventId = 4;            // 0x04 The ID of the alarm event needs to be manually confirmed, the data type is WORD, and the count starts from 1
    int TirePressure = 5;            // 0x05 Tire pressure, the unit is Pa, the order of calibrating the wheels is from left to right from the front of the car, the extra bytes are 0 x FF, which means invalid data
    int CarriageTemperature = 6;     // 0x06 Compartment temperature, the unit is Celsius, the value range is -32767~+32767, the highest bit is 1, which means a negative number
    int OverSpeedAlarm = 17;         // 0x11 See Table 28 for additional information on overspeed alarms
    int InOutAreaAlarm = 18;         // 0x12 See Table 29 for additional information about route alarms in and out of the area
    int RouteDriveTimeAlarm = 19;    // 0x13 See Table 30 for additional information on the warning that the driving time of the road section is insufficient and too long
    int Signal = 37;                 // 0x25 Extended vehicle signal status bits, the format and definition of parameter items are shown in Table 31
    int IoState = 42;                // 0x2a I 0 status bit, see Table 32 for the format and definition of the parameter item
    int AnalogQuantity = 43;         // 0x2b Analog, bit[0~15], AD 0; bit[l 6~31], A Dl
    int SignalStrength = 48;         // 0x30 The data type is BYTE, the signal strength of the wireless communication network
    int GnssCount = 49;              // 0x31 The data type is BYTE, the number of GNSS positioning satellites
    int AlarmADAS = 100;             // 0x64 Advanced Driver Assistance System Alerts
    int AlarmDSM = 101;              // 0x65 Driver status monitoring
    int AlarmTPMS = 102;             // 0x66 Tire Pressure Monitoring System
    int AlarmBSD = 103;              // 0x67 Blind spot monitoring
    int InstallErrorMsg = 241;       // 0xF1 Installation abnormal information, customized by the manufacturer (Cantonese standard)
    int AlgorithmErrorMsg = 242;     // 0xF2 Algorithm exception information, customized by the manufacturer (Cantonese standard)
}