package com.example.nthanh.autocomplete;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteActivity extends Activity {

    TextView selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        AutoCompleteTextView textview = (AutoCompleteTextView) findViewById(R.id.edit);
        selection = (TextView) findViewById(R.id.selection);
        //array adapter

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, WORLDCUP2010);

        textview.setAdapter(adapter);
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
