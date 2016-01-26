package com.example.nthanh.gviewactivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by nthanh on 26/01/2016.
 */
public class ImageAdapterGallery extends BaseAdapter {
    int mGalleryItemBackground;
    private Context mContext;

    private Integer[] mImageIds = {
            R.drawable.aaa,
            R.drawable.bbb,
            R.drawable.ccc,
            R.drawable.ddd,
            R.drawable.eee,
            R.drawable.fff
    };

    public ImageAdapterGallery(Context c){
        mContext = c;
        TypedArray a = c.obtainStyledAttributes(R.styleable.GalleryA);
        mGalleryItemBackground = a.getResourceId(
                R.styleable.GalleryA_android_galleryItemBackground, 0);
        a.recycle();
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView i = new ImageView(mContext);

        i.setImageResource(mImageIds[position]);
        i.setLayoutParams(new Gallery.LayoutParams(150, 100));
        i.setScaleType(ImageView.ScaleType.FIT_XY);
        i.setBackgroundResource(mGalleryItemBackground);

        return i;
    }

}
