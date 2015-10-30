package com.nookdev.downloadmanager.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.nookdev.downloadmanager.views.MainScreen;


public class TaskReceiver extends BroadcastReceiver {

    public static final String BROADCAST_ACTION_ADD = "com.nookdev.downloadmanager.add";
    public static final String BROADCAST_ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case BROADCAST_ACTION_ADD:{
                String url = intent.getStringExtra("url");
                String filename = intent.getStringExtra("filename");
                break;
            }
            case BROADCAST_ACTION_BOOT:{
                Intent intent1 = new Intent(context, MainScreen.class);
                context.startActivity(intent1);
                context.startService(new Intent(context,DownloaderService.class));
                break;
            }
        }

    }
}
