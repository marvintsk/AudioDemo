package com.example.audiodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    List<String>SongName = new ArrayList<>(Arrays.asList
            ("Bags Pipe","Ukulele","Drums"));
    List<Integer> SongPics = new ArrayList<>(Arrays.asList
            (R.drawable.bagpipes,R.drawable.ukulele,R.drawable.drums));
    List<Integer> SongRaws = new ArrayList<>(Arrays.asList
            (R.raw.bagpipes,R.raw.ukulele,R.raw.drums));
    List<Song> SongList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadModelData();

        ListView ListViewSongs = findViewById(R.id.ListViewSong);
        //Create adapter Object
        SongAdapter songAdapter = new SongAdapter(SongList);
        ListViewSongs.setAdapter(songAdapter);
    }

    private void LoadModelData(){
        for (int i=0;i <SongName.size(); i++)
        {
            Song eachSong = new Song(SongName.get(i),SongPics.get(i), SongRaws.get(i));
            SongList.add(eachSong);
        }
    }
}