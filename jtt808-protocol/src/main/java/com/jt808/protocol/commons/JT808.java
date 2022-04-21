package com.jt808.protocol.commons;

public interface JT808 {

    int TerminalGeneralAnswer = 0x0001;
    int TerminalHeartbeat = 0x0002;
    int TerminalLogout = 0x0003;
    int QueryServerTime = 0x0004;//2019 new
    int TerminalRetransmissionSubPacketRequest = 0x0005;//2019 new
    int TerminalRegistration = 0x0100;
    int TerminalAuthentication = 0x0102;//2019 modify
    int QueryTerminalParameterResponse = 0x0104;
    int QueryTerminalPropertiesReply = 0x0107;
    int TerminalUpgradeResultNotification = 0x0108;
    int LocationInformationReport = 0x0200;
    int LocationInformationQueryResponse = 0x0201;
    int IncidentReport = 0x0301;//2019 del
    int QuestionAndAnswer = 0x0302;//2019 del
    int InformationOnDemandCancel = 0x0303;//2019 del
    int VehicleControlResponse = 0x0500;
    int InquiryAreaOrLineDataAnswer = 0x0608;//2019 new
    int DrivingRecordDataUpload = 0x0700;
    int ElectronicWaybillReporting = 0x0701;
    int CollectAndReportDriverIdentityInformation = 0x0702;//2019 modify
    int BulkUploadOfPositioningData = 0x0704;
    int CANBusDataUpload = 0x0705;
    int MultimediaEventInformationUpload = 0x0800;
    int MultimediaDataUpload = 0x0801;
    int StoreMultimediaDataRetrievalResponse = 0x0802;
    int TheCameraImmediatelyShootsTheCommandResponse = 0x0805;
    int DataUplinkTransparentTransmission = 0x0900;
    int DataCompressionReport = 0x0901;
    int TerminalRSAPublicKey = 0x0A00;

    int TerminalUplinkMessageRetention = 0x0F00 - 0x0FFF;

    int PlatformUniversalResponse = 0x8001;
    int TheServerRetransmitsTheSubcontractingRequest = 0x8003;
    int QueryServerTimeResponse = 0x8004;//2019 new
    int TerminalRegistrationResponse = 0x8100;

    int SetTerminalParameters = 0x8103;
    int QueryTerminalParameters = 0x8104;
    int TerminalControl = 0x8105;
    int QueryTheSpecifiedTerminalParameters = 0x8106;
    int QueryTerminalProperties = 0x8107;
    int IssueTheTerminalUpgradePackage = 0x8108;
    int LocationInformationQuery = 0x8201;
    int TemporaryPositionTrackingControl = 0x8202;
    int ManualAcknowledgmentOfAlarmMessages = 0x8203;
    int ServerInitiatesLinkDetectionRequest = 0x8204;//2019 new
    int TextMessageDelivery = 0x8300;//2019 modify
    int EventSettings = 0x8301;//2019 del
    int IssueAQuestion = 0x8302;//2019 del
    int InformationOnDemandMenuSettings = 0x8303;//2019 del
    int InformationService = 0x8304;//2019 del
    int CallBack = 0x8400;
    int SetUpPhonebook = 0x8401;
    int VehicleControl = 0x8500;//2019 modify
    int SetCircularArea = 0x8600;//2019 modify
    int DeleteCircularArea = 0x8601;
    int SetRectangularArea = 0x8602;//2019 modify
    int DeleteRectangularArea = 0x8603;
    int SetPolygonArea = 0x8604;//2019 modify
    int DeletePolygonArea = 0x8605;
    int SetRoute = 0x8606;
    int DeleteRoute = 0x8607;
    int QueryAreaOrLineData = 0x8608;//2019 new
    int DriveRecorderDataCollectionCommand = 0x8700;
    int DriveRecorderParameterDownloadCommand = 0x8701;
    int ReportDriverIdentificationInformationRequest = 0x8702;

    int MultimediaDataUploadResponse = 0x8800;

    int CameraShootsCommandImmediately = 0x8801;
    int StoreMultimediaDataRetreival = 0x8802;
    int StoreMultimediaDataUpload = 0x8803;
    int RecordingStartCommand = 0x8804;
    int SingleStoredMultimediaDataRetreivalCommand = 0x8805;
    int DataDownlinkTransparentTransmission = 0x8900;
    int PlatformRSAPublicKey = 0x8A00;

    int PlatformDownlinkMessageRetention = 0x8F00 - 0x8FFF;
    int ManufacturerDefinedUplinkMessages = 0xE000 - 0xEFFF;//2019 new
    int BusinessDefinedDownlinkMessages = 0xF000 - 0xFFFF;//2019 new
}