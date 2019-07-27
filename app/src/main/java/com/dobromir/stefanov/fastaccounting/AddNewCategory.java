package com.dobromir.stefanov.fastaccounting;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class AddNewCategory extends AppCompatActivity {
    // View objects
    Spinner typeSpinner;
    CheckBox checkBoxIsSubcategory;
    LinearLayout layoutMainCategory, layoutIsRepeating;


    // Data object
    boolean isSubcategory = false;
    boolean isRepeating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_category);

        // Menu options
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        checkBoxIsSubcategory = (CheckBox) findViewById(R.id.checkBoxIsSubcategory);
        typeSpinner = (Spinner) findViewById(R.id.spinnerType);
        layoutMainCategory = (LinearLayout) findViewById(R.id.layoutMainCategory);
        layoutIsRepeating = (LinearLayout) findViewById(R.id.layoutIsRepeating);

        PopulateTypeSpinner();
    }

    private void PopulateTypeSpinner() {
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this,
                R.array.types, android.R.layout.simple_spinner_item);

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);
    }

    public void SubmitCategory(View view) {
        setResult(RESULT_OK);
        this.finish();
    }

    public void IsSubcategoryChanged(View view) {
        boolean isChecked = ((CheckBox) view).isChecked();

        if (isChecked) {
            isSubcategory = true;
            layoutMainCategory.setVisibility(View.VISIBLE);
        } else {
            isSubcategory = false;
            layoutMainCategory.setVisibility(View.GONE);
        }
    }

    public void IsRepeatingChanged(View view) {
        boolean isChecked = ((CheckBox) view).isChecked();

        if (isChecked) {
            isRepeating = true;
            layoutIsRepeating.setVisibility(View.VISIBLE);
        } else {
            isRepeating = false;
            layoutIsRepeating.setVisibility(View.GONE);
        }
    }
}
