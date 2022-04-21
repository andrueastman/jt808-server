package com.jt808.commons.util;

/**
 * Utils for Geo mapping
 */
public class GeomUtils {

    /**
     * Radius of the earth, the unit (WGS - 84 semi-major axis)
     */
    private static final double RADIUS = 6378137;

    /**
     * Spherical distance calculation point to point (m)
     */
    public static double distance(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = Math.toRadians(lat1);
        double radLat2 = Math.toRadians(lat2);
        double a = radLat1 - radLat2;
        double b = Math.toRadians(lng1) - Math.toRadians(lng2);

        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        distance = distance * RADIUS;
        distance = Math.round(distance * 10000) / 10000D;
        return distance;
    }

    /**
     * Plane distance calculation point to point (m)
     */
    public static double distance_(double x1, double y1, double x2, double y2) {
        double a = x1 - x2;
        double b = y1 - y2;
        double distance = Math.sqrt(Math.abs((a * a) + (b * b)));
        return distance * 100000;
    }

    /**
     * Distance calculation point to the line (in meters)
     */
    public static double distancePointToLine(double x1, double y1, double x2, double y2, double x0, double y0) {
        double a = distance_(x1, y1, x2, y2);
        double b = distance_(x1, y1, x0, y0);
        double c = distance_(x2, y2, x0, y0);
        if (c <= 0.001 || b <= 0.001) {
            return 0.0;
        }
        if (a <= 0.001) {
            return b;
        }

        double aa = a * a;
        double bb = b * b;
        double cc = c * c;
        if (cc >= aa + bb) {
            return b;
        }
        if (bb >= aa + cc) {
            return c;
        }
        double p = (a + b + c) / 2D;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return 2D * s / a;
    }

    /**
     * Whether coordinates within the rectangle
     */
    public static boolean inside(double x, double y, double minX, double minY, double maxX, double maxY) {
        return (x >= minX && x <= maxX &&
                y >= minY && y <= maxY);
    }

    /**
     * To judge whether coordinates inside the polygon
     */
    public static boolean inside(double x, double y, double[] points) {
        boolean oddNodes = false;

        double ret;
        for (int i = 0, j = points.length - 2; i < points.length; i += 2) {
            double x1 = points[i];
            double y1 = points[i + 1];
            double x2 = points[j];
            double y2 = points[j + 1];

            if ((y1 < y && y2 >= y) || (y2 < y && y1 >= y)) {
                ret = x1 + (y - y1) / (y2 - y1) * (x2 - x1);
                if (ret < x)
                    oddNodes = !oddNodes;
            }
            j = i;
        }
        return oddNodes;
    }

    /**
     * To judge whether coordinates inside the polygon
     */
    public static boolean inPolygon(double x, double y, double[] points) {
        double sum = 0;
        int length = points.length - 2;
        for (int i = 0; i < length; i += 2) {
            double sx = points[i];
            double sy = points[i + 1];
            double tx = points[i + 2];
            double ty = points[i + 3];

            //Point and a polygon vertex overlap or on the side of the polygon
            if ((sx - x) * (x - tx) >= 0 &&
                    (sy - y) * (y - ty) >= 0 &&
                    (x - sx) * (ty - sy) == (y - sy) * (tx - sx))
                return true;
            //Point and adjacent vertex Angle of attachment
            double angle = Math.atan2(sy - y, sx - x) - Math.atan2(ty - y, tx - x);

            //Ensure that the Angle is not beyond the scope (- PI PI)
            if (angle >= Math.PI)
                angle = angle - Math.PI * 2;
            else if (angle <= -Math.PI)
                angle = angle + Math.PI * 2;
            sum += angle;
        }
        //Calculation of rotary and the geometric relationship between point and polygon
        return (int) (sum / Math.PI) != 0;
    }
}