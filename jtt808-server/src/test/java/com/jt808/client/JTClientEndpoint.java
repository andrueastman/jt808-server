package com.jt808.client;

import io.github.yezhihao.netmc.core.annotation.Endpoint;
import io.github.yezhihao.netmc.core.annotation.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;
import com.jt808.protocol.t808.*;
import com.jt808.web.endpoint.JT808Endpoint;
import com.jt808.protocol.t808.T0200;

import java.util.concurrent.atomic.AtomicInteger;

import static com.jt808.protocol.commons.JT808.*;

@Endpoint
public class JTClientEndpoint {

    private static final Logger log = LoggerFactory.getLogger(JT808Endpoint.class.getSimpleName());

    private AtomicInteger serialNo = new AtomicInteger();

    private String mobileNo = "12345678901";

    @Mapping(types = PlatformUniversalResponse, desc = "Platform Universal Response")
    public void platformUniversalResponse(T0001 message) {
    }

    @Mapping(types = TheServerRetransmitsTheSubcontractingRequest, desc = "The server retransmits the subcontracting request")
    public T0001 theServerRetransmitsTheSubcontractingRequest(T8003 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = QueryServerTimeResponse, desc = "query server time response")
    public T0001 queryServerTimeResponse(T8004 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = TerminalRegistrationResponse, desc = "Terminal registration response")
    public T0001 terminalRegistrationResponse(T8100 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SetTerminalParameters, desc = "Set terminal parameters")
    public T0001 setTerminalParameters(T8103 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = QueryTerminalParameters, desc = "Query terminal parameters")
    public T0001 queryTerminalParameters(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = TerminalControl, desc = "terminal control")
    public T0001 terminalControl(T8105 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = QueryTheSpecifiedTerminalParameters, desc = "Query the specified terminal parameters")
    public T0001 queryTheSpecifiedTerminalParameters(T8106 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = QueryTerminalProperties, desc = "Query terminal properties")
    public T0001 queryTerminalProperties(T0107 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = IssueTheTerminalUpgradePackage, desc = "issueTheTerminalUpgradePackage")
    public T0001 issueTheTerminalUpgradePackage(T8108 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = LocationInformationQuery, desc = "locationInformationQuery")
    public T0200 locationInformationQuery(JTMessage message) {
        return ClientTest.T0200("1");
    }

    @Mapping(types = TemporaryPositionTrackingControl, desc = "temporaryPositionTrackingControl")
    public T0001 temporaryPositionTrackingControl(T8202 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = ManualAcknowledgmentOfAlarmMessages, desc = "Manual acknowledgment of alarm messages")
    public T0001 manualAcknowledgmentOfAlarmMessages(T8203 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = ServerInitiatesLinkDetectionRequest, desc = "The server initiates a link detection request to the terminal")
    public T0001 serverInitiatesLinkDetectionRequest(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = TextMessageDelivery, desc = "Text message delivery")
    public T0001 textMessageDelivery(T8300 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = EventSettings, desc = "Event settings")
    public T0001 eventSettings(T8301 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = IssueAQuestion, desc = "Issue a question")
    public T0001 issueAQuestion(T8302 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = InformationOnDemandMenuSettings, desc = "Information on demand menu settings")
    public T0001 informationOnDemandMenuSettings(T8303 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = InformationService, desc = "Information service")
    public T0001 informationService(T8304 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = CallBack, desc = "call back")
    public T0001 callBack(T8400 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SetUpPhonebook, desc = "Set up phonebook")
    public T0001 setUpPhonebook(T8401 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = VehicleControl, desc = "vehicle control")
    public T0001 vehicleControl(T8500 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = {DeleteCircularArea, DeleteRectangularArea, DeletePolygonArea, DeleteRoute,}, desc = "delete circular area")
    public T0001 deleteCircularArea(T8601 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SetCircularArea, desc = "set circular area")
    public T0001 setCircularArea(T8600 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }


    @Mapping(types = SetRectangularArea, desc = "set rectangle area")
    public T0001 setRectangleArea(T8602 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SetPolygonArea, desc = "set polygon area")
    public T0001 setPolygonArea(T8604 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SetRoute, desc = "set route")
    public T0001 setRoute(T8606 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = QueryAreaOrLineData, desc = "Query area or line data")
    public T0001 queryAreaOrLineData(T8608 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = DriveRecorderDataCollectionCommand, desc = "Drive Recorder Data Collection Command")
    public T0001 driveRecorderDataCollectionCommand(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = DriveRecorderParameterDownloadCommand, desc = "Drive Recorder Parameter Download Command")
    public T0001 driveRecorderParameterDownloadCommand(T8701 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = ReportDriverIdentificationInformationRequest, desc = "Report Driver Identification Information Request")
    public T0001 reportDriverIdentificationInformationRequest(JTMessage message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = MultimediaDataUploadResponse, desc = "Multimedia data upload response")
    public T0001 multimediaDataUploadResponse(T8800 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = CameraShootsCommandImmediately, desc = "Camera shoots command immediately")
    public T0001 theCameraShootsTheCommandImmediately(T8801 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = StoreMultimediaDataRetreival, desc = "Store Multimedia Data Retreival")
    public T0001 storedMultimediaDataRetrieval(T8802 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = StoreMultimediaDataUpload, desc = "Store Multimedia Data Upload")
    public T0001 storeMultimediaDataUpload(T8803 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = RecordingStartCommand, desc = "Recording Start Command")
    public T0001 recordingStartCommand(T8804 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = SingleStoredMultimediaDataRetreivalCommand, desc = "A single stored multimedia data retrieval and upload command")
    public T0001 singleStoredMultimediaDataRetreivalCommand(T8805 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = DataDownlinkTransparentTransmission, desc = "Data Downlink Transparent Transmission")
    public T0001 dataDownlinkTransparentTransmission(T8900 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    @Mapping(types = PlatformRSAPublicKey, desc = "Platform RSA Public key")
    public T0001 platformRSAPublicKey(T0A00_8A00 message) {
        T0001 result = buildResult(message, T0001.Success);
        return result;
    }

    private T0001 buildResult(JTMessage message, int resultCode) {
        T0001 result = new T0001();
        result.copyBy(message);
        result.setMessageId(JT808.TerminalGeneralAnswer);
        result.setClientId(mobileNo);
        result.setSerialNo(serialNo.addAndGet(1));

        result.setResponseSerialNo(message.getSerialNo());
        result.setResponseMessageId(message.getMessageId());
        result.setResultCode(resultCode);
        return result;
    }
}