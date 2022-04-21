package com.jt808.commons.util;

/**
 */
public enum CoordType {

    wgs84(
            p -> p,
            p -> CoordTransform.wgs84togcj02(p),
            p -> CoordTransform.gcj02tobd09(CoordTransform.wgs84togcj02(p))
    ),
    gcj02(
            p -> CoordTransform.gcj02towgs84(p),
            p -> p,
            p -> CoordTransform.gcj02tobd09(p)
    ),
    bd09(
            p -> CoordTransform.gcj02towgs84(CoordTransform.bd09togcj02(p)),
            p -> CoordTransform.bd09togcj02(p),
            p -> p
    );

    public final Converter WGS84;
    public final Converter GCJ02;
    public final Converter BD09;

    CoordType(Converter WGS84, Converter GCJ02, Converter BD09) {
        this.WGS84 = WGS84;
        this.GCJ02 = GCJ02;
        this.BD09 = BD09;
    }
}