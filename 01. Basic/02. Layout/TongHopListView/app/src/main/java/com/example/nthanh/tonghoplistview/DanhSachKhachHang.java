package com.example.nthanh.tonghoplistview;

import java.util.ArrayList;

/**
 * Created by nthanh on 19/01/2016.
 */
public class DanhSachKhachHang {
    ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();

    //add khach hang
    public void themKhachHang(KhachHang kh){
        this.dsKhachHang.add(kh);
    }

    //Tinh tong doanh thu cua danh sach khach hang
    public double tongDoanhThu(){
        double tien = 0.0;
        for (KhachHang kh:dsKhachHang){
            tien +=kh.thanhTien();
        }
        return  tien;
    }

    //dem so luong khach hang
    public int soLuongKhachHang(){
        return dsKhachHang.size();
    }

    public int soLuongKhachVip(){
        int sl = 0;
        for (KhachHang kh:dsKhachHang){
            if (kh.isKhachVip()){
                sl ++;
            }
        }
        return sl;
    }
}
