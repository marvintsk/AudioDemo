package com.example.audiodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadModelData();

        ListView ListViewSongs = findViewById(R.id.ListViewSong);
        //Create adapter Object
       // SongAdapter songAdapter = new SongAdapter(SongList);
        SongAdapter2 songAdapter2 = new SongAdapter2(SongList);
        ListViewSongs.setAdapter(songAdapter2);
        ListViewSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if(mediaPlayer!=null && mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
            if(songAdapter2.getSelectedInd() == i){
                songAdapter2.setSelectedInd(-1);
                songAdapter2.notifyDataSetChanged();// set Adapater Song to start
            }else{
                mediaPlayer = MediaPlayer.create(MainActivity.this,SongList.get(i).getSongRaw());
                mediaPlayer.start();
            }


                /*switch(i){
                    case 0:
                        Toast.makeText(MainActivity.this, "Clicked On Bagpipes", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Clicked On Ukulele", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Clicked On Drums", Toast.LENGTH_SHORT).show();
                }*/

            }
        });
    }

    private void LoadModelData(){
        for (int i=0;i <SongName.size(); i++)
        {
            Song eachSong = new Song(SongName.get(i),SongPics.get(i), SongRaws.get(i));
            SongList.add(eachSong);
        }
    }
}