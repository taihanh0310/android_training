package com.example.nthanh.rawfolder;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // variable declaration
    private ListView mainList;
    private MediaPlayer mp;
    private final String[] listContent = { "chimes", "chord", "ding", "notify",
            "recycle", "ringin", "ringout", "tada" };

    private ArrayList myList = null;

    //http://www.geeks.gallery/how-to-play-mp3-file-from-raw-folder-in-a-listview-android/
    private final int[] resID = { R.raw.chimes, R.raw.chord, R.raw.ding,
            R.raw.notify, R.raw.recycle, R.raw.ringin, R.raw.ringout,
            R.raw.tada };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        myList = new ArrayList<String>();
//        myList = getAllFileToFolder(getResources().openR)
        Uri myUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.class);
        Log.i("MyURL", myUri.toString());

        //Initializing variables
        mp = new MediaPlayer();
        mainList = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listContent);
        mainList.setAdapter(adapter);

        //add event to onclick
        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                playSong(position);
            }
        });
    }

    public void playSong(int position){
        //Play song
        mp.reset();//stop and current playing song

        mp = MediaPlayer.create(getApplicationContext(), resID[position]);

        //starting media player
        mp.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.release();
    }

    public ArrayList getAllFileToFolder(String urlLocation){
        ArrayList myList = new ArrayList<String>();
        File file = new File(urlLocation);
        File list[] = file.listFiles();

        for (int i = 0; i < list.length ; i ++ ){
            myList.add(list[i].getName());
        }
        return myList;
    }
}
