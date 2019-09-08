package com.dobromir.stefanov.fastaccounting.Converters;

import androidx.room.TypeConverter;

import java.util.Date;

public class LocalDateConverter {
    @TypeConverter
    public static Date fromTimestamp(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long getTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
