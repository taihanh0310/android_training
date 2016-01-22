package com.example.nthanh.vidu_listview_arraylist_object;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnNhap;
    EditText txtMaNhanVien, txtTenNhanVien;
    RadioGroup rdGroup;
    ListView lvNhanVien;
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee> adapter = null;

    //khai bao 1 object null
    Employee employee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhap = (Button) findViewById(R.id.btnNhapNhanVien);
        txtMaNhanVien = (EditText) findViewById(R.id.txtMaNhanVien);
        txtTenNhanVien = (EditText) findViewById(R.id.txtTenNhanVien);
        lvNhanVien = (ListView) findViewById(R.id.lvDanhSachNhanVien);
        rdGroup= (RadioGroup) findViewById(R.id.radiogroud1);

        //dua datasouce to la emmployee vao adatapte
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrEmployee);

        //dua adapter vao listview
        lvNhanVien.setAdapter(adapter);

        //set btutton nhap listten onclick event
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("teste", "Process nhap");
                processNhap();
                processAffterNhap();
            }
        });
    }

    public void processNhap(){
        //lay ID cua radio button checked
        int radId = rdGroup.getCheckedRadioButtonId();
        String maNhanVien = txtMaNhanVien.getText().toString();
        String tenNhanVien = txtTenNhanVien.getText().toString();

        if (radId == R.id.radChinhthuc){
            employee = new EmployeeFullTime();
        }
        else{
            employee = new EmployeePartTime();
        }

        //added attributes employee;
        employee.setMaNhanVien(maNhanVien);
        employee.setTenNhanVien(tenNhanVien);

        arrEmployee.add(employee);
        //cap nhat giao dien
        adapter.notifyDataSetChanged();
    }

    public void processAffterNhap(){
        txtMaNhanVien.setText("");
        txtTenNhanVien.setText("");
        txtMaNhanVien.setFocusable(true);
    }
}
