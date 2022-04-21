package com.jt808.web.controller;

import io.github.yezhihao.netmc.session.Session;
import io.github.yezhihao.netmc.session.SessionManager;
import io.github.yezhihao.protostar.SchemaManager;
import io.github.yezhihao.protostar.util.Explain;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
import com.jt808.commons.model.APIResult;
import com.jt808.commons.util.LogUtils;
import com.jt808.protocol.codec.JTMessageDecoder;
import com.jt808.protocol.codec.MultiPacketDecoder;
import com.jt808.web.config.WebLogAdapter;
import com.jt808.web.model.vo.DeviceInfo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class OtherController {

    private final SessionManager sessionManager;

    private final JTMessageDecoder decoder;

    public OtherController(SessionManager sessionManager, SchemaManager schemaManager) {
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

    @Operation(summary = "808 protocol analysis tool")
    @RequestMapping(value = "message/explain", method = {RequestMethod.POST, RequestMethod.GET})
    public String decode(@Parameter(description = "hexadecimal message") @RequestParam String hex) {
        Explain explain = new Explain();
        hex = hex.replace(" ", "");
        String[] lines = hex.split("\n");
        for (String line : lines) {
            String[] msgs = line.split("7e7e");
            for (String msg : msgs) {
                ByteBuf byteBuf = Unpooled.wrappedBuffer(ByteBufUtil.decodeHexDump(msg));
                decoder.decode(byteBuf, explain);
            }
        }
        return explain.toString();
    }

    @Operation(summary = "original message sent")
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