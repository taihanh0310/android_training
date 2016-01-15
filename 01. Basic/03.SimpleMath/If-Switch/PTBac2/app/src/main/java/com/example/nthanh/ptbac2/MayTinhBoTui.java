package com.example.nthanh.ptbac2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MayTinhBoTui extends AppCompatActivity {

    Button btnDelete, btnDot, btnSo0, btnCalcResult, btnCong, btnTru, btnSo3, btnSo2, btnSo1, btnSo4, btnSo5, btnSo6, btnSo7, btnSo8, btnSo9, btnChia, btnNhan;
    TextView lbScreen, lbCalcResult;
    private View.OnClickListener event = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            String currentText = lbScreen.getText().toString();

            if(btnDelete == v){
                lbScreen.setText("");
                lbCalcResult.setText("");
            }
            if(btnSo1 == v){
                lbScreen.setText(currentText + "1");
            }
            if(btnSo2 == v){
                lbScreen.setText(currentText + "2");
            }
            if(btnSo3 == v){
                lbScreen.setText(currentText + "3");
            }
            if(btnSo4 == v){
                lbScreen.setText(currentText + "4");
            }
            if(btnSo5 == v){
                lbScreen.setText(currentText + "5");
            }
            if(btnSo6 == v){
                lbScreen.setText(currentText + "6");
            }
            if(btnSo7 == v){
                lbScreen.setText(currentText + "7");
            }
            if(btnSo8 == v){
                lbScreen.setText(currentText + "8");
            }
            if(btnSo9 == v){
                lbScreen.setText(currentText + "9");
            }
            if(btnDot == v){
                lbScreen.setText(currentText + ".");
            }
            if(btnSo0 == v){
                if(currentText.length() > 0 ){
                    lbScreen.setText(currentText + "0");
                }
            }
            if(btnChia == v){
                if(currentText.length() > 0 ){
                    lbScreen.setText(currentText + "/");
                }
            }
            if(btnNhan == v){
                if(currentText.length() > 0 ){
                    lbScreen.setText(currentText + "x");
                }
            }
            if(btnCong == v){
                if(currentText.length() > 0 ){
                    lbScreen.setText(currentText + "+");
                }
            }
            if(btnTru == v){
                if(currentText.length() > 0 ){
                    lbScreen.setText(currentText + "-");
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may_tinh_bo_tui);

        btnDelete = (Button)findViewById(R.id.btnCalcDelete);
        btnDot = (Button)findViewById(R.id.btnCalcDot);
        btnSo0 = (Button)findViewById(R.id.btnCalc0);
        btnCalcResult = (Button)findViewById(R.id.btnCalcResult);
        btnCong = (Button)findViewById(R.id.btnCalcCong);
        btnTru = (Button)findViewById(R.id.btnCalcTru);
        btnSo3 = (Button)findViewById(R.id.btnCalc3);
        btnSo2 = (Button)findViewById(R.id.btnCalc2);
        btnSo1 = (Button)findViewById(R.id.btnCalc1);
        btnSo4 = (Button)findViewById(R.id.btnCalc4);
        btnSo5 = (Button)findViewById(R.id.btnCalc5);
        btnSo6 = (Button)findViewById(R.id.btnCalc6);
        btnSo7 = (Button)findViewById(R.id.btnCalc7);
        btnSo8 = (Button)findViewById(R.id.btnCalc8);
        btnSo9 = (Button)findViewById(R.id.btnCalc9);
        btnChia = (Button)findViewById(R.id.btnCalcChia);
        btnNhan = (Button)findViewById(R.id.btnCalcNhan);

        lbScreen = (TextView) findViewById(R.id.txtCalcText);
        lbCalcResult = (TextView) findViewById(R.id.lbCalcResult);
        /*
        * add event
        * */
        btnDelete.setOnClickListener(this.event);
        btnCalcResult.setOnClickListener(this.event);
        btnDot.setOnClickListener(this.event);
        btnTru.setOnClickListener(this.event);
        btnCong.setOnClickListener(this.event);
        btnSo0.setOnClickListener(this.event);
        btnSo1.setOnClickListener(this.event);
        btnSo2.setOnClickListener(this.event);
        btnSo3.setOnClickListener(this.event);
        btnSo4.setOnClickListener(this.event);
        btnSo5.setOnClickListener(this.event);
        btnSo6.setOnClickListener(this.event);
        btnSo7.setOnClickListener(this.event);
        btnSo8.setOnClickListener(this.event);
        btnSo9.setOnClickListener(this.event);
        btnChia.setOnClickListener(this.event);
        btnNhan.setOnClickListener(this.event);


    }
}
