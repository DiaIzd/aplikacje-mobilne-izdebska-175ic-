package com.example.lab8_1;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.text.format.DateFormat;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class Timer extends IntentService {
    public static final String TEXT_INPUT = "inText";
    public static final String TEXT_OUTPUT = "outText";

    public Timer() {
        super("Timer");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        String inputText = intent.getStringExtra(TEXT_INPUT);
        SystemClock.sleep(3000); // 3 seconds
        String outputText = inputText + " "
                + DateFormat.format("dd/MM/yy h:mm:ss aa",
                System.currentTimeMillis());

        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(
                DelayedMessageService.ResponseReceiver.LOCAL_ACTION);
        broadcastIntent.putExtra(TEXT_OUTPUT, outputText);
        LocalBroadcastManager localBroadcastManager
                = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.sendBroadcast(broadcastIntent);

    }


}