package com.example.profile_input;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewName;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // پیدا کردن المان‌های UI
        textViewName = findViewById(R.id.textViewName);
        buttonBack = findViewById(R.id.buttonBack);

        // دریافت اطلاعات از Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("NAME", "");
            
            // نمایش اطلاعات در TextView
            textViewName.setText(name);
        }

        // تنظیم رویداد کلیک برای دکمه بازگشت
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // بازگشت به صفحه قبل
                finish();
            }
        });
    }
} 