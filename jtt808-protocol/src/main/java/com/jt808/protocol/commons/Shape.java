package com.jt808.protocol.commons;

public final class Shape {

    /** Circle */
    public static final int Circle = 1;
    /** Rectangle */
    public static final int Rectangle = 2;
    /** Polygon */
    public static final int Polygon = 3;
    /** Route */
    public static final int Route = 4;

    /**
     * @param type shape：1.Circle 2.Rectangle 3.Polygon 4.Route
     */
    public static int toMessageId(int type) {
        switch (type) {
            case Shape.Circle:
                return JT808.DeleteCircularArea;
            case Shape.Rectangle:
                return JT808.DeleteRectangularArea;
            case Shape.Polygon:
                return JT808.DeletePolygonArea;
            case Shape.Route:
                return JT808.DeleteRoute;
            default:
                throw new IllegalArgumentException(String.valueOf(type));
        }
    }
}