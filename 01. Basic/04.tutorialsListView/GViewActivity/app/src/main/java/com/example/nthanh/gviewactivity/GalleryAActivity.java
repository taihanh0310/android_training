package com.example.nthanh.gviewactivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.Toast;

public class GalleryAActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_a);
        Gallery g = (Gallery) findViewById(R.id.gallery);
        g.setAdapter(new ImageAdapterGallery(this));

        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick
                    (AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(GalleryAActivity.this, ""
                        + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
