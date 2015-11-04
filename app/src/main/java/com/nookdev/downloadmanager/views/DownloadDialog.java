package com.nookdev.downloadmanager.views;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.nookdev.downloadmanager.App;
import com.nookdev.downloadmanager.R;
import com.nookdev.downloadmanager.TaskReceiver;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DownloadDialog extends DialogFragment {

    public static final String TAG_NAME = "Download_dialog";

    private String source;
    private String filename;

    @Bind(R.id.dialog_download_add_filename)
    EditText etFilename;

    @Bind(R.id.dialog_download_add_url)
    EditText etSource;

    @Bind(R.id.dialog_download_add_category)
    Spinner spCategory;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = View.inflate(getContext(),R.layout.dialog_download_add,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setView(v);
        builder.setTitle(R.string.dialog_title);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(TaskReceiver.BROADCAST_ACTION_ADD);
                intent.putExtra("url", source);
                intent.putExtra("filename", filename);
                App.getAppContext().sendBroadcast(intent);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        ButterKnife.bind(this,v);

        setValues();

        return builder.create();
    }

    private void setValues() {
        if (source!=null)
            etSource.setText(source);
        if(filename!=null)
            etFilename.setText(filename);
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        ButterKnife.unbind(this);

    }


}
