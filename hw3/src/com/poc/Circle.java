package com.poc;

/**
 * Created by poc on 7/16/16.
 */
public class Circle {
    private double radius;
    final double PI = Math.PI;
    private static int object_count = 0;

    public double getCircumference(){
        return 2*radius*PI;
    }

    public String getFormattedCircumference(double circumference){
        return String.format("%.2f", circumference);
    }


    public double getArea(){
        return radius*radius*PI;
    }

    public int getObjectCount(){
        return object_count;
    }

    public String getFormattedArea(double area){
        return String.format("%.2f", area);
    }

    public Circle(double radius){
        this.radius = radius;
        this.object_count +=1;
    }
}
