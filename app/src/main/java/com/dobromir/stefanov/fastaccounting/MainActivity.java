package com.dobromir.stefanov.fastaccounting;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int ADD_NEW_CATEGORY_INTENT_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemAddNewCategory: openAddNewCategoryIntent(); break;
            case R.id.menuItemAddNewBilling:
                Toast.makeText(this, "Add New Billing selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItemScanQr:
                Toast.makeText(this, "Scan QR selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NEW_CATEGORY_INTENT_ID) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, R.string.toast_new_category, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openAddNewCategoryIntent() {
        Intent addNewCategoryIntent = new Intent(this, AddNewCategory.class);
        startActivityForResult(addNewCategoryIntent, ADD_NEW_CATEGORY_INTENT_ID);
    }
}
