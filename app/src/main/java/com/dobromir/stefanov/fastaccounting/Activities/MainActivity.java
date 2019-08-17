package com.dobromir.stefanov.fastaccounting.Activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dobromir.stefanov.fastaccounting.Interfaces.ItemClicked;
import com.dobromir.stefanov.fastaccounting.R;

public class MainActivity extends AppCompatActivity implements ItemClicked {
    private static final int ADD_NEW_CATEGORY_INTENT_ID = 2,
            ADD_NEW_PAYMENT_ID = 3;

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
            case R.id.menuItemAddNewCategory: startNewIntentForResult(ADD_NEW_CATEGORY_INTENT_ID); break;
            case R.id.menuItemAddNewBilling: startNewIntentForResult(ADD_NEW_PAYMENT_ID); break;
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
        } else if (requestCode == ADD_NEW_PAYMENT_ID) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, R.string.toast_new_payment, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void startNewIntentForResult(int intentId) {
        Intent newIntent = null;

        if (intentId == ADD_NEW_CATEGORY_INTENT_ID) {
            newIntent = new Intent(this, AddNewCategory.class);
        } else if (intentId == ADD_NEW_PAYMENT_ID) {
            newIntent = new Intent(this, AddNewPayment.class);
        }

        startActivityForResult(newIntent, intentId);
    }

    @Override
    public void onItemClicked(int i) {
        // TODO .. Not for now
    }
}
