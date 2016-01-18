package com.example.nthanh.mediaplayerexample;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lbMusicName, lbMusicTime;
    private Button btnStart, btnStop, btnPause;
    private double finalTime = 0;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lbMusicName = (TextView) findViewById(R.id.lbMusicName);
        lbMusicTime = (TextView) findViewById(R.id.lbTimeMusic);

        //set music name
        lbMusicName.setText("Music name: AnhSeTotMa.mp3");

        //create media player
        mediaPlayer = MediaPlayer.create(this, R.raw.AnhSeTotMa);
    }
}
