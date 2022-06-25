package com.example.app_mobile.Service;

import static com.example.app_mobile.Service.MyApplicaition.CHANNEL_ID;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.os.StrictMode;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.app_mobile.Activity.PlayNhacActivity;
import com.example.app_mobile.Model.Baihat;
import com.example.app_mobile.R;

import java.io.IOException;
import java.net.URL;

public class MyService extends Service {

    public static int pause = 1;
    public static int play = 2;
    public static int exit = 3;
    public static int next = 4;
    public static int pre = 5;

    Baihat baihat;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.hasExtra("cakhuc")) {
            baihat = (Baihat) intent.getSerializableExtra("cakhuc");
            sendNotification(baihat);
        }

        int action = intent.getIntExtra("action",0);
        handleActionMusic(action);

        return START_NOT_STICKY;
    }

    private void handleActionMusic(int action) {
        switch (action) {
            case 1:
                sendNotification(baihat);
                sendActionActivity(pause);
                break;
            case 2:
                sendNotification(baihat);
                sendActionActivity(play);
                break;
            case 3:
                stopSelf();
                sendActionActivity(exit);
                break;
            case 4:
                sendActionActivity(next);
                break;
            case 5:
                sendActionActivity(pre);
                break;
        }
    }

    private void sendNotification(Baihat baihat) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        Intent intent = new Intent(this, PlayNhacActivity.class);
        intent.putExtra("cacbaihat",PlayNhacActivity.mangbaihat);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        @SuppressLint("RemoteViewLayout") RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification);
        remoteViews.setTextViewText(R.id.tensong,baihat.getTenbaihat());
        remoteViews.setTextViewText(R.id.casisong,baihat.getCasi());
        remoteViews.setImageViewResource(R.id.pause,R.drawable.pause);

        try {
            URL url = new URL(baihat.getHinhbaihat());
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            remoteViews.setImageViewBitmap(R.id.img_song,bitmap);
        } catch(IOException e) {
            System.out.println(e);
        }

        if (PlayNhacActivity.mediaPlayer.isPlaying()) {
            remoteViews.setOnClickPendingIntent(R.id.pause, getPenddingIntent(this, pause));
            remoteViews.setImageViewResource(R.id.pause,R.drawable.pause);
        } else {
            remoteViews.setOnClickPendingIntent(R.id.pause, getPenddingIntent(this, play));
            remoteViews.setImageViewResource(R.id.pause,R.drawable.play);
        }

        remoteViews.setOnClickPendingIntent(R.id.exit, getPenddingIntent(this, exit));
        remoteViews.setOnClickPendingIntent(R.id.next, getPenddingIntent(this, next));
        remoteViews.setOnClickPendingIntent(R.id.pre, getPenddingIntent(this, pre));

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .setCustomContentView(remoteViews)
                .setSound(null)
                .build();
        startForeground(1,notification);
    }

    private PendingIntent getPenddingIntent(Context context, int action) {
        Intent intent = new Intent(this, MyReceiver.class);
        intent.putExtra("action", action);

        return PendingIntent.getBroadcast(context.getApplicationContext(), action, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void sendActionActivity (int action) {
        Intent intent = new Intent("send_data_activity");
        Bundle bundle = new Bundle();
        bundle.putInt("action", action);
        intent.putExtras(bundle);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
