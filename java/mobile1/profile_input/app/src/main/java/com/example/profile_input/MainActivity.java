package com.example.profile_input;

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
    
    private EditText editTextName;
    private Button buttonSubmit;

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
        
        // پیدا کردن المان‌های UI
        editTextName = findViewById(R.id.editTextName);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        
        // تنظیم رویداد کلیک برای دکمه ثبت
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // بررسی خالی نبودن فیلد نام
                if (editTextName.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "لطفاً نام خود را وارد کنید", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                // انتقال به صفحه دوم و ارسال اطلاعات
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("NAME", editTextName.getText().toString());
                startActivity(intent);
            }
        });
    }
}