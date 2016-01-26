package com.example.nthanh.gviewactivity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by nthanh on 26/01/2016.
 */
public class FunnyLookingAdapter extends ArrayAdapter<String> {
    Context ctxt;

    FunnyLookingAdapter(Context ctxt, int resource,
                        String[] WORLDCUP2010) {
        super(ctxt, resource, WORLDCUP2010);

        this.ctxt=ctxt;
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        TextView label=(TextView)convertView;

        if (convertView==null) {
            convertView=new TextView(ctxt);
            label=(TextView)convertView;
        }

        label.setText(GViewBActivity.WORLDCUP2010[position]);

        return(convertView);
    }
}
