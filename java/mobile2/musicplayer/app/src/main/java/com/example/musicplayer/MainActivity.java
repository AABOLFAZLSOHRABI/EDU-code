package com.example.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Start the playlist activity
        Intent intent = new Intent(this, PlayListActivity.class);
        startActivity(intent);
        finish(); // Close MainActivity since we don't need it anymore
    }
}