package com.aaalace.kpomini1.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String getCurrentTimestamp() {
        return LocalDateTime.now().format(FORMATTER);
    }
}
