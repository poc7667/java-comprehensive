package com.poc;

import java.util.Scanner;

/**
 * Created by poc on 7/16/16.
 */
public class CircleApp_1_1 extends HomeWorkWrapper{

    private Scanner rd = new Scanner(System.in);
    private double radius;

    public CircleApp_1_1(){

    }



    public void execute(){
        System.out.println("This is circle App");
        radius = Validator.getDouble(rd, "Enter radius:");
        Circle circle = new Circle(radius);
        System.out.printf("Circumference: %s\n", circle.getFormattedCircumference(circle.getCircumference()));
        System.out.printf("Area: %s\n", circle.getFormattedArea(circle.getArea()));
        System.out.printf("Object count: %d\n", circle.getObjectCount());
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        CircleApp_1_1 this_instance = new CircleApp_1_1();
        worker.doIt(this_instance);
    }
}
