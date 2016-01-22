package com.example.nthanh.vidu_listview_arraylist_object;

/**
 * Created by nthanh on 22/01/2016.
 */
public abstract class Employee {
    private String maNhanVien;
    private String tenNhanVien;

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public Employee(){

    }
    public Employee(String maNhanVien, String tenNhanVien){
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
    }

    public abstract double TinhLuong();

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.maNhanVien+" - "+this.tenNhanVien;
    }
}
