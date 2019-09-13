package com.dobromir.stefanov.fastaccounting.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dobromir.stefanov.fastaccounting.DAOs.AccCategoryDao;
import com.dobromir.stefanov.fastaccounting.DAOs.AccTransactionDao;
import com.dobromir.stefanov.fastaccounting.Objects.AccCategory;
import com.dobromir.stefanov.fastaccounting.Objects.AccTransaction;

@Database(entities = {AccCategory.class, AccTransaction.class}, version =  1)
public abstract class AccDatabase extends RoomDatabase {
    public abstract AccCategoryDao accCategoryDao();
    public abstract AccTransactionDao accTransactionDao();

    private static volatile AccDatabase INSTANCE;

    static AccDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AccDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AccDatabase.class, "fast_accounting").build();
                }
            }
        }

        return INSTANCE;
    }
}
