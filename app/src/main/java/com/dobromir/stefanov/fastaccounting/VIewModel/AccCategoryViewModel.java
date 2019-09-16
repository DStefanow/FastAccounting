package com.dobromir.stefanov.fastaccounting.VIewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dobromir.stefanov.fastaccounting.DAOs.AccCategoryRepository;
import com.dobromir.stefanov.fastaccounting.Objects.AccCategory;

import java.util.List;

public class AccCategoryViewModel extends AndroidViewModel {
    private AccCategoryRepository accCategoryRepository;
    private LiveData<List<AccCategory>> allCategories;
    private LiveData<List<AccCategory>> allMainCategories;

    public AccCategoryViewModel(@NonNull Application application) {
        super(application);
        accCategoryRepository = new AccCategoryRepository(application);
        allCategories = accCategoryRepository.getAllCategories();
        allMainCategories = accCategoryRepository.getAllMainCategories();
    }

    public LiveData<List<AccCategory>> getAllCategories() {
        return this.allCategories;
    }

    public LiveData<List<AccCategory>> getAllMainCategories() {
        return this.allMainCategories;
    }

    public void insertCategory(AccCategory accCategory) {
        accCategoryRepository.insertCategory(accCategory);
    }
}
