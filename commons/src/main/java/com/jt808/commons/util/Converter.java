package com.jt808.commons.util;

/**
 * 坐标系转换器
 */
@FunctionalInterface
public interface Converter {

    double[] convert(double... p);

}