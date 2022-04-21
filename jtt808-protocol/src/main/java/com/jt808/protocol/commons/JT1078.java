package com.jt808.protocol.commons;

public interface JT1078 {

    int TerminalUploadAudioAndVideoAttributes = 0x1003;
    int TerminalUploadPassengerTraffic = 0x1005;
    int ListOfAudioAndVideoResourcesUploadedByTheTerminal = 0x1205;
    int FileUploadCompletionNotification = 0x1206;
    int QueryTerminalAudioAndVideoAttributes = 0x9003;
    int RealTimeAudioAndVideoTransmissionRequest = 0x9101;
    int AudioAndVideoRealTimeTransmissionControl = 0x9102;
    int RealTimeAudioAndVideoTransmissionStatusNotification = 0x9105;
    int ThePlatformIssuesARemoteVideoPlaybackRequest = 0x9201;
    int RemoteVideoPlaybackControlIssuedByThePlatform = 0x9202;
    int QueryResourceList = 0x9205;
    int FileUploadInstruction = 0x9206;
    int FileUploadControl = 0x9207;
    int PtzRotation = 0x9301;
    int PtzAdjustmentFocusControl = 0x9302;
    int GimbalAdjustmentApertureControl = 0x9303;
    int PtzWiperControl = 0x9304;
    int InfraredFillLightControl = 0x9305;
    int PtzZoomControl = 0x9306;
    int RealTimeAudioAndVideoStreamingAndTransparentDataTransmission = 0x30316364;
    String PlatformManualWakeUpRequestShortMessage = "WAKEUP";
}