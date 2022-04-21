package com.jt808.web.config;

import com.jt808.web.endpoint.JTHandlerInterceptor;
import com.jt808.web.endpoint.JTMultiPacketListener;
import com.jt808.web.endpoint.JTSessionListener;
import io.github.yezhihao.netmc.core.HandlerMapping;
import io.github.yezhihao.netmc.core.SpringHandlerMapping;
import io.github.yezhihao.netmc.session.SessionListener;
import io.github.yezhihao.netmc.session.SessionManager;
import io.github.yezhihao.protostar.SchemaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import com.jt808.protocol.codec.DataFrameMessageDecoder;
import com.jt808.protocol.codec.JTMessageAdapter;
import com.jt808.protocol.codec.JTMessageEncoder;
import com.jt808.protocol.codec.MultiPacketDecoder;
import com.jt808.web.model.enums.SessionKey;

@Configuration
public class JTBeanConfig {

    private final SimpMessagingTemplate messagingTemplate;

    public JTBeanConfig(@Autowired(required = false) SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Bean
    public HandlerMapping handlerMapping() {
        return new SpringHandlerMapping();
    }

    @Bean
    public JTHandlerInterceptor handlerInterceptor() {
        return new JTHandlerInterceptor();
    }

    @Bean
    public SessionListener sessionListener() {
        return new JTSessionListener();
    }

    @Bean
    public SessionManager sessionManager(SessionListener sessionListener) {
        return new SessionManager(SessionKey.class, sessionListener);
    }

    @Bean
    public SchemaManager schemaManager() {
        return new SchemaManager("com.jt808.protocol", "com.jt808.web.model.protocol");
    }

    @Bean
    public JTMessageAdapter messageAdapter(SchemaManager schemaManager) {
        JTMessageEncoder encoder = new JTMessageEncoder(schemaManager);
        MultiPacketDecoder decoder = new MultiPacketDecoder(schemaManager, new JTMultiPacketListener(10));
        if (messagingTemplate == null)
            return new JTMessageAdapter(encoder, decoder);
        return new WebLogAdapter(encoder, decoder, messagingTemplate);
    }

    @Bean
    public JTMessageAdapter alarmFileMessageAdapter(SchemaManager schemaManager) {
        JTMessageEncoder encoder = new JTMessageEncoder(schemaManager);
        DataFrameMessageDecoder decoder = new DataFrameMessageDecoder(schemaManager, new byte[]{0x30, 0x31, 0x63, 0x64});
        if (messagingTemplate == null)
            return new JTMessageAdapter(encoder, decoder);
        return new WebLogAdapter(encoder, decoder, messagingTemplate);
    }
}