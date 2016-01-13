package com.example.nthanh.hinhchunhat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void tinhDienTich(View view){

        EditText editTextChieuDai = (EditText) findViewById(R.id.txtChieuDai);
        EditText editTextChieuRong = (EditText) findViewById(R.id.txtChieuRong);
        TextView textViewResult = (TextView)findViewById(R.id.lbResult);

        int result = this.phepNhan(editTextChieuDai.getText().toString(), editTextChieuRong.getText().toString());
        int chuVi = this.tinhChuVi(editTextChieuDai.getText().toString(), editTextChieuRong.getText().toString());
        textViewResult.setText("Dien tich: " + Integer.toString(result) + " | Chu Vi: " + Integer.toString(chuVi));
    }

    public int phepNhan(String txtsoA, String txtSoB){
        int result = 0;
        int soA = 0;
        int soB = 0;
        if(txtsoA != null && txtSoB != null){
            soA = Integer.parseInt(txtsoA);
            soB = Integer.parseInt(txtSoB);
        }

        result = soA * soB;
        return  result;
    }

    public int tinhChuVi(String txtSoA, String txtSoB){
        int result = 0;
        int soA = 0;
        int soB = 0;
        if(txtSoA != null && txtSoB != null){
            soA = Integer.parseInt(txtSoA);
            soB = Integer.parseInt(txtSoB);
        }

        result = (soA + soB)*2;
        return  result;
    }

    public String validate(String content){
        String message = "";
        if (content == null){
            message = "Vui long khong de trong";
        }
        return  message;
    }
}
