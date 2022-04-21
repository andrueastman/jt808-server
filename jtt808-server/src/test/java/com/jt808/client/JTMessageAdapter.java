package com.jt808.client;

import io.github.yezhihao.netmc.codec.MessageDecoder;
import io.github.yezhihao.netmc.codec.MessageEncoder;
import io.github.yezhihao.netmc.session.Session;
import io.netty.buffer.ByteBuf;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.codec.JTMessageDecoder;
import com.jt808.protocol.codec.JTMessageEncoder;

public class JTMessageAdapter implements MessageEncoder<JTMessage>, MessageDecoder<JTMessage> {

    private JTMessageEncoder messageEncoder;

    private JTMessageDecoder messageDecoder;

    public JTMessageAdapter(JTMessageEncoder messageEncoder, JTMessageDecoder messageDecoder) {
        this.messageEncoder = messageEncoder;
        this.messageDecoder = messageDecoder;
    }

    public ByteBuf encode(JTMessage message, Session session) {
        ByteBuf output = messageEncoder.encode(message);
        return output;
    }

    @Override
    public JTMessage decode(ByteBuf input, Session session) {
        JTMessage message = messageDecoder.decode(input);
        return message;
    }
}
