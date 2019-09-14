package com.dobromir.stefanov.fastaccounting.Converters;

import androidx.room.TypeConverter;

import com.dobromir.stefanov.fastaccounting.Objects.AccountingType;

public class AccTypeConverter {
    @TypeConverter
    public static AccountingType typeFromCode(int accCode) {
        if (accCode == AccountingType.INCOME.getAccTypeCode()) {
            return AccountingType.INCOME;
        } else if (accCode == AccountingType.OUTCOME.getAccTypeCode()) {
            return AccountingType.OUTCOME;
        }

        return null;
    }

    @TypeConverter
    public static int codeFromType(AccountingType accType) {
        return  accType.getAccTypeCode();
    }
}
