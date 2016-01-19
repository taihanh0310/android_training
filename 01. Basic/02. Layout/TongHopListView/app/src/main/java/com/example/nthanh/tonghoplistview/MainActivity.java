package com.example.nthanh.tonghoplistview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnTT, btnTiep, btnTK;
    ImageButton btnThoat;
    EditText editTen, editSoLuong, editTongKhachHang, editTongKhachVip, editTongTaiKhoan;
    TextView txtTT;
    CheckBox chkVip;
    DanhSachKhachHang danhsach=new DanhSachKhachHang();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitUI();
        addEvent();
    }

    /*
    * Init UI
    * */
    public void InitUI(){
        btnTT = (Button) findViewById(R.id.btntinhtt);
        btnThoat = (ImageButton) findViewById(R.id.imgbtnthoat);
        btnTiep = (Button) findViewById(R.id.btntiep);
        btnTK = (Button) findViewById(R.id.btnthongke);

        //edit text
        editTen = (EditText) findViewById(R.id.edittenkh);
        editSoLuong = (EditText) findViewById(R.id.editsoluongsach);
        editTongKhachHang = (EditText) findViewById(R.id.edittongsokh);
        editTongKhachVip = (EditText) findViewById(R.id.edittongsokhlavip);
        editTongTaiKhoan = (EditText) findViewById(R.id.edittongdt);
        //textview
        txtTT = (TextView) findViewById(R.id.txtthanhtien);
        //checkbox
        chkVip = (CheckBox) findViewById(R.id.chklavip);
    }

    /*
    * Nhap khach hang tiep theo
    * */
    public void nhapKhachHangTiepTheo(){
        editTen.setText("");
        editSoLuong.setText("");
        chkVip.setChecked(false);
        //set forcus name
        editTen.setFocusable(true);
    }

    public void exitPrograme(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hoi thoar chuong trinh");
        builder.setMessage("Muon thoat chuong trinh nay ha? ");
        builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.create().show();
    }

    public void doThongKe(DanhSachKhachHang ds){
        editTongKhachHang.setText(ds.soLuongKhachHang() + "");
        editTongKhachVip.setText(ds.soLuongKhachVip() + "");
        editTongTaiKhoan.setText(ds.tongDoanhThu() + "");
    }

    public void doTinhTien(String tenKhachHang,String soLuong, Boolean laKhachVip){
        //tao moi khach hang
        KhachHang kh = new KhachHang();
        kh.setTenKhachHang(tenKhachHang);
        kh.setSoLuongMua(Integer.parseInt(soLuong));
        kh.setIsKhachVip(laKhachVip);
        //in thanh tien ra bang
        txtTT.setText(kh.thanhTien() + "");

        danhsach.themKhachHang(kh);
        //them khach hang vao danh sach

        //enable button tiep theo
        btnTiep.setEnabled(true);
        //enable button thongke
        btnTK.setEnabled(true);
    }

    public void addEvent(){
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitPrograme();
            }
        });

        btnTiep.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nhapKhachHangTiepTheo();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doThongKe(danhsach);
            }
        });

        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doTinhTien(editTen.getText().toString(), editSoLuong.getText().toString(), chkVip.isChecked());
            }
        });

    }
}
