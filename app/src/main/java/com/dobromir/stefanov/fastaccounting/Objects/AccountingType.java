package com.dobromir.stefanov.fastaccounting.Objects;

// Define the basic accounting types
public enum AccountingType {
    INCOME(0),
    OUTCOME(1);

    private int accTypeCode;

    AccountingType(int accTypeCode) {
        this.accTypeCode = accTypeCode;
    }

    public int getAccTypeCode() {
        return accTypeCode;
    }
}
