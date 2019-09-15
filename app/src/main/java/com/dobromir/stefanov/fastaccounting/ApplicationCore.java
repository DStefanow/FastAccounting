package com.dobromir.stefanov.fastaccounting;

import android.app.Application;

import com.dobromir.stefanov.fastaccounting.Database.AccDatabase;
import com.dobromir.stefanov.fastaccounting.Objects.AccCategory;
import com.dobromir.stefanov.fastaccounting.Objects.AccTransaction;
import com.dobromir.stefanov.fastaccounting.Objects.AccountingType;

import java.util.ArrayList;

public class ApplicationCore extends Application {
    public static ArrayList<AccTransaction> accTransactions;
    public static AccDatabase dbManager;

    @Override
    public void onCreate() {
        super.onCreate();

        dbManager = AccDatabase.getDatabase(this);
    }
}
