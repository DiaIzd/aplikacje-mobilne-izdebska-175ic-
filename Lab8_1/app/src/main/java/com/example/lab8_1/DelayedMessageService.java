package com.example.lab8_1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class DelayedMessageService extends Activity {
        private EditText editText;
        private ResponseReceiver receiver;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_message);

            editText = (EditText) findViewById(R.id.timeField);

            Button sendButton = (Button) findViewById(R.id.button4);

            sendButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    String inputText = editText.getText().toString();
                    Intent inputIntent = new Intent(DelayedMessageService.this,
                            Timer.class);
                    inputIntent.putExtra(Timer.TEXT_INPUT, inputText);
                    startService(inputIntent);
                }
            });
        }

public class ResponseReceiver extends BroadcastReceiver {

    public static final String LOCAL_ACTION =
            "com.hfad.lab8.intent_service.ALL_DONE";

    @Override
    public void onReceive(Context context, Intent intent) {
        TextView outputTextView = (TextView) findViewById(R.id.textView);
        String outputText = intent.getStringExtra(Timer.TEXT_OUTPUT);
        outputTextView.setText(outputText);
    }
}

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter broadcastFilter = new IntentFilter(
                ResponseReceiver.LOCAL_ACTION);
        receiver = new ResponseReceiver();
        LocalBroadcastManager localBroadcastManager =
                LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(receiver,
                broadcastFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager localBroadcastManager =
                LocalBroadcastManager.getInstance(this);
        localBroadcastManager.unregisterReceiver(receiver);
    }
}
