package com.example.nthanh.ptbac2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChuyenDoiNamDuongLich extends AppCompatActivity {

    Button buttonConvert;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuyen_doi_nam_duong_lich);
        buttonConvert = (Button) findViewById(R.id.btnTranferYear);
        buttonConvert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //lay gia tri nhap tu edittor
                editText = (EditText) findViewById(R.id.txtInputNamDuongLich);
                textView = (TextView) findViewById(R.id.textView2);
                String content = getCanChi(editText.getText().toString());
                textView.setText("Nam am lich:" + content);
            }
        });
    }

    public String getCanChi(String nam){
        int namDuongLich = Integer.parseInt(nam);
        String can = "";
        String chi = "";

        switch (namDuongLich % 10){
            case 0:
                can = "Canh";
                break;
            case 1:
                can = "Tan";
                break;
            case 2:
                can = "Nham";
                break;
            case 3:
                can = "Quy";
                break;
            case 4:
                can = "Giap";
                break;
            case 5:
                can = "At";
                break;
            case 6:
                can = "Binh";
                break;
            case 7:
                can = "Dinh";
                break;
            case 8:
                can = "Mau";
                break;
            case 9:
                can = "Ky";
                break;
        }

        switch (namDuongLich % 12){
            case 0:
                chi = "Than";
                break;
            case 1:
                chi = "Dau";
                break;
            case 2:
                chi = "Tuat";
                break;
            case 3:
                chi = "Hoi";
                break;
            case 4:
                chi = "Ty";
                break;
            case 5:
                chi = "Suu";
                break;
            case 6:
                chi = "Dan";
                break;
            case 7:
                chi = "Meo";
                break;
            case 8:
                chi = "Thin";
                break;
            case 9:
                chi = "Ty";
                break;
            case 10:
                chi = "Ngo";
                break;
            case 11:
                chi = "Mui";
                break;
        }

        return can + " " + chi;
    }
}
