package com.example.nthanh.ptbac2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DoCQuaDoF extends AppCompatActivity {

    Button buttonDoF, buttonDoC, buttonClear;
    EditText editTextDoF, editTextDoC;

    View.OnClickListener myVarListenner = new View.OnClickListener() {
        double result;
        @Override
        public void onClick(View v) {
            String doF = editTextDoF.getText().toString();
            String doC = editTextDoC.getText().toString();
            if(v  == buttonClear){
                clearTextField();
            }
            if(v == buttonDoC){
                result = convertDoCToDoF(doC);
                editTextDoF.setText(Double.toString(result));
            }
            if(v == buttonDoF){
                result = convertDoFToDoC(doF);
                editTextDoC.setText(Double.toString(result));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_cqua_do_f);

        //getedit text
        editTextDoC = (EditText) findViewById(R.id.txtConvertToC);
        editTextDoF = (EditText) findViewById(R.id.txtConvertToF);
        //get id edittext, button
        buttonClear = (Button) findViewById(R.id.btnCTFClear);
        buttonDoC = (Button) findViewById(R.id.btnCF);
        buttonDoF = (Button) findViewById(R.id.btnFC);

        //added event
        buttonClear.setOnClickListener(myVarListenner);
        buttonDoF.setOnClickListener(myVarListenner);
        buttonDoC.setOnClickListener(myVarListenner);
    }

    public void clearTextField(){
        editTextDoC.setText("");
        editTextDoF.setText("");
        editTextDoF.setFocusable(true);
    }

    public double convertDoFToDoC(String input){
        double result = 0;
        double doF = Double.parseDouble(input);
        result = (doF - 32)* (5/9);
        return  result;
    }
    public double convertDoCToDoF(String input){
        double result = 0;
        double doC = Double.parseDouble(input);
        result = (doC * (5/9)) + 32;
        return  result;
    }
}
