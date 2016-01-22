package com.example.nthanh.vidu_listview_arraylist_object;

/**
 * Created by nthanh on 22/01/2016.
 */
public class EmployeePartTime extends Employee {

    @Override
    public double TinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + " --> part time: " + TinhLuong();
    }
}
