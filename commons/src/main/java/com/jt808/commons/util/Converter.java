package com.jt808.commons.util;

/**
 * Coordinate system converter
 */
@FunctionalInterface
public interface Converter {

    double[] convert(double... p);

}