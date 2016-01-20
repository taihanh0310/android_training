package com.example.nthanh.customlistview;

/**
 * Created by nthanh on 19/01/2016.
 */
public class Employee {
    private String id;
    private String name;
    private boolean gender;

    @Override
    public String toString() {
        return this.getId() + " - " + this.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
