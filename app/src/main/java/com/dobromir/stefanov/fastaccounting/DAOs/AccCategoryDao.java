package com.dobromir.stefanov.fastaccounting.DAOs;

import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.dobromir.stefanov.fastaccounting.Objects.AccCategory;

import java.util.List;

@Dao
public interface AccCategoryDao {
    @Query("SELECT * FROM categories")
    LiveData<List<AccCategory>> getAllCategories();

    @Query("SELECT * FROM categories WHERE parent_category_id IS NULL")
    LiveData<List<AccCategory>> getAllMainCategories();

    @Insert
    void insertNewAccCategory(AccCategory accCategory);

    @Delete
    void deleteAccCategory(AccCategory accCategory);
}