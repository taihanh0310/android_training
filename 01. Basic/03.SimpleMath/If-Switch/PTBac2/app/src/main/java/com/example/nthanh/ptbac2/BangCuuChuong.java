package com.example.nthanh.ptbac2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BangCuuChuong extends AppCompatActivity {

    Button btnThucHien;
    EditText txtNhapN;
    TextView lbResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_cuu_chuong);

    }

    public String printBangCuuChuong(String soN){
        int n = Integer.parseInt(soN);
        String content = "";
        for (int i = 1; i <= 9; i++){
            content += n + " x " + i + " x " + (n * i) + "\n ";
        }
        return content;
    }

    public void processBangCuuChuong(View view){
        //String content
        txtNhapN = (EditText) findViewById(R.id.txtBCCNhapSo);
        lbResult = (TextView) findViewById(R.id.lbBBCResult);
        String number = txtNhapN.getText().toString();
        String content = this.printBangCuuChuong(number);
        lbResult.setText(content);
        txtNhapN.setText("");
    }

}
