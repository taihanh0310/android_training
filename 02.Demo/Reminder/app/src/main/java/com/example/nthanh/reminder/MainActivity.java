package com.example.nthanh.reminder;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {

    // This is a handle so that we can call methods on our service
    private ScheduleClient scheduleClient;

    // This is the date picker used to select the date for our notification
    private DatePicker picker;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a new service client and bind our activity to this service
        scheduleClient = new ScheduleClient(this);
        scheduleClient.doBindService();

        // Get a reference to our date picker
        picker = (DatePicker) findViewById(R.id.scheduleTimePicker);
        button = (Button) findViewById(R.id.selectButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = picker.getDayOfMonth();
                int month = picker.getMonth();
                int year = picker.getYear();
                // Create a new calendar set to the date chosen
                // we set the time to midnight (i.e. the first minute of that day)
                Calendar c = Calendar.getInstance();
                c.set(year, month, day);
                c.set(Calendar.HOUR_OF_DAY, 0);
                c.set(Calendar.MINUTE, 0);
                c.set(Calendar.SECOND, 0);

                Toast.makeText(getApplicationContext(), "Notification set for: " + day + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onDateSelectedButtonClick(View v){
        // Get the date from our datepicker
        int day = picker.getDayOfMonth();
        int month = picker.getMonth();
        int year = picker.getYear();
        // Create a new calendar set to the date chosen
        // we set the time to midnight (i.e. the first minute of that day)
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        // Ask our service to set an alarm for that date, this activity talks to the client that talks to the service
        scheduleClient.setAlarmForNotification(c);
        // Notify the user what they just did
        Toast.makeText(this, "Notification set for: " + day + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show();
    }

    protected void onStop(){
        // When our activity is stopped ensure we also stop the connection to the service
        // this stops us leaking our activity into the system *bad*
        if(scheduleClient != null)
            scheduleClient.doUnbindService();
        super.onStop();
    }
}
