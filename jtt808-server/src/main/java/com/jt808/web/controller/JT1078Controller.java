package com.jt808.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jt808.commons.model.APIResult;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT1078;
import com.jt808.protocol.t1078.*;
import com.jt808.protocol.t808.T0001;
import com.jt808.web.endpoint.MessageManager;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("media")
public class JT1078Controller {

    @Autowired
    private MessageManager messageManager;

    @Operation(summary = "9003 Query terminal audio and video attributes")
    @GetMapping("attributes")
    public Mono<APIResult<T1003>> getAttributes(@Parameter(description = "Terminal phone number") @RequestParam String clientId) {
        Mono<APIResult<T1003>> response = messageManager.requestR(clientId, new JTMessage(JT1078.QueryTerminalAudioAndVideoAttributes), T1003.class);
        return response;
    }

    @Operation(summary = "9101 Real-time audio and video transmission request")
    @GetMapping("realtime/play")
    public Mono<APIResult<T0001>> realtimePlay(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T9101 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "9102 Audio and video real-time transmission control")
    @GetMapping("realtime/control")
    public Mono<APIResult<T0001>> realtimeControl(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T9102 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "9201 The platform issues a remote video playback request")
    @GetMapping("history/play")
    public Mono<APIResult<T1205>> historyPlay(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T9201 request) {
        Mono<APIResult<T1205>> response = messageManager.requestR(clientId, request, T1205.class);
        return response;
    }

    @Operation(summary = "9202 Remote video playback control issued by the platform")
    @GetMapping("history/control")
    public Mono<APIResult<T0001>> historyControl(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T9202 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "9205 Query resource list")
    @GetMapping("file/search")
    public Mono<APIResult<T1205>> fileSearch(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T9205 request) {
        Mono<APIResult<T1205>> response = messageManager.requestR(clientId, request, T1205.class);
        return response;
    }

    @Operation(summary = "9206 file upload instruction")
    @GetMapping("file/upload")
    public Mono<APIResult<T0001>> fileUpload(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T9206 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "9207 File upload control")
    @GetMapping("file/upload/control")
    public Mono<APIResult<T0001>> fileUploadControl(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T9207 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "9301 PTZ rotation")
    @GetMapping("pan_tilt/revolve")
    public Mono<APIResult<T0001>> panTiltRevolve(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T9301 request) {
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }

    @Operation(summary = "9302 9303 9304 9305 9306 PTZ control")
    @GetMapping("pan_tilt/control")
    public Mono<APIResult<T0001>> panTiltControl(@Parameter(description = "Terminal phone number") @RequestParam String clientId, T9302 request,
                                                 @Parameter(description = "Control type: 9302. PTZ adjustment focus control 9303. PTZ adjustment aperture control 9304. PTZ wiper control 9305. Infrared fill light control 9306. PTZ zoom control") @RequestParam String type) {
        request.setMessageId(Integer.parseInt(type, 16));
        Mono<APIResult<T0001>> response = messageManager.requestR(clientId, request, T0001.class);
        return response;
    }
}