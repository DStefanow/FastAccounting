package com.dobromir.stefanov.fastaccounting.Objects;

public class AccCategory {
    private int id;
    private String categoryName;
    private int parent_category_id;
    private int repeat_on;

    public AccCategory(int id, String categoryName, int parent_category_id, int repeat_on) {
        this.id = id;
        this.categoryName = categoryName;
        this.parent_category_id = parent_category_id;
        this.repeat_on = repeat_on;
    }


    public AccCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getParent_category_id() {
        return parent_category_id;
    }

    public int getRepeat_on() {
        return repeat_on;
    }
}
