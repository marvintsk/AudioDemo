package com.example.audiodemo;

import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

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
        TextView txtViewSong = view.findViewById(R.id.textViewSongItem);
        txtViewSong.setText(AdapterSongList.get(i).getSongName());
        txtViewSong.setGravity(Gravity.CENTER_VERTICAL);
        Drawable img = ContextCompat.getDrawable(viewGroup.getContext(),AdapterSongList.get(i).getSongPic());
        img.setBounds(0,0,80,80);
        txtViewSong.setCompoundDrawables(img,null,null,null);
        txtViewSong.setCompoundDrawablePadding(8);
        return view;
    }
}
