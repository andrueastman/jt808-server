package com.jt808.protocol.codec;

import io.github.yezhihao.protostar.SchemaManager;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jt808.protocol.basics.JTMessage;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MultiPacketDecoder extends JTMessageDecoder {

    private static final Logger log = LoggerFactory.getLogger(MultiPacketDecoder.class.getSimpleName());

    private final Map<String, MultiPacket> multiPacketsMap;

    private final MultiPacketListener multiPacketListener;

    public MultiPacketDecoder(String... basePackages) {
        this(new SchemaManager(basePackages));
    }

    public MultiPacketDecoder(SchemaManager schemaManager) {
        this(schemaManager, null);
    }

    public MultiPacketDecoder(SchemaManager schemaManager, MultiPacketListener multiPacketListener) {
        super(schemaManager);
        if (multiPacketListener == null) {
            this.multiPacketsMap = new WeakHashMap<>();
            this.multiPacketListener = null;
        } else {
            this.multiPacketsMap = new ConcurrentHashMap<>();
            this.multiPacketListener = multiPacketListener;
            startListener();
        }
    }

    @Override
    protected ByteBuf[] addAndGet(JTMessage message, ByteBuf packetData) {
        String clientId = message.getClientId();
        int messageId = message.getMessageId();
        int packageTotal = message.getPackageTotal();
        int packetNo = message.getPackageNo();

        String key = new StringBuilder(21).append(clientId).append('/').append(messageId).append('/').append(packageTotal).toString();

        MultiPacket multiPacket = multiPacketsMap.get(key);
        if (multiPacket == null)
            multiPacketsMap.put(key, multiPacket = new MultiPacket(message));
        if (packetNo == 1)
            multiPacket.setSerialNo(message.getSerialNo());


        ByteBuf[] packages = multiPacket.addAndGet(packetNo, packetData);
        log.info("<<<<<subcontracted message{}", multiPacket);
        if (packages == null)
            return null;
        multiPacketsMap.remove(key);
        return packages;
    }

    private void startListener() {
        Thread thread = new Thread(() -> {
            long timeout = multiPacketListener.timeout;
            for (; ; ) {
                long nextDelay = timeout;
                long now = System.currentTimeMillis();

                for (Map.Entry<String, MultiPacket> entry : multiPacketsMap.entrySet()) {
                    MultiPacket packet = entry.getValue();

                    long time = timeout - (now - packet.getLastAccessedTime());
                    if (time <= 0) {
                        if (!multiPacketListener.receiveTimeout(packet)) {
                            log.warn("<<<<<Packet receive timeout{}", packet);
                            multiPacketsMap.remove(entry.getKey());
                            packet.release();
                        }
                    } else {
                        nextDelay = Math.min(time, nextDelay);
                    }
                }
                try {
                    Thread.sleep(nextDelay);
                } catch (InterruptedException e) {
                    log.error("MultiPacketListener", e);
                }
            }
        });
        thread.setName("MultiPacketListener");
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.setDaemon(true);
        thread.start();
    }
}