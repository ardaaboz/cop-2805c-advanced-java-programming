package com.example.currencyconverter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void nextClick(View view) {
        // Find radio group by id
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        // Find checked radio button
        RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

        // Get the text inside selected radio button
        String radioButtonValue = radioButton.getText().toString();

        // Set intent for next activity
        Intent intent = new Intent(this, SecondActivity.class);

        // Sending radioButtonValue variable to next activity using putExtra
        intent.putExtra("CURRENCY", radioButtonValue);

        // Start next activity
        startActivity(intent);
    }
}