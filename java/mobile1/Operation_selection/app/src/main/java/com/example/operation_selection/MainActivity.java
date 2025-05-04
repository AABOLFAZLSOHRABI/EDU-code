package com.example.operation_selection;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etMinNumber, etMaxNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupButtons();
    }

    private void initializeViews() {
        etMinNumber = findViewById(R.id.etMinNumber);
        etMaxNumber = findViewById(R.id.etMaxNumber);
    }

    private void setupButtons() {
        Button btnAddition = findViewById(R.id.btnAddition);
        Button btnSubtraction = findViewById(R.id.btnSubtraction);
        Button btnMultiplication = findViewById(R.id.btnMultiplication);
        Button btnDivision = findViewById(R.id.btnDivision);

        btnAddition.setOnClickListener(v -> startCalculation("+"));
        btnSubtraction.setOnClickListener(v -> startCalculation("-"));
        btnMultiplication.setOnClickListener(v -> startCalculation("*"));
        btnDivision.setOnClickListener(v -> startCalculation("/"));
    }

    private void startCalculation(String operation) {
        String minStr = etMinNumber.getText().toString();
        String maxStr = etMaxNumber.getText().toString();

        if (minStr.isEmpty() || maxStr.isEmpty()) {
            Toast.makeText(this, "لطفاً بازه اعداد را وارد کنید", Toast.LENGTH_SHORT).show();
            return;
        }

        int min = Integer.parseInt(minStr);
        int max = Integer.parseInt(maxStr);

        if (min >= max) {
            Toast.makeText(this, "حداقل عدد باید کوچکتر از حداکثر عدد باشد", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, CalculationActivity.class);
        intent.putExtra("operation", operation);
        intent.putExtra("min_number", min);
        intent.putExtra("max_number", max);
        startActivity(intent);
    }
} 