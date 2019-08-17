package com.dobromir.stefanov.fastaccounting.Activities;

import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.dobromir.stefanov.fastaccounting.R;

public class AddNewCategory extends AppCompatActivity {
    // View objects
    Spinner typeSpinner;
    CheckBox checkBoxIsSubcategory;
    LinearLayout layoutMainCategory, layoutIsRepeating;
    AutoCompleteTextView editTxtCategoryName;


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
        editTxtCategoryName = (AutoCompleteTextView) findViewById(R.id.editTxtCategoryName);

        PopulateTypeSpinner();
        SetupAutofillCategoryName();
    }

    private void PopulateTypeSpinner() {
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this,
                R.array.types, android.R.layout.simple_spinner_item);

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);
    }

    private void SetupAutofillCategoryName() {
        ArrayAdapter<String> autofillAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.possible_categories));

        editTxtCategoryName.setThreshold(2);
        editTxtCategoryName.setAdapter(autofillAdapter);
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
