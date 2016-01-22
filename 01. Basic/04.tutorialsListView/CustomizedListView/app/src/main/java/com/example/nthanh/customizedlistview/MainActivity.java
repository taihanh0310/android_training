package com.example.nthanh.customizedlistview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] mob = new String[] { "samsung", "lg", "htc", "moto", "nexus" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        CustomView cv = new CustomView(this, mob);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //getting the value of cliced item
        String clicked_item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, clicked_item, Toast.LENGTH_LONG).show();
    }
}
