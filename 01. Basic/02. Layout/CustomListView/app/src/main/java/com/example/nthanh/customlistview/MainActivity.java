package com.example.nthanh.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();

    //su dung MyArrayAdapter thay vi ArrayAdapter
    MyArrayAdapter adapter = null;
    ListView lvNhanVien;

    Button btnNhap;
    ImageButton btnRemoveAll;
    EditText editMa, editTen;
    RadioGroup genderGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFunction();
        eventSetup();
    }

    private void initFunction(){
        btnNhap = (Button) findViewById(R.id.btnNhap);
        btnRemoveAll = (ImageButton) findViewById(R.id.btndelete);
        editMa = (EditText) findViewById(R.id.editMa);
        editTen = (EditText) findViewById(R.id.editTen);
        genderGroup = (RadioGroup) findViewById(R.id.radioGroup1);

        lvNhanVien = (ListView) findViewById(R.id.lvnhanvien);
        employeeArrayList = new ArrayList<Employee>();

        //khoi tao doi tuong adapter va gan datasource
        adapter=new MyArrayAdapter(
                this,
                R.layout.my_item_layout,// lấy custom layout
                employeeArrayList/*thiết lập data source*/);
        lvNhanVien.setAdapter(adapter);//gán Adapter vào Lisview
    }

    private void eventSetup(){
        btnNhap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                getXulyNhap();
            }
        });

        btnRemoveAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                xuLyXoaEmployee();
            }
        });
    }

    private void getXulyNhap() {
        String ma = editMa.getText()+ "";
        String ten = editTen.getText() + "";
        boolean gioitinh = false;
        if(genderGroup.getCheckedRadioButtonId() == R.id.radNu){
            gioitinh = true;
        }

        //tao mot employee
        Employee e = new Employee();
        e.setId(ma);
        e.setName(ten);
        e.setGender(gioitinh);

        //dua employee vao danh sach mang
        employeeArrayList.add(e);

        //goi ham cap nhap giao dien
        adapter.notifyDataSetChanged();

        //sau khi nhap thi xoa trang du lieu
        clearFields();
    }

    private void xuLyXoaEmployee(){
        for (int i = lvNhanVien.getChildCount() - 1; i>0; i--){
            View v = lvNhanVien.getChildAt(i);
            //check checkbox da check chua de xoa
            CheckBox checkBox = (CheckBox) v.findViewById(R.id.chkitem);
            if(checkBox.isChecked()){
                employeeArrayList.remove(i);
            }
        }
        //update la giao dien
        adapter.notifyDataSetChanged();
    }

    private void clearFields(){
        editMa.setText("");
        editTen.setText("");
        editMa.requestFocus();
    }
}
