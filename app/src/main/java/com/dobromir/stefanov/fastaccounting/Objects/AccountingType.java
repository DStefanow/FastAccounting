package com.dobromir.stefanov.fastaccounting.Objects;

import androidx.room.Ignore;
import androidx.room.TypeConverter;

// Define the basic accounting types
public enum AccountingType {
    INCOME(0),
    OUTCOME(1);

    private int accTypeCode;

    AccountingType(int accTypeCode) {
        this.accTypeCode = accTypeCode;
    }

    public int getAccTypeCode() {
        return this.accTypeCode;
    }
}
