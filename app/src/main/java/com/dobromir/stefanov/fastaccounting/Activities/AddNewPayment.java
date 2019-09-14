package com.dobromir.stefanov.fastaccounting.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.dobromir.stefanov.fastaccounting.R;

public class AddNewPayment extends AppCompatActivity {
    // View objects
    Spinner typeSpinner, categorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_payment);

        // Menu options
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        typeSpinner = findViewById(R.id.spinnerType);
        categorySpinner = findViewById(R.id.spinnerCategory);

        PopulateTypeSpinner();
    }

    private void PopulateTypeSpinner() {
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this,
                R.array.types, android.R.layout.simple_spinner_item);

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);
    }

    public void SubmitPayment(View view) {
        setResult(RESULT_OK);
        this.finish();
    }
}
