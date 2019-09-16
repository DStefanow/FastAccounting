package com.dobromir.stefanov.fastaccounting.Objects;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories",
    indices = {
        @Index(value = {"id"}, unique = true),
        @Index(value = {"category_name"}, unique = true)
    })
public class AccCategory {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "category_name")
    @NonNull
    private String categoryName;

    @ColumnInfo(name = "parent_category_id")
    private int parentCategoryId;

    public AccCategory(String categoryName, int parentCategoryId) {
        setCategoryName(categoryName);
        setParentCategoryId(parentCategoryId);
    }

    @Ignore
    public AccCategory(String categoryName) {
        setCategoryName(categoryName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        if (categoryName.length() < 3) {
            return;
        }

        this.categoryName = categoryName;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        // We have already set parent category for this one
        if (this.parentCategoryId != 0) {
            return;
        }

        this.parentCategoryId = parentCategoryId;
    }
}
