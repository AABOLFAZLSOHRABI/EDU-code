package com.example.internet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class NetworkChangeReceiver extends BroadcastReceiver {

    private TextView statusTextView;

    public NetworkChangeReceiver(TextView statusTextView) {
        this.statusTextView = statusTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (statusTextView != null) {
            String status = InternetStatusUtils.getInternetStatusString(context);
            statusTextView.setText(status);
        }
    }
}