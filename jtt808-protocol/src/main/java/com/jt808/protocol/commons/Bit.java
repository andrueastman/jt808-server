package com.jt808.protocol.commons;

public class Bit {

    public static boolean isTrue(int n, int i) {
        return get(n, i) > 0;
    }

    public static int get(int n, int i) {
        return (1 << i) & n;
    }

    public static int set1(int n, int i) {
        return (1 << i) | n;
    }

    public static int set0(int n, int i) {
        return get(n, i) ^ n;
    }

    public static int set(int n, int i, boolean bool) {
        return bool ? set1(n, i) : set0(n, i);
    }

    public static int writeInt(int... bit) {
        int n = 0;
        for (int i = 0; i < bit.length; i++)
            n = set(n, i, bit[i] > 0);
        return n;
    }
}