package com.example.nthanh.customizedlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nthanh on 21/01/2016.
 */
public class CustomView extends ArrayAdapter<String>{
    private final Context context;
    private final String[] values;

    public CustomView(Context context, String[] values){
        super(context, R.layout.activity_main,values);
        this.context = context;
        this.values = values;
    }

    //get view


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_main, parent, false);
        TextView tv = (TextView) rowView.findViewById(R.id.label);
        ImageView iv = (ImageView) rowView.findViewById(R.id.logo);

        String item_value = values[position];
        if (item_value.equals("samsung")) {
            iv.setImageResource(R.drawable.samsung);
            tv.setText(item_value);
        } else if (item_value.equals("lg")) {
            iv.setImageResource(R.drawable.lg);
            tv.setText(item_value);
        } else if (item_value.equals("htc")) {
            iv.setImageResource(R.drawable.htc);
            tv.setText(item_value);
        } else if (item_value.equals("moto")) {
            iv.setImageResource(R.drawable.moto);
            tv.setText(item_value);
        } else if (item_value.equals("nexus")) {
            iv.setImageResource(R.drawable.nexus);
            tv.setText(item_value);
        }

        return rowView;
    }
}
