package com.example.nthanh.tonghoplistview;

/**
 * Created by nthanh on 19/01/2016.
 */
public class KhachHang {
    private String tenKhachHang;
    private int soLuongMua;
    private boolean isKhachVip;
    public static final int GIA = 20000;

    //contructor
    public KhachHang(){
    }

    public KhachHang(String tenKhachHang, int soLuongMua, boolean isKhachVip){
        this.setTenKhachHang(tenKhachHang);
        this.setSoLuongMua(soLuongMua);
        this.setIsKhachVip(isKhachVip);
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public boolean isKhachVip() {
        return isKhachVip;
    }

    public void setIsKhachVip(boolean isKhachVip) {
        this.isKhachVip = isKhachVip;
    }

    public double thanhTien(){
        //neu khong phai la khach vip thi slmua * don gia
        //La khach vip thi giam 10%;
        return (!isKhachVip? soLuongMua*GIA:soLuongMua*GIA*0.9);
    }
}
