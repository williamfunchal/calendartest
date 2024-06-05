package com.copilotiq.calendar.utils;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {
    /**
     * Convert Instant to String
     * @param date
     * @return
     */
    public Instant stringToInstant(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }

    /**
     * Convert String date to sql.Date
     * @param date
     * @return
     */
    public Date stringToDate(String date) {
        return java.sql.Date.valueOf(date);
    }
}
