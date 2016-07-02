package com.poc;

import java.util.Scanner;

/**
 * Created by poc on 7/1/16.
 */
public class Grade_1_2 {
    Scanner rd = new Scanner(System.in);
    int scores = -1;
    char grade = 'Z';
    boolean isKeepGoing = true;

    boolean startProcedure() {
        do {
            System.out.print("Enter numerical grade:");
            System.out.println(getGrade(rd.nextInt()));
            System.out.print("Continue? (y/n)");
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
        System.out.println("Welcome to the Letter Grade Converter");
        startProcedure();
    }

    char getGrade(int scores) {
        rd.nextLine(); // eats the newline
        if (scores < 60) {
            return 'F';
        } else if (scores <= 67) {
            return 'D';
        } else if (scores <= 79) {
            return 'C';
        } else if (scores <= 87) {
            return 'B';
        } else if (scores <= 100) {
            return 'A';
        } else {
            return 'Z';
        }
    }

}

