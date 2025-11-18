package com.example.internet;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkboxRealTime;
    private Button buttonCheckStatus;
    private TextView textViewStatus;
    private NetworkChangeReceiver networkChangeReceiver;

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

        initializeViews();
        setupClickListeners();
        updateInitialStatus();
    }

    private void initializeViews() {
        checkboxRealTime = findViewById(R.id.checkboxRealTime);
        buttonCheckStatus = findViewById(R.id.buttonCheckStatus);
        textViewStatus = findViewById(R.id.textViewStatus);
    }

    private void setupClickListeners() {
        checkboxRealTime.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                registerNetworkReceiver();
                textViewStatus.setText("Real-time monitoring enabled. Internet status will be displayed here.");
            } else {
                unregisterNetworkReceiver();
                textViewStatus.setText("Real-time monitoring disabled. Click button to check status manually.");
            }
        });

        buttonCheckStatus.setOnClickListener(v -> {
            if (checkboxRealTime.isChecked()) {
                // Show dialog when checkbox is enabled
                showInternetStatusDialog();
            } else {
                // Update TextView when checkbox is disabled
                updateTextViewStatus();
            }
        });
    }

    private void updateInitialStatus() {
        String status = InternetStatusUtils.getInternetStatusString(this);
        textViewStatus.setText(status);
    }

    private void updateTextViewStatus() {
        String status = InternetStatusUtils.getInternetStatusString(this);
        textViewStatus.setText(status);
    }

    private void showInternetStatusDialog() {
        String status = InternetStatusUtils.getInternetStatusString(this);
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Internet Status");
        builder.setMessage(status);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.setCancelable(true);
        
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void registerNetworkReceiver() {
        networkChangeReceiver = new NetworkChangeReceiver(textViewStatus);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(networkChangeReceiver, filter);
    }

    private void unregisterNetworkReceiver() {
        if (networkChangeReceiver != null) {
            unregisterReceiver(networkChangeReceiver);
            networkChangeReceiver = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterNetworkReceiver();
    }
}