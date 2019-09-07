package com.dobromir.stefanov.fastaccounting.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

@Entity(tableName = "transactions",
    foreignKeys = @ForeignKey(entity = AccCategory.class,
        parentColumns = "id",
        childColumns = "category_id",
        onDelete = ForeignKey.CASCADE))
public class AccTransaction {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "acc_type")
    private AccountingType accType;

    @ColumnInfo(name = "category_id")
    private int categoryId;

    private double amount;

    private String note;

    @ColumnInfo(name = "transaction_time")
    private LocalDateTime transactionTime;

    public AccTransaction(int id, AccountingType accType, int categoryId, double amount, String note, LocalDateTime transactionTime) {
        setId(id);
        setAccType(accType);
        setCategoryId(categoryId);
        setAmount(amount);
        setNote(note);
        setTransactionTime(transactionTime);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AccountingType getAccType() {
        return this.accType;
    }

    public void setAccType(AccountingType accType) {
        this.accType = accType;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        if (amount < 0.0) {
            return;
        }

        this.amount = amount;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        if (note.length() < 5) {
            return;
        }

        this.note = note;
    }

    public LocalDateTime getTransactionTime() {
        return this.transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}
