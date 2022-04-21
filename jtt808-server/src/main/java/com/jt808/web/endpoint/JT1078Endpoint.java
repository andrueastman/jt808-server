package com.jt808.web.endpoint;

import io.github.yezhihao.netmc.core.annotation.Endpoint;
import io.github.yezhihao.netmc.core.annotation.Mapping;
import io.github.yezhihao.netmc.session.Session;
import org.springframework.stereotype.Component;
import com.jt808.protocol.t1078.T1003;
import com.jt808.protocol.t1078.T1005;
import com.jt808.protocol.t1078.T1205;
import com.jt808.protocol.t1078.T1206;

import static com.jt808.protocol.commons.JT1078.*;

@Endpoint
@Component
public class JT1078Endpoint {

    @Mapping(types = TerminalUploadAudioAndVideoAttributes, desc = "Terminal upload audio and video attributes")
    public void mediaAttributesResponse(T1003 message, Session session) {
        session.response(message);
    }

    @Mapping(types = TerminalUploadPassengerTraffic, desc = "Terminal upload passenger traffic")
    public void passengerVolumeReport(T1005 message, Session session) {

    }

    @Mapping(types = ListOfAudioAndVideoResourcesUploadedByTheTerminal, desc = "List of audio and video resources uploaded by the terminal")
    public void fileSearchResponse(T1205 message, Session session) {
        session.response(message);
    }

    @Mapping(types = FileUploadCompletionNotification, desc = "File upload completion notification")
    public void fileUploadComplete(T1206 message, Session session) {
    }
}