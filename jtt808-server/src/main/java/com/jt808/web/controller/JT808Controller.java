package com.jt808.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.jt808.commons.model.APICodes;
import com.jt808.commons.model.APIException;
import com.jt808.commons.model.APIResult;
import com.jt808.commons.util.DateUtils;
import com.jt808.commons.util.StrUtils;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;
import com.jt808.protocol.commons.Shape;
import com.jt808.protocol.jsatl12.AlarmId;
import com.jt808.protocol.jsatl12.T9208;
import com.jt808.protocol.t808.*;
import com.jt808.web.endpoint.MessageManager;
import com.jt808.web.model.vo.Parameters;
import reactor.core.publisher.Mono;

import java.util.Base64;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("terminal")
public class JT808Controller {

    @Autowired
    private MessageManager messageManager;

    @Value("${jt-server.jt808.alarm-file.host}")
    private String host;

    @Value("${jt-server.jt808.alarm-file.port}")
    private int port;

    @Operation(summary = "9208 Alarm attachment upload instruction")
    @GetMapping("alarm_file/upload")
    public Mono<APIResult<T0001>> alarmFileUpload(@Parameter(description = "Terminal phone number") @RequestParam String clientId,
                                                  @Parameter(description = "Time(YYMMDDHHMMSS)") @RequestParam String dateTime,
                                                  @Parameter(description = "Alarm serial number") @RequestParam int serialNo,
                                                  @Parameter(description = "Number of attachments") @RequestParam int fileTotal,
                                                  @Parameter(description = "IP address") String host,
                                                  @Parameter(description = "The port number") Integer port) {

        host = StrUtils.isBlank(host) ? this.host : host;
        port = port == null ? this.port : port;

        T9208 request = new T9208();
        request.setIp(host);
        request.setTcpPort(port);
        request.setUdpPort(0);
        request.setAlarmId(new AlarmId(clientId, DateUtils.parse(dateTime), serialNo, fileTotal, 0));
        request.setPlatformAlarmId(UUID.randomUUID().toString().replaceAll("-", ""));

        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8103 Set terminal parameters")
    @PutMapping("parameters")
    public Mono<APIResult<T0001>> setParameters(@Parameter(description = "Terminal phone number") @RequestParam String clientId, @RequestBody Parameters parameters) {
        Map<Integer, Object> map = parameters.toMap();
        T8103 request = new T8103(map);
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8104 8106 Query terminal parameters")
    @GetMapping("parameters")
    public Mono<APIResult<T0104>> getParameters(@Parameter(description = "Terminal phone number") @RequestParam String clientId,
                                                @Parameter(description = "Parameter ID list (empty query all, multiple separated by comma ',')") int[] id) {
        JTMessage request;
        if (id == null || id.length == 0) {
            request = new JTMessage(JT808.QueryTerminalParameters);
        } else {
            request = new T8106(id);
        }
        Mono<APIResult<T0104>> response = messageManager.requestR(clientId, request, T0104.class);
        return response;
    }

    @Operation(summary = "8105 TerminalControl")
    @PostMapping("control")
    public Mono<APIResult<T0001>> terminalControl(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8105 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8107 Query terminal properties")
    @GetMapping("attributes")
    public Mono<APIResult<T0107>> getAttributes(@Parameter(description = "Terminal phone number") @RequestParam String clientId) {
        Mono<APIResult<T0107>> response = messageManager.requestR(clientId, new JTMessage(JT808.QueryTerminalProperties), T0107.class);
        return response;
    }

    @Operation(summary = "8201 Location information query")
    @GetMapping("location")
    public Mono<APIResult<T0201_0500>> location(@Parameter(description = "Terminal phone number") @RequestParam String clientId) {
        Mono<APIResult<T0201_0500>> response = messageManager.requestR(clientId, new JTMessage(JT808.LocationInformationQuery), T0201_0500.class);
        return response;
    }

    @Operation(summary = "8202 Temporary position tracking control")
    @PostMapping("location/track")
    public Mono<APIResult<T0001>> track(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8202 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8203 Manual acknowledgment of alarm messages")
    @PostMapping("alarm_ack")
    public Mono<APIResult<T0001>> alarmAck(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8203 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8300 Text message delivery")
    @PostMapping("info/text")
    public Mono<APIResult<T0001>> sendText(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8300 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8301 Event settings")
    @PutMapping("info/events")
    public Mono<APIResult<T0001>> setEvents(@Parameter(description = "Terminal phone number") @RequestParam String clientId, @RequestBody T8301 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8302 ISSUE A QUESTION")
    @PostMapping("info/question")
    public Mono<APIResult<T0001>> sendQuestion(@Parameter(description = "Terminal phone number") @RequestParam String clientId, @RequestBody T8302 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8303 Information on demand menu settings")
    @PutMapping("info/menus")
    public Mono<APIResult<T0001>> setMenus(@Parameter(description = "Terminal phone number") @RequestParam String clientId, @RequestBody T8303 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8304 Information service")
    @PostMapping("info/news")
    public Mono<APIResult<T0001>> sendNews(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8304 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8400 call back")
    @PostMapping("phone/call_back")
    public Mono<APIResult<T0001>> phoneCallBack(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8400 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8401 Set up phonebook")
    @PutMapping("phone/book")
    public Mono<APIResult<T0001>> setPhoneBook(@Parameter(description = "Terminal phone number") @RequestParam String clientId, @RequestBody T8401 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8500 vehicle control")
    @PostMapping("control/vehicle")
    public Mono<APIResult<T0201_0500>> vehicleControl(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8500 request) {
        Mono<APIResult<T0201_0500>> response = messageManager.requestR(clientId, request, T0201_0500.class);
        return response;
    }

    @Operation(summary = "8600 set circular area")
    @PutMapping("area/circle")
    public Mono<APIResult<T0001>> setAreaCircle(@Parameter(description = "Terminal phone number") @RequestParam String clientId, @RequestBody T8600 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8602 set rectangle area")
    @PutMapping("area/rectangle")
    public Mono<APIResult<T0001>> setAreaRectangle(@Parameter(description = "Terminal phone number") @RequestParam String clientId, @RequestBody T8602 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8604 set polygon area")
    @PutMapping("area/polygon")
    public Mono<APIResult<T0001>> setAreaPolygon(@Parameter(description = "Terminal phone number") @RequestParam String clientId, @RequestBody T8604 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8606 set route")
    @PutMapping("area/route")
    public Mono<APIResult<T0001>> setAreaRoute(@Parameter(description = "Terminal phone number") @RequestParam String clientId, @RequestBody T8606 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8601 8603 8605 8607 delete area")
    @DeleteMapping("area")
    public Mono<APIResult<T0001>> removeArea(@Parameter(description = "Terminal phone number") @RequestParam String clientId,
                                             @Parameter(description = "Area Type: 1. Circle 2. Rectangle 3. Polygon 4. Route") @RequestParam int type,
                                             @Parameter(description = "List of region IDs (multiple separated by comma ',')") @RequestParam int[] id) {
        T8601 request = new T8601(id);
        request.setMessageId(Shape.toMessageId(type));
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8608 Query area or line data")
    @GetMapping("area/location")
    public Mono<APIResult<T0608>> findAreaLocation(@Parameter(description = "Terminal phone number") @RequestParam String clientId,
                                                   @Parameter(description = "Query type: 1. Circle 2. Rectangle 3. Polygon 4. Route") @RequestParam int type,
                                                   @Parameter(description = "List of region IDs (multiple separated by comma ',')") @RequestParam int[] id) {
        T8608 request = new T8608(type, id);
        Mono<APIResult<T0608>> response = messageManager.requestR(clientId, request, T0608.class);
        return response;
    }

    @Operation(summary = "8700 Drive recorder data collection command")
    @GetMapping("drive_recorder/data")
    public Mono<APIResult<T0001>> getDriveRecorder(@Parameter(description = "Terminal phone number") @RequestParam String clientId) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, new JTMessage(JT808.DriveRecorderDataCollectionCommand), T0001.class);
        return response;
    }

    @Operation(summary = "8701 Drive recorder parameter download command")
    @PutMapping("drive_recorder/parameters")
    public Mono<APIResult<T0001>> setDriveRecorderParameters(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8701 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8702 Report Driver Identification Information Request")
    @GetMapping("driver_info/upload")
    public Mono<APIResult<T0702>> driverInfoUpload(@Parameter(description = "Terminal phone number") @RequestParam String clientId) {
        Mono<APIResult<T0702>> response = messageManager.requestR(clientId, new JTMessage(JT808.ReportDriverIdentificationInformationRequest), T0702.class);
        return response;
    }

    @Operation(summary = "8801 The camera shoots the command immediately")
    @PostMapping("media/video/record")
    public Mono<APIResult<T0805>> mediaVideoRecord(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8801 request) {
        Mono<APIResult<T0805>> response = messageManager.requestR(clientId, request, T0805.class);
        return response;
    }

    @Operation(summary = "8802 Stored multimedia data retrieval")
    @GetMapping("media/search")
    public Mono<APIResult<T0802>> mediaSearch(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8802 request) {
        Mono<APIResult<T0802>> response = messageManager.requestR(clientId, request, T0802.class);
        return response;
    }

    @Operation(summary = "8803 Store multimedia data upload")
    @PostMapping("media/batch_upload")
    public Mono<APIResult<T0001>> mediaUploadBatch(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8803 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8804 Recording start command")
    @PostMapping("media/audio/record")
    public Mono<APIResult<T0001>> mediaAudioRecord(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8804 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8805 A single stored multimedia data retrieval and upload command")
    @PostMapping("media/upload")
    public Mono<APIResult<T0001>> mediaUpload(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8805 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8204 The server initiates a link detection request to the terminal")
    @PostMapping("link_detection")
    public Mono<APIResult<T0001>> link_detection(@Parameter(description = "Terminal phone number") @RequestParam String clientId) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, new JTMessage(JT808.ServerInitiatesLinkDetectionRequest), T0001.class);
        return response;
    }

    @Operation(summary = "8108 Issue the terminal upgrade package")
    @PostMapping("upgrade")
    public Mono<APIResult<T0001>> upgrade(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8108 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8900 Data downlink transparent transmission")
    @PostMapping("passthrough")
    public Mono<APIResult<T0001>> passthrough(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T8900 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "8A00 Platform RSA public key")
    @PostMapping("rsa_swap")
    public Mono<APIResult<T0A00_8A00>> rsaSwap(@Parameter(description = "Terminal phone number") @RequestParam String clientId,
                                               @Parameter(description = "e") @RequestParam int e,
                                               @Parameter(description = "n(base64Encoding)") @RequestParam String n) {
        byte[] src = Base64.getDecoder().decode(n);
        if (src.length == 129) {
            byte[] dest = new byte[128];
            System.arraycopy(src, 1, dest, 0, 128);
            src = dest;
        }
        if (src.length != 128)
            throw new APIException(APICodes.InvalidParameter, "The length is not 128");

        T0A00_8A00 request = new T0A00_8A00(e, src);
        Mono<APIResult<T0A00_8A00>> response = messageManager.requestR(clientId, request, T0A00_8A00.class);
        return response;
    }
}