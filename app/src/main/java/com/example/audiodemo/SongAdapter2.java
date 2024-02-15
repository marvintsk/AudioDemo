package com.example.audiodemo;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SongAdapter2 extends BaseAdapter {
    List<Song> adapterSongList2;

    public List<Song> getAdapterSongList2() {
        return adapterSongList2;
    }

    public void setAdapterSongList2(List<Song> adapterSongList2) {
        this.adapterSongList2 = adapterSongList2;
        notifyDataSetChanged();
    }

    public int getSelectedInd() {
        return SelectedInd;
    }

    public void setSelectedInd(int selectedInd) {
        SelectedInd = selectedInd;
        notifyDataSetChanged();
    }

    int SelectedInd =-1;


    public SongAdapter2(List<Song> adapterSongList2) {
        this.adapterSongList2 = adapterSongList2;
    }

    @Override
    public int getCount() {
        return adapterSongList2.size();
    }

    @Override
    public Object getItem(int i) {
        return adapterSongList2.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_songitem2,parent,false);

        }
        TextView txtViewSong2 = convertView.findViewById(R.id.textViewSongItem2);
        ImageView imgViewSong2 = convertView.findViewById(R.id.imgViewSongItem2);
        ImageView imgViewPlayView = convertView.findViewById(R.id.imageViewPlayPause);
        txtViewSong2.setText(adapterSongList2.get(i).getSongName());
        imgViewSong2.setImageResource(adapterSongList2.get(i).getSongPic());
        //imgViewSong2.setImageResource(0);//no image shown
        if(i == SelectedInd){
            imgViewPlayView.setImageResource(R.drawable.stop);
        }else {
            imgViewPlayView.setImageResource(R.drawable.play);
        }
        return convertView;
        //return View;
    }
}
