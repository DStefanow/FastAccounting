package com.dobromir.stefanov.fastaccounting;

import android.app.Application;

import com.dobromir.stefanov.fastaccounting.Objects.AccCategory;
import com.dobromir.stefanov.fastaccounting.Objects.AccTransaction;
import com.dobromir.stefanov.fastaccounting.Objects.AccountingType;

import java.util.ArrayList;

public class ApplicationCore extends Application {
    public static ArrayList<AccTransaction> accTransactions;

    @Override
    public void onCreate() {
        super.onCreate();

        AddExampleTransactions();
    }

    public static void AddExampleTransactions() {
        // Create some categories
        ArrayList<AccCategory> accCategories = new ArrayList<AccCategory>();
        accCategories.add(new AccCategory("Rent"));
        accCategories.add(new AccCategory("Salary"));
        accCategories.add(new AccCategory("Car"));
        accCategories.add(new AccCategory("Stocks"));
        accCategories.add(new AccCategory("Food"));

        accTransactions = new ArrayList<AccTransaction>();
        accTransactions.add(new AccTransaction(1, AccountingType.OUTCOME, accCategories.get(0),
                520, "При селяните в Студентски"));
        accTransactions.add(new AccTransaction(2, AccountingType.INCOME, accCategories.get(0),
                400, "Lulin 5"));
        accTransactions.add(new AccTransaction(3, AccountingType.INCOME, accCategories.get(1),
                1787, "На 15то число се случват чудеса"));
        accTransactions.add(new AccTransaction(4, AccountingType.OUTCOME, accCategories.get(2),
                100, "Sometimes shits happens"));
        accTransactions.add(new AccTransaction(5, AccountingType.INCOME,
                accCategories.get(3), 0.123, "Слабо"));
        accTransactions.add(new AccTransaction(6, AccountingType.OUTCOME,
                accCategories.get(4), 1200, "Trea se qde"));
    }
}
