package com.cosmos.ecommerce.common.utils;

import java.time.LocalDateTime;

public class DateTimeUtil {

    private DateTimeUtil() {
    }

    public static LocalDateTime now() {

        return LocalDateTime.now();
    }
}