package com.nookdev.downloadmanager.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nookdev.downloadmanager.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DownloadsListFragment extends Fragment {

    public static final String TAG_NAME = "DOWNLOADS_LIST";

    @Bind(R.id.downloads_list)
    RecyclerView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.downloads_list_fragment,container,false);
        ButterKnife.bind(this,v);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        list.setLayoutManager(llm);
        list.setAdapter(new DownloadsListAdapter());
        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
