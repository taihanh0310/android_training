package com.example.nthanh.demodangnhap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtUserName, txtPassword;
    Button btnDangNhap;
    CheckBox ckbSaveInfo;
    String username, password;
    //http://www.tutorialspoint.com/android/android_alert_dialoges.htm

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ckbSaveInfo = (CheckBox) findViewById(R.id.ckSaveInfo);

        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
    }

    public void processDangNhap(View view){
        password = txtPassword.getText().toString();
        username = txtUserName.getText().toString();
        String result = dangNhap(username, password, ckbSaveInfo);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(result);

        alertDialogBuilder.setPositiveButton("Dong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(MainActivity.this, "You clicked yes button", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public String dangNhap(String userName, String passWord, CheckBox cb){
        String content = "";
        if(cb.isChecked()){
            content = "Thong tin dang nhap: \n " +
                    " " + userName + " \n" +
                    passWord + " \n " +  " Thong tin da duoc luu " + " \n" ;
        }
        else{
            content = "Thong tin dang nhap: \n " +
                    " " + userName + " \n" +
                    passWord + " \n " +  " Thong tin chua duoc luu " + " \n" ;
        }
        return content;
    }
}
