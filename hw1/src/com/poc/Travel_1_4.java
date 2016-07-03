package com.poc;

import java.util.Scanner;

/**
 * Created by poc on 7/2/16.
 */
public class Travel_1_4 {


    Scanner rd = new Scanner(System.in);
    double miles = -1;
    double mph = -1;
    boolean isKeepGoing = true;

    void getTraveltime(double miles, double mph) {
        int hour;
        double min;
        hour = (int) (miles/mph);
        min =  ((miles%mph)/mph)*60;

        System.out.println("Estimated travel time:");
        System.out.println("hours:"+hour);
        System.out.println("minutes:"+min);

    }

    boolean startProcedure() {
        do {
            System.out.print("Enter miles:");
            miles = rd.nextDouble();
            rd.nextLine();
            System.out.print("Enter miles per hour:");
            mph = rd.nextDouble();
            rd.nextLine();
            getTraveltime(miles, mph);

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
        System.out.println("Welcome to the Travel Time Calculator");
        startProcedure();
    }

//    Welcome to the Travel Time Calculator
//    Enter miles: 200
//    Enter miles per hour: 65
//    Estimated travel time
//    Hours: 3
//    Minutes: 4

}
