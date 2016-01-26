package com.example.nthanh.gviewactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class GViewBActivity extends Activity implements AdapterView.OnItemSelectedListener {

    TextView selection;

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
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_gview_b);
        selection=(TextView)findViewById(R.id.selection);

        GridView g=(GridView) findViewById(R.id.grid);
        g.setAdapter(new FunnyLookingAdapter(this,
                android.R.layout.simple_list_item_2,
                WORLDCUP2010));
        g.setOnItemSelectedListener(this);

        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),GalleryAActivity.class);
                startActivity(i);
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View v,
                               int position, long id) {
        selection.setText(WORLDCUP2010[position]);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        selection.setText("");
    }
}
