package com.dobromir.stefanov.fastaccounting.Objects;

public class AccTransaction {
    private int id;
    private AccountingType accType;
    private AccCategory accCategory;
    private double amount;
    private String note;

    public AccTransaction(int id, AccountingType accType, AccCategory accCategory, double amount, String note) {
        this.id = id;
        this.accType = accType;
        this.accCategory = accCategory;
        this.amount = amount;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public AccountingType getAccType() {
        return accType;
    }

    public AccCategory getAccCategory() {
        return accCategory;
    }

    public double getAmount() {
        return amount;
    }

    public String getNote() {
        return note;
    }
}
