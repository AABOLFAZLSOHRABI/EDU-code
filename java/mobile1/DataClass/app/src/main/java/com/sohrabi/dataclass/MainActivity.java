package com.sohrabi.dataclass;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText name, family, age, number, codeID, city;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        family = findViewById(R.id.family);
        age = findViewById(R.id.age);
        number = findViewById(R.id.number);
        codeID = findViewById(R.id.codeID);
        city = findViewById(R.id.city);
        buttonLogin = findViewById(R.id.btn_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", userDataClass.getName());
                intent.putExtra("family", userDataClass.getFamily());
                intent.putExtra("age", userDataClass.getAge());
                intent.putExtra("number", userDataClass.getNumber());
                intent.putExtra("codeID", userDataClass.getCodeID());
                intent.putExtra("city", userDataClass.getCity());
                startActivity(intent);
                finish();
            }
        });
    }
}