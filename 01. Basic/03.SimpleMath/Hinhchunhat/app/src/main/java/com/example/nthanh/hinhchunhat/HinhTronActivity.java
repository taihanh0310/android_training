package com.example.nthanh.hinhchunhat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HinhTronActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hinh_tron);
    }

    public void tinhChuViHinhTron(View view){
        EditText editTextBanKinh = (EditText) findViewById(R.id.txtBanKinh);
        TextView textViewChuViHinhTronResult = (TextView) findViewById(R.id.lbResultChuVi);
        double banKinh = Double.parseDouble(editTextBanKinh.getText().toString());
        double chuVi = 2*Math.PI*banKinh;
        textViewChuViHinhTronResult.setText("Ban Kinh: " + editTextBanKinh.getText().toString() + "| Chu vi: " + Double.toString(chuVi));
    }
}
