package com.dobromir.stefanov.fastaccounting.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories",
    indices = {@Index(value = {"category_name"}, unique = true)})
public class AccCategory {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "category_name")
    private String categoryName;

    @ColumnInfo(name = "parent_category_id")
    private int parentCategoryId;

    @ColumnInfo(name = "repeat_on")
    private int repeatOn;

    public AccCategory(int id, String categoryName, int parentCategoryId, int repeatOn) {
        setId(id);
        setCategoryName(categoryName);
        setParentCategoryId(parentCategoryId);
        setRepeatOn(repeatOn);
    }

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
        return categoryName;
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

    public int getRepeatOn() {
        return repeatOn;
    }

    public void setRepeatOn(int repeatOn) {
        if (repeatOn < 1 ||repeatOn > 28) {
            return;
        }

        this.repeatOn  = repeatOn;
    }
}
