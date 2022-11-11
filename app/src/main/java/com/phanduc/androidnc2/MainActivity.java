package com.phanduc.androidnc2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnBai2, btnBai3;
    EditText txtBai2;

    PendingIntent pi;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBai2 = findViewById(R.id.txtBai2);
        btnBai2 = findViewById(R.id.btnBai2);
        btnBai3 = findViewById(R.id.btnBai3);

        Intent i = new Intent(MainActivity.this, MyBroadcastReceiver3.class);
        pi = PendingIntent.getBroadcast(MainActivity.this,0,i,0);

        

        MyBroadcastReceiver receiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(receiver,intentFilter);

        MyBroadcastReceiver2 receiver1 = new MyBroadcastReceiver2();
        IntentFilter intentFilter1 = new IntentFilter("com.example.broadcast.MY_NOTIFICATION");
        this.registerReceiver(receiver1,intentFilter1);

        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.broadcast.MY_NOTIFICATION");
                String s = txtBai2.getText().toString();
                intent.putExtra("data", s);
                sendBroadcast(intent);
            }
        });

        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND)+10);
                Toast.makeText(MainActivity.this,"lap lich luc"+ calendar.get(Calendar.SECOND), Toast.LENGTH_SHORT).show();

                am =(AlarmManager)MainActivity.this.getSystemService(Context.ALARM_SERVICE);
                am.setRepeating(AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pi);
            }
        });




    }
}