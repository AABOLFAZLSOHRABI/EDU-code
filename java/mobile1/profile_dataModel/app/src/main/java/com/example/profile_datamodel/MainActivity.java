package com.example.profile_datamodel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button submitButton;
    private Profile userProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        // تنظیم حاشیه‌های سیستمی
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        // مقداردهی اولیه مدل داده
        userProfile = new Profile();
        
        // یافتن عناصر رابط کاربری
        nameEditText = findViewById(R.id.nameEditText);
        submitButton = findViewById(R.id.submitButton);
        
        // رویداد کلیک برای دکمه ثبت
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = nameEditText.getText().toString().trim();
                
                if (userName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "لطفاً نام خود را وارد کنید", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                // ذخیره‌سازی نام در مدل داده
                userProfile.setName(userName);
                
                // ایجاد intent و انتقال به صفحه پروفایل
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("USER_NAME", userProfile.getName());
                startActivity(intent);
            }
        });
    }
}