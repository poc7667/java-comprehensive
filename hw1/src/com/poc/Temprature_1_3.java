package com.poc;

import java.util.Scanner;

/**
 * Created by poc on 7/2/16.
 */
public class Temprature_1_3 {

    Scanner rd = new Scanner(System.in);
    int scores = -1;
    char grade = 'Z';
    boolean isKeepGoing = true;

    double getCelcuis(double fah){
        return (fah-32)*5/9;
    }

    boolean startProcedure() {
        do {
            System.out.print("Enter Fahrenheit:");
            System.out.println("Degrees in Celsius:"+getCelcuis(rd.nextFloat()));
            rd.nextLine();
            System.out.print("Continue? (y/n):");
            String userInput = rd.nextLine();
            userInput = userInput.toLowerCase();
            System.out.println(userInput);
            if (userInput.toLowerCase().equals("y")) {
            } else {
                System.out.println("Good bye!");
                return true;
            }

        } while (true);

    }

    public void kick() {
        System.out.println("Welcome to the Temperature Converter");
        startProcedure();
    }
}

//    Welcome to the Temperature Converter
//        Enter degrees in Fahrenheit: 212
//        Degrees in Celsius: 100
//        Continue? (y/n): y
//        Enter degrees in Fahrenheit: 32
//        Degrees in Celsius: 0
//        Continue? (y/n): y
//        Enter degrees in Fahrenheit: 77.5
//        Degrees in Celsius: 25.28
//        Continue? (y/n): n