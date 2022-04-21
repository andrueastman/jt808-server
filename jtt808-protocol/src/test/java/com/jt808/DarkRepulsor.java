package com.jt808;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.codec.JTMessageDecoder;
import com.jt808.protocol.codec.JTMessageEncoder;

public class DarkRepulsor {

    private static JTMessageDecoder decoder = new JTMessageDecoder("com.jt808.protocol");
    private static JTMessageEncoder encoder = new JTMessageEncoder("com.jt808.protocol");

    //560
    public static void main(String[] args) {
        String hex = "7e0200407c0100000000017299841738ffff000004000000080006eeb6ad02633df701380003006320070719235901040000000b02020016030200210402002c051e3737370000000000000000000000000000000000000000000000000000001105420000004212064d0000004d4d1307000000580058582504000000632a02000a2b040000001430011e310128637e";
        ByteBuf buf = Unpooled.wrappedBuffer(ByteBufUtil.decodeHexDump(hex));

        while (true) {
            long s = System.currentTimeMillis();

            for (int i = 0; i < 100000; i++) {
                JTMessage message = decoder.decode(buf);
                message.setSerialNo(message.getSerialNo() + 1);

                buf.release();
                buf = encoder.encode(message);
            }
            System.out.println(System.currentTimeMillis() - s);
        }
    }
}