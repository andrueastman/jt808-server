package com.jt808.protocol.basics;

public interface JTMessageFilter<T extends JTMessage> {

    boolean doFilter(T message);
}