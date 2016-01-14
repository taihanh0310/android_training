package com.example.nthanh.ptbac2;

/**
 * Created by nthanh on 14/01/2016.
 */
public class Calculator {

    private double soA;
    private double soB;

    double add(double a, double b) {
        double answer = a+b;
        return answer;
    }

    double subtract(double a, double b) {
        double answer = a-b;
        return answer;
    }

    double multiply(double a, double b) {
        double answer = a*b;
        return answer;
    }

    double divide(double a, double b) {
        double answer = a/b;
        return answer;
    }

    double power(double a, double b){
        double answer =a;

        for (int x=2; x<=b; x++){
            answer *= a;
        }

        return answer;
    }

    public double getSoA() {
        return soA;
    }

    public void setSoA(double soA) {
        this.soA = soA;
    }

    public double getSoB() {
        return soB;
    }

    public void setSoB(double soB) {
        this.soB = soB;
    }
}
