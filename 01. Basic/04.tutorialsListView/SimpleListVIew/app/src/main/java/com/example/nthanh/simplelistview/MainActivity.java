package com.example.nthanh.simplelistview;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity {

    String[] planets = new String[]{
            "Sun", "Mercury", "Venus", "Earth",
            "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
    };

    //create adapter array
    ArrayAdapter<String> arrayAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Khoi tao array
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, planets);
        final ListView listView = (ListView) this.findViewById(R.id.listView);
        //set data
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("View",view.getContext().toString() +  " - Posotion: " + position);
                Log.i("Item - ", listView.getItemAtPosition(position).toString());
            }
        });

    }
}
