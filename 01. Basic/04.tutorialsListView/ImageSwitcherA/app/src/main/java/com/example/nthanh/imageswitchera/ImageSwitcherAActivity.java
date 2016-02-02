package com.example.nthanh.imageswitchera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

//http://www.bogotobogo.com/Android/android6ListViewSpinnerGridViewGalleryB.php#GridView

public class ImageSwitcherAActivity extends Activity implements AdapterView.OnItemSelectedListener, ViewSwitcher.ViewFactory {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_image_switcher_a);

        mSwitcher = (ImageSwitcher) findViewById(R.id.imgswitcher);
        mSwitcher.setFactory(this);
        mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        Gallery g = (Gallery) findViewById(R.id.gallery);
        g.setAdapter(new ImageAdapter(this));
        g.setOnItemSelectedListener(this);
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), Androidviewpagerapp.class);
                startActivity(i);
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        mSwitcher.setImageResource(mImageIds[position]);
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public View makeView() {
        ImageView i = new ImageView(this);
        i.setBackgroundColor(0xFF000000);
        i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        i.setLayoutParams(new ImageSwitcher.LayoutParams(GridLayout.LayoutParams.FILL_PARENT,
                GridLayout.LayoutParams.FILL_PARENT));
        return i;
    }

    private ImageSwitcher mSwitcher;

    public class ImageAdapter extends BaseAdapter {
        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);

            i.setImageResource(mThumbIds[position]);
            i.setAdjustViewBounds(true);
            i.setLayoutParams(new Gallery.LayoutParams(
                    GridLayout.LayoutParams.WRAP_CONTENT, GridLayout.LayoutParams.WRAP_CONTENT));
            i.setBackgroundResource(R.drawable.picture_frame);
            return i;
        }

        private Context mContext;
    }

    private Integer[] mThumbIds = {
            R.drawable.thumb1, R.drawable.thumb2,
            R.drawable.thumb3, R.drawable.thumb4,
            R.drawable.thumb5, R.drawable.thumb6,
            R.drawable.thumb7, R.drawable.thumb8};

    private Integer[] mImageIds = {
            R.drawable.sample1, R.drawable.sample2,
            R.drawable.sample3, R.drawable.sample4,
            R.drawable.sample5, R.drawable.sample6,
            R.drawable.sample7, R.drawable.sample8};
}
