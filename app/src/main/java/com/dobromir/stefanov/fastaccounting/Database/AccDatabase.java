package com.dobromir.stefanov.fastaccounting.Database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.dobromir.stefanov.fastaccounting.Converters.LocalDateConverter;
import com.dobromir.stefanov.fastaccounting.Converters.AccTypeConverter;
import com.dobromir.stefanov.fastaccounting.DAOs.AccCategoryDao;
import com.dobromir.stefanov.fastaccounting.DAOs.AccTransactionDao;
import com.dobromir.stefanov.fastaccounting.Objects.AccCategory;
import com.dobromir.stefanov.fastaccounting.Objects.AccTransaction;


@Database(entities = {AccCategory.class, AccTransaction.class}, version =  1, exportSchema = false)
@TypeConverters({LocalDateConverter.class, AccTypeConverter.class})
public abstract class AccDatabase extends RoomDatabase {
    public abstract AccCategoryDao accCategoryDao();
    public abstract AccTransactionDao accTransactionDao();

    private static volatile AccDatabase INSTANCE;

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final AccCategoryDao mAccCategoryDao;

        PopulateDbAsync(AccDatabase db) {
            mAccCategoryDao = db.accCategoryDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mAccCategoryDao.insertNewAccCategory(new AccCategory("Food", 0));
            mAccCategoryDao.insertNewAccCategory(new AccCategory("Car", 0));
            return null;
        }
    }

    public static AccDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AccDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AccDatabase.class, "fast_accounting").
                            addCallback(sRoomDatabaseCallback).
                            build();
                }
            }
        }

        return INSTANCE;
    }
}
