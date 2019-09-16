package com.dobromir.stefanov.fastaccounting.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.dobromir.stefanov.fastaccounting.R;

public class AddNewCategory extends AppCompatActivity {
    // View objects
    Spinner typeSpinner;
    CheckBox checkBoxIsSubcategory;
    LinearLayout layoutMainCategory;
    AutoCompleteTextView editTxtCategoryName;

    // Flag for subcategory menu
    boolean isSubcategory = false;

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
        editTxtCategoryName = (AutoCompleteTextView) findViewById(R.id.editTxtCategoryName);

        SetupAutofillCategoryName();
    }

    private void SetupAutofillCategoryName() {
        ArrayAdapter<String> autofillAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.possible_categories));

        editTxtCategoryName.setThreshold(2);
        editTxtCategoryName.setAdapter(autofillAdapter);
    }

    public void SubmitCategory(View view) {
        String categoryName = editTxtCategoryName.getText().toString();
        int categoryParentId = 0;

        if (categoryName.length() < 3) {
            Toast.makeText(this, R.string.toast_category_name_check, Toast.LENGTH_SHORT).show();
            return;
        }

        if (checkBoxIsSubcategory.isChecked()) {
            // TODO .. Implement logic here
        }

        Intent intent = new Intent();
        intent.putExtra("categoryName", categoryName);
        intent.putExtra("categoryParentId", categoryParentId);

        setResult(RESULT_OK, intent);
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
}
