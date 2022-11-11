package com.phanduc.androidnc2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class MyBroadcastReceiver3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "bớt ngủ đee", Toast.LENGTH_SHORT).show();
        Log.d("baothuc","ngủ nằm ngủ nốn");

        String CHANNEL_ID = "channel_id";
        CharSequence name = "chanel_name";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        Notification builder=new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("title")
                .setContentText("Báo Thức nè")
                .setChannelId(CHANNEL_ID)
                .build();
        NotificationManager manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mchanel = new NotificationChannel(CHANNEL_ID,name,importance);
            manager.createNotificationChannel(mchanel);
        }
        manager.notify(0,builder);
    }
}
