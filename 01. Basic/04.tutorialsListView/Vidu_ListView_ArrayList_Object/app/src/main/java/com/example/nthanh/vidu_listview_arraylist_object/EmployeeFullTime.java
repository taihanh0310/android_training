package com.example.nthanh.vidu_listview_arraylist_object;

/**
 * Created by nthanh on 22/01/2016.
 */
public class EmployeeFullTime extends Employee {
    @Override
    public double TinhLuong() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString() + " --> Fulltime = " + TinhLuong();
    }
}
