package com.dobromir.stefanov.fastaccounting.DAOs;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.dobromir.stefanov.fastaccounting.Database.AccDatabase;
import com.dobromir.stefanov.fastaccounting.Objects.AccCategory;

import java.util.List;

public class AccCategoryRepository {
    private AccCategoryDao accCategoryDao;
    private LiveData<List<AccCategory>> allCategories;
    private LiveData<List<AccCategory>> allMainCategories;

    public AccCategoryRepository(Application application) {
        AccDatabase db = AccDatabase.getDatabase(application);
        accCategoryDao = db.accCategoryDao();
        allCategories = accCategoryDao.getAllCategories();
        allMainCategories = accCategoryDao.getAllMainCategories();
    }

    public LiveData<List<AccCategory>> getAllCategories() {
        return this.allCategories;
    }

    public LiveData<List<AccCategory>> getAllMainCategories() {
        return this.allMainCategories;
    }

    public void insertCategory(AccCategory accCategory) {
        new insertAsyncTask(accCategoryDao).execute(accCategory);
    }

    private static class insertAsyncTask extends AsyncTask<AccCategory, Void, Void> {
        private AccCategoryDao asyncAccCategoryDao;

        insertAsyncTask(AccCategoryDao accCategoryDao) {
            this.asyncAccCategoryDao = accCategoryDao;
        }

        @Override
        protected Void doInBackground(AccCategory... accCategories) {
            asyncAccCategoryDao.insertNewAccCategory(accCategories[0]);
            return null;
        }
    }
}
