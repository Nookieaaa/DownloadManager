package com.nookdev.downloadmanager.views;


import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nookdev.downloadmanager.R;
import com.nookdev.downloadmanager.database.DatabaseController;
import com.nookdev.downloadmanager.database.models.Task;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DownloadsListAdapter extends RecyclerView.Adapter<DownloadsListAdapter.DownloadsListViewHolder> {

    List<Task> data;
    DatabaseController databaseController;

    public DownloadsListAdapter() {
        data = new ArrayList<>();
        databaseController = new DatabaseController();
        //TODO delete this
        updateData();
    }

    public void updateData() {
        Cursor c = databaseController.query();
        while(c.moveToNext()){
            data.add(new Task(c));
        }
    }


    @Override
    public DownloadsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.downloads_list_item, parent, false);
        return new DownloadsListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DownloadsListViewHolder holder, int position) {
        Task task = data.get(position);
        //TODO implement filling
        holder.fileName.setText(task.getFilename());
        holder.progress.setProgress(0);
        holder.status.setText("active");
        holder.quickAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //App.getAppContext().startService(new Intent(App.getAppContext(), DownloaderService.class));
                //DatabaseController dbC = new DatabaseController();
                //dbC.add(new Task("source","out","filename","mpg",10,2,0));

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class DownloadsListViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.download_list_item_content_filename)
        TextView fileName;
        @Bind(R.id.download_list_item_content_quickaction)
        ImageButton quickAction;
        @Bind(R.id.download_list_item_content_status)
        TextView status;
        @Bind(R.id.download_list_item_content_progress)
        ProgressBar progress;

        public DownloadsListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
