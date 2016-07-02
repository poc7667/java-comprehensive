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

    boolean startProcedure() {
        do {

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
