package com.example.nthanh.mediaplayerexample;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by nthanh on 19/01/2016.
 */
public class MediaBackgroundMusic {
    private String pathURL;
    private MediaPlayer mPlayer;

    public MediaBackgroundMusic(){

    }
    public MediaBackgroundMusic(String uri){
        this.pathURL = uri;
    }

    public String getPathURL() {
        return pathURL;
    }

    public void setPathURL(String pathURL) {
        this.pathURL = pathURL;
    }

    public void playMusic(Context context){
        //refer resource in res/raw directory
        //Uri myUri = Uri.parse("android.resource://com.prgguru.example/" + R.raw.song);
        Uri myUri = Uri.parse(this.pathURL);
        mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mPlayer.setDataSource(context, myUri);
        } catch (IllegalArgumentException e) {
            Toast.makeText(context.getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (SecurityException e) {
            Toast.makeText(context.getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IllegalStateException e) {
            Toast.makeText(context.getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mPlayer.prepare();
        } catch (IllegalStateException e) {
            Toast.makeText(context.getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(context.getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        }
        mPlayer.start();
    }

    public void stopMusic(){
        if(mPlayer!=null && mPlayer.isPlaying()){
            mPlayer.stop();
        }
    }
}
