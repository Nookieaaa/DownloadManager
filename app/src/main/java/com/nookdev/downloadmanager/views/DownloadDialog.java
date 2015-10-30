package com.nookdev.downloadmanager.views;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.nookdev.downloadmanager.App;
import com.nookdev.downloadmanager.R;
import com.nookdev.downloadmanager.service.TaskReceiver;

public class DownloadDialog extends DialogFragment implements View.OnClickListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setView(R.layout.dialog_download_add);
        builder.setTitle(R.string.dialog_title);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(TaskReceiver.BROADCAST_ACTION_ADD);
                intent.putExtra("url","");
                intent.putExtra("filename","");
                App.getAppContext().sendBroadcast(intent);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        return builder.create();
    }

    @Override
    public void onClick(View v) {

    }
}
