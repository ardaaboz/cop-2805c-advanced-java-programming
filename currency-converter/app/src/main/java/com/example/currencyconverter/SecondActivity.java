package com.example.currencyconverter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.inputmethod.EditorInfo;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get currency data
        Intent intent = getIntent();
        String currency = intent.getStringExtra("CURRENCY");

        // Set placeholder text to active currency
        ((TextView) findViewById(R.id.targetValueText)).setText(currency + ":");

        // Action listener to convert usdValue and put the converted value to targetValue
        EditText usdValue = (EditText) findViewById(R.id.usdValue);
        usdValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE ) {
                    EditText targetValue = (EditText) findViewById(R.id.targetValue);
                    targetValue.setText(String.valueOf(calculateValue(currency, Double.parseDouble(usdValue.getText().toString()), false)));
                }
                return false;
            }
        });

        // Action listener to convert targetValue and put the converted value to usdValue
        EditText targetValue = (EditText) findViewById(R.id.targetValue);
        targetValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE ) {
                    EditText usdValue = (EditText) findViewById(R.id.usdValue);
                    usdValue.setText(String.valueOf(calculateValue(currency, Double.parseDouble(targetValue.getText().toString()), true)));
                }
                return false;
            }
        });
    }

    // BAD PRACTICE!!! Copy pasting instead of making a method.
    // But action listeners makes me nervous so it should be fine for now :)

    // Method to convert currency
    public double calculateValue(String currency, double value, boolean reverse) {
        if (currency.equals("EUR") && !reverse) {
            return 0.85 * value;
        } else if (currency.equals("EUR")) {
            return value / 0.85;
        } else if (currency.equals("CAD") && !reverse) {
            return 1.26 * value;
        } else if (currency.equals("CAD")) {
            return value / 1.26;
        } else if (currency.equals("YEN") && !reverse) {
            return 109.94 * value;
        } else if (currency.equals("YEN")) {
            return value / 109.94;
        } else {
            Log.v("NULL", "Currency null");
            return 0;
        }
    }

    // Close view and go back to main activity
    public void returnButton(View view) {
        finish();
    }
}