package com.jt808.web.controller;

import io.github.yezhihao.netmc.session.Session;
import io.github.yezhihao.netmc.session.SessionManager;
import io.github.yezhihao.protostar.SchemaManager;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
import com.jt808.commons.model.APIResult;
import com.jt808.commons.util.LogUtils;
import com.jt808.protocol.codec.JTMessageDecoder;
import com.jt808.protocol.codec.MultiPacketDecoder;
import com.jt808.web.config.WebLogAdapter;
import com.jt808.web.model.vo.DeviceInfo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class ServerController {

    private final SessionManager sessionManager;

    private final JTMessageDecoder decoder;

    public ServerController(SessionManager sessionManager, SchemaManager schemaManager) {
        this.sessionManager = sessionManager;
        this.decoder = new MultiPacketDecoder(schemaManager);
    }

    @Operation(summary = "Terminal real-time information query")
    @GetMapping("terminal/all")
    public APIResult<Collection<Session>> all() {
        Collection<Session> all = sessionManager.all();
        return new APIResult<>(all);
    }

    @Operation(summary = "Get all current online device information")
    @GetMapping("terminal/option")
    public APIResult<List<String>> getClientId() {
        Collection<Session> all = sessionManager.all();
        List<String> result = all.stream().map(Session::getId).collect(Collectors.toList());
        return APIResult.ok(result);
    }

    @Operation(summary = "websocket subscription")
    @PostMapping("terminal/ws")
    public APIResult<DeviceInfo> ws(@RequestParam String clientId, @RequestParam int sub) {
        if (sub > 0) {
            Session session = sessionManager.get(clientId);
            if (session != null) {
                WebLogAdapter.addClient(session.getClientId());
                return new APIResult(Collections.singletonMap("clientId", session.getClientId()));
            }
        } else {
            WebLogAdapter.removeClient(clientId);
        }
        return APIResult.SUCCESS;
    }

    @Operation(summary = "Send raw message")
    @PostMapping("terminal/raw")
    public String postRaw(@Parameter(description = "Terminal phone number") @RequestParam String clientId,
                          @Parameter(description = "hexadecimal message") @RequestParam String message) {
        Session session = sessionManager.get(clientId);
        if (session != null) {
            ByteBuf byteBuf = Unpooled.wrappedBuffer(ByteBufUtil.decodeHexDump(message));
            session.notify(byteBuf);
            return "success";
        }
        return "fail";
    }

    @Operation(summary = "Change log level")
    @GetMapping("logger")
    public String logger(@RequestParam LogUtils.Lv level) {
        LogUtils.setLevel(level.value);
        return "success";
    }

}