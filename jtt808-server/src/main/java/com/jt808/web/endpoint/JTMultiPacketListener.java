package com.jt808.web.endpoint;

import io.github.yezhihao.netmc.session.Session;
import com.jt808.protocol.codec.MultiPacket;
import com.jt808.protocol.codec.MultiPacketListener;
import com.jt808.protocol.commons.JT808;
import com.jt808.protocol.t808.T8003;

import java.util.List;

public class JTMultiPacketListener extends MultiPacketListener {

    public JTMultiPacketListener(int timeout) {
        super(timeout);
    }

    @Override
    public boolean receiveTimeout(MultiPacket multiPacket) {
        int retryCount = multiPacket.getRetryCount();
        if (retryCount > 5)
            return false;

        T8003 request = new T8003();
        request.setMessageId(JT808.TheServerRetransmitsTheSubcontractingRequest);
        request.copyBy(multiPacket.getFirstPacket());
        request.setResponseSerialNo(multiPacket.getSerialNo());
        List<Integer> notArrived = multiPacket.getNotArrived();
        short[] idList = new short[notArrived.size()];
        for (int i = 0; i < idList.length; i++) {
            idList[i] = notArrived.get(i).shortValue();
        }
        request.setId(idList);
        Session session = multiPacket.getFirstPacket().getSession();
        if (session != null) {
            session.notify(request);
            multiPacket.addRetryCount(1);
            return true;
        }
        return false;
    }
}