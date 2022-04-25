package com.jt808.commons.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 */
public class DateUtils {

    public static final DateTimeFormatter yyMMddHHmmss = DateTimeFormatter.ofPattern("yyMMddHHmmss");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final ZoneOffset GMT8 = ZoneOffset.ofHours(8);
    private static final Logger log = LoggerFactory.getLogger(DateUtils.class.getSimpleName());

    public static LocalDateTime parse(String str) {
        try {
            return LocalDateTime.parse(str, yyMMddHHmmss);
        } catch (Exception e) {
            log.error("Incorrect date format: [{}]", str);
            return null;
        }
    }
}