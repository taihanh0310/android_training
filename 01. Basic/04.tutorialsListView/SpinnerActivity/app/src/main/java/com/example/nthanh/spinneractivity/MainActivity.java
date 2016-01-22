package com.example.nthanh.spinneractivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Tạo một mảng dữ liệu giả
    String arr[]={
            "Hàng điện tử",
            "Hàng hóa chất",
            "Hàng gia dụng"};
    TextView selection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selection =(TextView) findViewById(R.id.selection);

        Spinner spin = (Spinner) findViewById(R.id.spinner1);

        //adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);

        //hien thi danh sach cho spinner
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        //thiet lap adapter cho Spinner
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection.setText(arr[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selection.setText("");
            }
        });
    }
}
