package com.example.nthanh.mediaplayerexample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView lbMusicName, lbMusicTime;
    private Button btnStart, btnStop, btnPause;
    private double finalTime = 0;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listRaw();

        lbMusicName = (TextView) findViewById(R.id.lbMusicName);
        lbMusicTime = (TextView) findViewById(R.id.lbTimeMusic);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnPause = (Button) findViewById(R.id.btnPause);

        //set music name
        lbMusicName.setText("Music name: AnhSeTotMa.mp3");

        //create media player
        mediaPlayer = MediaPlayer.create(this, R.raw.anhsetotma);
        //set btnstart to enable
        btnStart.setEnabled(true);

        //add event btnClick
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start music
                Toast.makeText(getApplicationContext(), "Playing music", Toast.LENGTH_SHORT).show();
                //mediaPlayer.reset();
                mediaPlayer.start();
                //set time
                finalTime = mediaPlayer.getDuration();
                lbMusicTime.setText("Time: " + String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));
                //enable pause button, stop button
                btnPause.setEnabled(true);
                btnStop.setEnabled(true);
                //disable start button
                btnStart.setEnabled(false);
            }
        });

        //add event btn pause
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pause music", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                btnStart.setEnabled(true);
                btnPause.setEnabled(false);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Stop music", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                btnStart.setEnabled(true);
                btnPause.setEnabled(false);
                btnStop.setEnabled(false);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    public void listRaw(){
        Field[] fields=R.raw.class.getFields();
        for(int count=0; count < fields.length; count++){
            Log.i("Raw Asset: ", fields[count].getName());
        }
    }

}
