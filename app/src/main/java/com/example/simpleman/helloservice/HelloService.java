package com.example.simpleman.helloservice;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by SimpleMan on 2/6/2017.
 */

public class HelloService extends Service {
    private CountDownTimer countDownTimer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        countDownTimer = new CountDownTimer(100000, 1000) {

            public void onTick(long millisUntilFinished) {
                Toast.makeText(getApplicationContext(),"Hello Service! "+ (100 - millisUntilFinished/1000), Toast.LENGTH_SHORT).show();
            }

            public void onFinish() {
                Toast.makeText(getApplicationContext(),"done!",Toast.LENGTH_SHORT).show();
            }
        }.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
         countDownTimer.cancel();
    }
}
