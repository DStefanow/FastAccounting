package com.dobromir.stefanov.fastaccounting.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.dobromir.stefanov.fastaccounting.Objects.AccTransaction;

import java.util.List;

@Dao
public interface AccTransactionDao {
    @Query("SELECT * FROM transactions WHERE acc_type = :accType")
    LiveData<List<AccTransaction>> getTransactionsByType(int accType);

    @Query("SELECT * FROM transactions WHERE category_id = :category_id")
    LiveData<List<AccTransaction>> getTransactionsByCateogry(int category_id);

    @Query("SELECT * FROM transactions WHERE amount BETWEEN :minAmount AND :maxAmount")
    LiveData<List<AccTransaction>> getTransactionsBetweenAmount(double minAmount, double maxAmount);

    @Query("SELECT * FROM transactions WHERE transaction_time BETWEEN :minDate AND :maxDate")
    LiveData<List<AccTransaction>> getTransactionsBetweenTime(int minDate, int maxDate);

    @Insert
    void insertNewTransaction(AccTransaction accTransaction);

    @Delete
    void deleteTransaction(AccTransaction accTransaction);
}
