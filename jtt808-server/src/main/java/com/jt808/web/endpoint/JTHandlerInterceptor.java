package com.jt808.web.endpoint;

import io.github.yezhihao.netmc.core.HandlerInterceptor;
import io.github.yezhihao.netmc.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;
import com.jt808.protocol.t808.T0001;
import com.jt808.web.model.enums.SessionKey;

public class JTHandlerInterceptor implements HandlerInterceptor<JTMessage> {

    private static final Logger log = LoggerFactory.getLogger(JTHandlerInterceptor.class.getSimpleName());

    /** No corresponding Handle found */
    @Override
    public JTMessage notSupported(JTMessage request, Session session) {
        T0001 response = new T0001();
        response.copyBy(request);
        response.setMessageId(JT808.PlatformUniversalResponse);
        response.setSerialNo(session.nextSerialNo());

        response.setResponseSerialNo(request.getSerialNo());
        response.setResponseMessageId(request.getMessageId());
        response.setResultCode(T0001.NotSupport);

        log.info("{}\n<<<<-unidentified message{}\n>>>>-{}", session, request, response);
        return response;
    }


    /** After the call, the return value is void */
    @Override
    public JTMessage successful(JTMessage request, Session session) {
        T0001 response = new T0001();
        response.copyBy(request);
        response.setMessageId(JT808.PlatformUniversalResponse);
        response.setSerialNo(session.nextSerialNo());

        response.setResponseSerialNo(request.getSerialNo());
        response.setResponseMessageId(request.getMessageId());
        response.setResultCode(T0001.Success);

        return response;
    }

    /** throws an exception after calling */
    @Override
    public JTMessage exceptional(JTMessage request, Session session, Exception e) {
        T0001 response = new T0001();
        response.copyBy(request);
        response.setMessageId(JT808.PlatformUniversalResponse);
        response.setSerialNo(session.nextSerialNo());

        response.setResponseSerialNo(request.getSerialNo());
        response.setResponseMessageId(request.getMessageId());
        response.setResultCode(T0001.Failure);

        log.warn(session + "\n<<<<-" + request + "\n>>>>-" + response + '\n', e);
        return response;
    }

    /** before calling */
    @Override
    public boolean beforeHandle(JTMessage request, Session session) {
        int messageId = request.getMessageId();
        if (messageId == JT808.TerminalRegistration || messageId == JT808.TerminalAuthentication)
            return true;
        if (messageId == JT808.LocationInformationReport) {
            request.transform();
            session.setAttribute(SessionKey.Snapshot, request);
        }
        if (!session.isRegistered()) {
            log.info("{}unregistered device<<<<-{}", session, request);
            // TODO fix Hack query device for its its device ID
            session.register(request);

            return true;
        }
        return true;
    }

    /** after calling */
    @Override
    public void afterHandle(JTMessage request, JTMessage response, Session session) {
        if (response != null) {
            response.copyBy(request);
            response.setSerialNo(session.nextSerialNo());

            if (response.getMessageId() == 0) {
                response.setMessageId(response.reflectMessageId());
            }
        }
    }
}