package com.example.birdcare;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class notificationChannel extends Application {

    public static final String CHANNEL_ID = "ChannelId";
    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }
    public void createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel notif = new NotificationChannel(
                    CHANNEL_ID,
                    "ChannelName",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notif);
        }
    }


}
