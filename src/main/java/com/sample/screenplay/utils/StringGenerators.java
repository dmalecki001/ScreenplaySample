package com.sample.screenplay.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class StringGenerators {

    private static String getFormattedDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private static String getUUID(int substring) {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, substring);
    }

    public static String generateRandomUUId() {
        return getUUID(2) + getFormattedDate();
    }

    public static String randomId() {
        return getUUID(6);
    }

    public static String numberBetween(int min, int max) {
        return String.valueOf(ThreadLocalRandom.current().nextInt(max - min) + min);
    }

    public static String getRandomYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        LocalDate date = LocalDate.now().minusYears(Long.parseLong(numberBetween(18, 71)));
        return date.format(formatter);
    }
}
