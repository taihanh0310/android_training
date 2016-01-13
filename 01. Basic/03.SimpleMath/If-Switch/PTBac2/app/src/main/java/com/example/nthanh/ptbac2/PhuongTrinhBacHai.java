package com.example.nthanh.ptbac2;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PhuongTrinhBacHai extends AppCompatActivity {

    Button btnTiepTuc, btnThoat, btnGiai;
    EditText editSoA, editSoB, editSoC;
    TextView lbKetQuaGiaiPhuongTrinh;
    /*https://duythanhcse.wordpress.com/2013/04/02/bai-tap-8-cac-kieu-lap-trinh-su-kien-trong-android/*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phuong_trinh_bac_hai);

        //gan event cho cac button
        btnGiai.setOnClickListener(new MyEvent());
        btnThoat.setOnClickListener(new MyEvent());
        btnTiepTuc.setOnClickListener(new MyEvent());
    }

    /*
    *
    * Giai phuong trinh bac 2
    * */
    public void giaiPhuongTrinhBacHai(){

    }

    public void thoatUngDung(){

    }
    public void tiepTucThucHienPhepTinh(){
        this.editSoA.setText("");
        this.editSoB.setText("");
        this.editSoC.setText("");
        this.lbKetQuaGiaiPhuongTrinh.setText("");

        //set cusor forcus to editA
        this.editSoA.requestFocus();
    }

    private class MyEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
        }
    }
}

