package com.poc;

import java.util.Scanner;

/**
 * Created by poc on 7/22/16.
 */
public class OOValidator {
    private Scanner sc;

//    public OOValidator(){
//
//    }
    public OOValidator(Scanner sc) {
        this.sc = sc;
    }

    public int getInt(String prompt) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public int getIntWithinRange(String prompt,
                                 int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = this.getInt(prompt);
            if (i <= min)
                System.out.println(
                        "Error! Number must be greater than " + min);
            else if (i >= max)
                System.out.println(
                        "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return i;
    }

    public  double getDouble(String prompt) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public double getDoubleWithinRange(String prompt,
                                              double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            d = getDouble(prompt);
            if (d <= min)
                System.out.println(
                        "Error! Number must be greater than " + min);
            else if (d >= max)
                System.out.println(
                        "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return d;
    }
}
