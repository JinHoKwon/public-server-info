package com.jh.app.utils;

import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    private DateTimeUtils() {}
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
}
