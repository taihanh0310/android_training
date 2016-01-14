package com.example.nthanh.demodangnhap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtUserName, txtPassword;
    Button btnDangNhap;
    CheckBox ckbSaveInfo;
    //http://www.tutorialspoint.com/android/android_alert_dialoges.htm

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void processDangNhap(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

    }

    public String dangNhap(String userName, String passWord, CheckBox cb){
        String content = "";
        return content;
    }
}
