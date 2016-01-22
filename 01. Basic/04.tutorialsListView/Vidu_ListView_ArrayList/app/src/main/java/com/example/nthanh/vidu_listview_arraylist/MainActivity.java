package com.example.nthanh.vidu_listview_arraylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtChon,txtTen;
    Button btnButton;
    ListView listView;
    ArrayList<String> arrayList = null;
    ArrayAdapter<String> arrayAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStart();
        arrayList = new ArrayList<String>();

        //gen datasouce arraylist object vao arrayAdapter
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        //xu ly button nhap
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(txtTen.getText()+ "");
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    public void initStart(){
        txtChon = (TextView) this.findViewById(R.id.txtTen);
        txtTen = (TextView) this.findViewById(R.id.txtselection);
        listView = (ListView) this.findViewById(R.id.lvperson);
        btnButton = (Button) findViewById(R.id.btnNhap);
    }
}
