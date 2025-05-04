package com.sohrabi.dataclass;

import static com.sohrabi.dataclass.R.layout.activity_main2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView TextViewName,TextViewFamily,TextViewAge,TextViewNumber,TextViewCodeID,TextViewCity;
    Button btn_BACK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(activity_main2);
        TextViewName = findViewById(R.id.TextViewName);
        TextViewAge = findViewById(R.id.TextViewAge);
        TextViewFamily = findViewById(R.id.TextViewFamily);
        TextViewNumber = findViewById(R.id.TextViewNumber);
        TextViewCodeID = findViewById(R.id.TextViewCodeID);
        TextViewCity = findViewById(R.id.TextViewCity);
        btn_BACK = findViewById(R.id.btn_BACK);

        Intent intent = getIntent();
        TextViewName.setText(intent.getStringExtra("name"));
        TextViewFamily.setText(intent.getStringExtra("family"));
        TextViewAge.setText(intent.getStringExtra("age"));
        TextViewNumber.setText(intent.getStringExtra("number"));
        TextViewCodeID.setText(intent.getStringExtra("codeID"));
        TextViewCity.setText(intent.getStringExtra("city"));

    }
}