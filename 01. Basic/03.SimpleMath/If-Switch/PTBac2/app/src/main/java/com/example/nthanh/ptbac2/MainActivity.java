package com.example.nthanh.ptbac2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toScreenPTBac2(View view){
        Intent intent = new Intent(MainActivity.this, PhuongTrinhBacHai.class);
        startActivity(intent);
    }

    public void tranferScreenTimNamAmLich(View view){
        Intent intent = new Intent(MainActivity.this, ChuyenDoiNamDuongLich.class);
        startActivity(intent);
    }

    public void tranferScreenBanCuuChuong(View view){
        Intent intent = new Intent(MainActivity.this, BangCuuChuong.class);
        startActivity(intent);
    }
    public void tranferToScreenDoCToDoF(View view){
        Intent intent = new Intent(MainActivity.this, DoCQuaDoF.class);
        startActivity(intent);
    }

    public void tranferToScreenDialog(View view){
        Intent intent = new Intent(MainActivity.this, DemoDialog.class);
        startActivity(intent);
    }
}
