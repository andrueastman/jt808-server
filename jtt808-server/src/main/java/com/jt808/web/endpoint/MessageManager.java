package com.jt808.web.endpoint;

import io.github.yezhihao.netmc.session.Session;
import io.github.yezhihao.netmc.session.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.jt808.commons.model.APIException;
import com.jt808.commons.model.APIResult;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.web.model.enums.SessionKey;
import com.jt808.web.model.vo.DeviceInfo;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class MessageManager {

    private static final Logger log = LoggerFactory.getLogger(MessageManager.class);

    private static final Mono<Void> NEVER = Mono.never();
    private static final Mono OFFLINE_EXCEPTION = Mono.error(new APIException(4000, "offline client"));
    private static final Mono OFFLINE_RESULT = Mono.just(new APIResult<>(4000, "offline client"));
    private static final Mono SENDFAIL_RESULT = Mono.just(new APIResult<>(4001, "Failed to send message"));
    private static final Mono TIMEOUT_RESULT = Mono.just(new APIResult<>(4002, "message sent successfully,Client response timed out"));

    private SessionManager sessionManager;

    public MessageManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public Mono<Void> notifyR(String sessionId, JTMessage request) {
        Session session = sessionManager.get(sessionId);
        if (session == null)
            return OFFLINE_EXCEPTION;

        fillHeader(request, session);
        return session.notify(request);
    }

    public Mono<Void> notify(String sessionId, JTMessage request) {
        Session session = sessionManager.get(sessionId);
        if (session == null)
            return NEVER;

        fillHeader(request, session);
        return session.notify(request);
    }

    public <T> Mono<APIResult<T>> requestR(String sessionId, JTMessage request, Class<T> responseClass) {
        Session session = sessionManager.get(sessionId);
        if (session == null)
            return OFFLINE_RESULT;

        fillHeader(request, session);
        return session.request(request, responseClass)
                .map(message -> APIResult.ok(message))
                .timeout(Duration.ofSeconds(10), TIMEOUT_RESULT)
                .onErrorResume(e -> {
                    log.warn("Failed to send message", e);
                    return SENDFAIL_RESULT;
                });
    }

    public <T> Mono<T> request(String sessionId, JTMessage request, Class<T> responseClass, long timeout) {
        return request(sessionId, request, responseClass).timeout(Duration.ofMillis(timeout));
    }

    public <T> Mono<T> request(String sessionId, JTMessage request, Class<T> responseClass) {
        Session session = sessionManager.get(sessionId);
        if (session == null)
            return OFFLINE_EXCEPTION;

        fillHeader(request, session);
        return session.request(request, responseClass);
    }

    private static void fillHeader(JTMessage request, Session session) {
        request.setClientId(session.getClientId());
        request.setSerialNo(session.nextSerialNo());

        DeviceInfo device = SessionKey.getDeviceInfo(session);
        int protocolVersion = device.getProtocolVersion();
        if (protocolVersion > 0) {
            request.setVersion(true);
            request.setProtocolVersion(protocolVersion);
        }
        if (request.getMessageId() == 0) {
            request.setMessageId(request.reflectMessageId());
        }
    }
}