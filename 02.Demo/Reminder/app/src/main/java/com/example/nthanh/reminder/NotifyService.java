package com.example.nthanh.reminder;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.nthanh.reminder.SecondActivity;
/**
 * Created by nthanh on 4/8/2016.
 */
public class NotifyService extends Service {
    /*
        Class for clients to access
     */
    public class ServiceBinder extends Binder{
        NotifyService getService(){
            return NotifyService.this;
        }
    }

    // Unique id to identìy the notification
    private static final int NOTIFICATION = 123;

    // Name of an intent extra
    public static final  String INTENT_NOTIFY = "INTENT_NOTIFY";

    private NotificationManager nNM;

    @Override
    public void onCreate(){
        Log.i("NotifySevice", "OnCreate");
        nNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        // If this service was started by out AlarmTask intent then we want to show our notification
        if(intent.getBooleanExtra(INTENT_NOTIFY, false)){
            showNotification();
        }
        return START_NOT_STICKY;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private final IBinder mBinder = new ServiceBinder();

    private void showNotification(){
        // This is the 'title' of the notification
        CharSequence title = "Alarm";

        // This is the icon to use on the notification
        int icon = R.drawable.ic_dialog_alert;

        CharSequence text = "Your notification time is upon us.";

        // What time to show on the notification
        long time = System.currentTimeMillis();

        Notification notification = new Notification(icon, text, time);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, SecondActivity.class), 0);

        // Set the info for the views that show in the notification panel.
        //notification.setLatestEventInfo(this, title, text, contentIntent);

        // Clear the notification when it is pressed
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        // Send the notification to the system.
        nNM.notify(NOTIFICATION, notification);

        // stop the service when finished
        stopSelf();
    }
}
