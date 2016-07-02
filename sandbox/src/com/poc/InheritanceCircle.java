package com.poc;

/**
 * Created by poc on 7/1/16.
 */
public class InheritanceCircle {

    final double PI = 3.14159;
    double area = 0;

    public double getArea(int r){
        area = r*r*PI;
        System.out.println("Area is = "+ area);
        return area;
    }
}
