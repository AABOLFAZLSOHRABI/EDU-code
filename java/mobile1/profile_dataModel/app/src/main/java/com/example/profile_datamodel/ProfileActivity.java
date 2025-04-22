package com.example.profile_datamodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView nameTextView;
    private Button backButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        
        // یافتن عناصر رابط کاربری
        nameTextView = findViewById(R.id.nameTextView);
        backButton = findViewById(R.id.backButton);
        
        // دریافت اطلاعات از intent
        String userName = getIntent().getStringExtra("USER_NAME");
        
        // نمایش اطلاعات در UI
        nameTextView.setText("نام: " + userName);
        
        // رویداد کلیک برای دکمه بازگشت
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // بستن فعالیت فعلی و بازگشت به فعالیت قبلی
            }
        });
    }
} 