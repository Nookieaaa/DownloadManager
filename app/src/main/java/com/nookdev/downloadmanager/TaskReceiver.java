package com.nookdev.downloadmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.nookdev.downloadmanager.service.DownloaderService;
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
                Intent intent1 = new Intent(context, DownloaderService.class);
                intent1.putExtra("download","1");
                context.startService(intent1);
                break;
            }
            case BROADCAST_ACTION_BOOT:{
                Intent intent1 = new Intent(context, MainScreen.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
                context.startService(new Intent(context,DownloaderService.class));
                break;
            }
        }

    }
}
