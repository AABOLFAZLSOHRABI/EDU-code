package com.example.operation_selection;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class CalculationActivity extends AppCompatActivity {
    private TextView tvFirstNumber, tvSecondNumber, tvResult, tvOperation;
    private ProgressBar progressBar;
    private String operation;
    private int firstNumber, secondNumber;
    private int minNumber, maxNumber;
    private Handler handler = new Handler();
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        initializeViews();
        setupOperation();
        setupBackButton();
        startCalculation();
    }

    private void initializeViews() {
        tvFirstNumber = findViewById(R.id.tvFirstNumber);
        tvSecondNumber = findViewById(R.id.tvSecondNumber);
        tvResult = findViewById(R.id.tvResult);
        tvOperation = findViewById(R.id.tvOperation);
        progressBar = findViewById(R.id.progressBar);
    }

    private void setupOperation() {
        operation = getIntent().getStringExtra("operation");
        minNumber = getIntent().getIntExtra("min_number", 1);
        maxNumber = getIntent().getIntExtra("max_number", 100);
        
        String operationText = "";
        switch (operation) {
            case "+": operationText = "عملیات جمع"; break;
            case "-": operationText = "عملیات تفریق"; break;
            case "*": operationText = "عملیات ضرب"; break;
            case "/": operationText = "عملیات تقسیم"; break;
        }
        tvOperation.setText(operationText);
    }

    private void setupBackButton() {
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
    }

    private void startCalculation() {
        updateProgress(0);
        handler.postDelayed(this::showFirstNumber, 1000);
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt((maxNumber - minNumber) + 1) + minNumber;
    }

    private void showFirstNumber() {
        firstNumber = getRandomNumber();
        tvFirstNumber.setText("عدد اول: " + firstNumber);
        updateProgress(33);
        handler.postDelayed(this::showSecondNumber, 1000);
    }

    private void showSecondNumber() {
        secondNumber = getRandomNumber();
        tvSecondNumber.setText("عدد دوم: " + secondNumber);
        updateProgress(66);
        handler.postDelayed(this::calculateResult, 1000);
    }

    private void calculateResult() {
        double result = 0;
        String resultText;
        
        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                resultText = String.format("%d + %d = %.0f", firstNumber, secondNumber, result);
                break;
            case "-":
                result = firstNumber - secondNumber;
                resultText = String.format("%d - %d = %.0f", firstNumber, secondNumber, result);
                break;
            case "*":
                result = firstNumber * secondNumber;
                resultText = String.format("%d × %d = %.0f", firstNumber, secondNumber, result);
                break;
            case "/":
                if (secondNumber != 0) {
                    result = (double) firstNumber / secondNumber;
                    resultText = String.format("%d ÷ %d = %.2f", firstNumber, secondNumber, result);
                } else {
                    resultText = "خطا: تقسیم بر صفر";
                }
                break;
            default:
                resultText = "خطا در عملیات";
        }
        
        tvResult.setText(resultText);
        updateProgress(100);
    }

    private void updateProgress(int newProgress) {
        progress = newProgress;
        progressBar.setProgress(progress);
    }
} 