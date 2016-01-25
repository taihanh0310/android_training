package com.example.nthanh.simplelistview2;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//http://www.bogotobogo.com/Android/android6ListViewSpinnerGridViewGallery.php

/**
 * The ArrayAdapter constructor takes following three parameters:

 The Context to use, typically, this will be our activity instance.
 The resource ID of a view to use, for example, built in resource ID.
 The actual array or list.
 */
public class SimpleListViewActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_simple_list_view);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, WORLDCUP2010));
        //get listview
        ListView lv =  getListView();
        lv.setTextFilterEnabled(true);

        //set event click cua listview
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    static final String[] WORLDCUP2010 = new String[] {
            "Algeria",  "Argentina", "Australia",
            "Brazil", "Cote d'Ivoire", "Cameroon",
            "Chile", "Costa Rica", "Denmark",
            "England", "France", "Germany",
            "Ghana",  "Greece", "Honduras",
            "Italy",  "Japan", "Netherlands",
            "New Zealand", "Nigeria", "North Korea",
            "Paraguay", "Portugal","Serbia",
            "Slovakia", "Slovenia", "South Africa",
            "South Korea",  "Spain", "Switzerland",
            "United States", "Uruguay" };
}
