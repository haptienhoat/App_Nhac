package com.example.app_mobile.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int action = intent.getIntExtra("action", 0);

        Intent intentService = new Intent(context, MyService.class);
        intentService.putExtra("action",action);
        context.startService(intentService);
    }
}
