package com.example.nthanh.thongtincanhan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtHoTen, txtCMND, txtThongTinBoSung;
    RadioGroup gbtnBangCap;
    RadioButton rbtnTrungCap, rbtnCaoDang, rbtnDaiHoc;
    CheckBox ckDocBao, ckDocSach, ckDocCode;
    Button btnGuiThongTin ;

    View.OnClickListener event = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            doShowInformation();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCMND = (EditText) findViewById(R.id.editCMND);
        txtHoTen = (EditText) findViewById(R.id.editHoten);
        txtThongTinBoSung = (EditText) findViewById(R.id.editBosung);
        ckDocBao=(CheckBox) findViewById(R.id.chkdocbao);
        ckDocCode=(CheckBox) findViewById(R.id.chkdoccoding);
        ckDocSach=(CheckBox) findViewById(R.id.chkdocsach);
        gbtnBangCap = (RadioGroup) findViewById(R.id.radioGroup1);
        btnGuiThongTin = (Button) findViewById(R.id.btnguitt);
        //set event
        btnGuiThongTin.setOnClickListener(event);

    }

    public String validateCMND(String cmnd){
        String content = "";
        if(cmnd == null){
            content += "Vui long nhap vao so cmnd \n";
        }
        else if(cmnd.length() < 9 || cmnd.length() >9){
            content += "CMND bat buoc tu 9 ki tu! \n";
        }
        return content;
    }

    public void doShowInformation(){
        String ten = txtHoTen.getText().toString();
        String cmnd = txtHoTen.getText().toString();
        String messgeCMND = validateCMND(cmnd);

        ten = ten.trim();
        if(ten.length() < 3){
            txtHoTen.requestFocus();
            txtHoTen.selectAll();
            //in ra message
            Toast.makeText(this, "Ten phai >= 3 ku ty", Toast.LENGTH_LONG).show();
            return;
        }

//        if(cmnd.trim().length() > 9 || cmnd.trim().length() < 9){
//            txtCMND.requestFocus();
//            txtCMND.selectAll();
//            Toast.makeText(this, "CMND chi co 9 ki tu ", Toast.LENGTH_LONG).show();
//            return;
//        }

        //kiem tra bang cap
        String bangCap = "";
        int id = gbtnBangCap.getCheckedRadioButtonId();
        if(id == -1){
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad = (RadioButton) findViewById(id);
        bangCap = rad.getText().toString() + "\n";

        //kiem tra so thich
        String soThich = "";
        if(ckDocBao.isChecked()){
            soThich += ckDocBao.getText()+ "\n";
        }
        if(ckDocCode.isChecked()){
            soThich += ckDocCode.getText()+ "\n";
        }
        if(ckDocSach.isChecked()){
            soThich += ckDocSach.getText()+ "\n";
        }

        String boSung = txtThongTinBoSung.getText().toString() + "\n";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thong tin ca nhan");
        builder.setPositiveButton("Dong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //close dung dung;
                dialog.cancel();
            }
        });
        String msg = ten + "\n";
        msg += cmnd + "\n";
        msg += bangCap;
        msg += soThich;
        msg += "-----------------------\n";
        msg += "Thong tin bo sung: \n";
        msg += boSung;
        msg += "-----------------------\n";

        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//hiển thị Dialog
    }
}
