package com.nookdev.downloadmanager.views;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nookdev.downloadmanager.R;
import com.nookdev.downloadmanager.views.model.DownloadItemModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DownloadsListAdapter extends RecyclerView.Adapter<DownloadsListAdapter.DownloadsListViewHolder> {

    List<DownloadItemModel> data;

    public DownloadsListAdapter() {
        //TODO delete this
        fillDummyData();
    }

    public void fillDummyData() {
        data = new ArrayList<DownloadItemModel>();
        data.add(new DownloadItemModel(5, "Video"));
        data.add(new DownloadItemModel(10, "Image"));
        data.add(new DownloadItemModel(15, "Video3"));
        data.add(new DownloadItemModel(20, "Audio"));
        data.add(new DownloadItemModel(10, "Image"));
        data.add(new DownloadItemModel(30, "Audio"));
        data.add(new DownloadItemModel(50, "Document"));
        data.add(new DownloadItemModel(77, "APK"));
        data.add(new DownloadItemModel(96, "Audio"));
        data.add(new DownloadItemModel(5, "Video"));
        data.add(new DownloadItemModel(10, "Image"));
        data.add(new DownloadItemModel(15, "Video3"));
        data.add(new DownloadItemModel(20, "Audio"));
        data.add(new DownloadItemModel(10, "Image"));
        data.add(new DownloadItemModel(30, "Audio"));
        data.add(new DownloadItemModel(50, "Document"));
        data.add(new DownloadItemModel(77, "APK"));
        data.add(new DownloadItemModel(96, "Audio"));
    }


    @Override
    public DownloadsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.downloads_list_item, parent, false);
        return new DownloadsListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DownloadsListViewHolder holder, int position) {
        DownloadItemModel item = data.get(position);
        //TODO implement filling
        holder.fileName.setText(item.getFilename());
        holder.progress.setProgress(item.getProgress());
        holder.status.setText(item.getState());
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
