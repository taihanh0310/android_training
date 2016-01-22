package com.example.nthanh.rawfolder;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // variable declaration
    private ListView mainList;
    private MediaPlayer mp;
    private final String[] listContent = { "chimes", "chord", "ding", "notify",
            "recycle", "ringin", "ringout", "tada" };

    //http://www.geeks.gallery/how-to-play-mp3-file-from-raw-folder-in-a-listview-android/
    private final int[] resID = { R.raw.chimes, R.raw.chord, R.raw.ding,
            R.raw.notify, R.raw.recycle, R.raw.ringin, R.raw.ringout,
            R.raw.tada };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
