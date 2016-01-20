package com.example.nthanh.customlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by nthanh on 19/01/2016.
 */
public class MyArrayAdapter extends ArrayAdapter<Employee>{

    Activity context = null;
    ArrayList<Employee> myArray = null;
    int layoutId;

    public MyArrayAdapter(Activity context, int layoutId, ArrayList<Employee> arr){
        super(context, layoutId, arr);
        this.context = context;
        this.myArray = arr;
        this.layoutId = layoutId;
    }

    /*
    * ham dung de custom layout, ta phai override lai ham nay tu MainActivity truyen vao.
    * @param: postion la vi tri cua phan tu trong danh sach
    * @convertView dung de xu ly item
    * @param: parent danh sach nhan vien truyen tu main
    * @return View: tra ve chinh convertview
    * */
    public View getView(int postion, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);

        //dong lenh lay textview ra de hien thi Ma va ten len
        final TextView txtDispplay = (TextView) convertView.findViewById(R.id.txtitem);

        //lay nhan vien thu position
        final Employee employee = myArray.get(postion);

        //dua thong tin len textview
        txtDispplay.setText(employee.toString());

        //lay imageview ra de thiet lap cho hinh anh dung
        final ImageView imgItem = (ImageView) convertView.findViewById(R.id.imgitem);

        //neu la nu thi lay hinh con gai
        if(employee.isGender()){
            imgItem.setImageResource(R.drawable.girlicon);
        }
        else{
            imgItem.setImageResource(R.drawable.boyicon);
        }

        //tra ve view la tra ve luon cac thong so moi vua thay doi
        return convertView;
    }
}
