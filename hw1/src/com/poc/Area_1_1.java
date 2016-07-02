package com.poc;

import java.util.Scanner;

/**
 * Created by poc on 7/1/16.
 */
public class Area_1_1 {

    Scanner rd = new Scanner(System.in);
    int length = 0;
    int width = 0;
    int area = 0;
    int perimeter = 0;


    public void  getArea(){
        System.out.println("area:"+width*length);
    }

    public  void getPerimeter(){
        System.out.println("perimeter:"+2*(width+length));
    }


    public void startProcedure() {
        System.out.println("Welcome to the Area and Perimeter Calculator");
        System.out.print("Enter length:");
        length = rd.nextInt();
        System.out.print("Enter width:");
        width = rd.nextInt();
        getArea();
        getPerimeter();
    }

    public void start(){

        Scanner keyboard = new Scanner(System.in);
        boolean isKeepGoing = true;
        do {
            startProcedure();
            System.out.print("Continue? (y/n):");
            String userOption = keyboard.nextLine();
            if (userOption.toLowerCase().equals("y")){
                isKeepGoing = true;
            }else{
                isKeepGoing = false;
            }
        } while (isKeepGoing);

        System.out.println("good bye , have a good day!");
    }


}
