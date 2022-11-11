package com.phanduc.androidnc2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("data");
        if(s.length()==0){
            Toast.makeText(context, "Receiver đã tạo", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Receiver tự tạo: " + s, Toast.LENGTH_SHORT).show();
        }
    }
}
