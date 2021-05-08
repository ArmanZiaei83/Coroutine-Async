package com.example.birdcare;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.birdcare.notificationChannel.*;

public class IntentServices extends IntentService {

    public IntentServices() {
        super("IntentServices");
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        for (int i = 0; i < 10 ; i++) {
            SystemClock.sleep(1000);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Notification notification = new NotificationCompat.Builder(this , CHANNEL_ID)
                .setSmallIcon(R.drawable.parrot)
                .setContentText("Welcome To BirdCare")
                .setContentTitle("BirdCare")
                .build();

        startForeground(1 , notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
