package com.example.audiodemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class SongAdapter extends BaseAdapter {
    //setup the data
    List<Song> AdapterSongList;

//setup the getCount based on data
    //setup constructor to set the data
    //customize getView() method
public SongAdapter(List<Song> adapterSongList) {
    AdapterSongList = adapterSongList;
}

    @Override
    public int getCount() {
        return AdapterSongList.size();
    }

    @Override
    public Object getItem(int i) {
        return AdapterSongList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            //inflate external Layout
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layoutitem,viewGroup,false);
        }
        return view;
    }
}
