package com.poc;

import java.util.Scanner;

/**
 * Created by poc on 7/9/16.
 */
public class TableOfPower_2_2 {
    static Scanner rd = new Scanner(System.in);
    static int power_of_number = 0;
    public static void main(String[] args) {
        String isContinue = "y";
        do{
            System.out.printf("Enter an integer:");
            showTableOfPower(rd.nextInt());
            System.out.printf("continue? (y/n)");
            rd.nextLine(); // eats new line
            isContinue = rd.nextLine().trim();
        }while (isContinue.compareToIgnoreCase("y") == 0);
    }

    public static void showTableOfPower(int power_of_number) {
        System.out.printf("%-10s %-10s %-10s\n", "Number", "Squared", "Cubed");
        System.out.printf("%-10s %-10s %-10s\n", "======", "======", "======");
        for(int i=1;i<=power_of_number;i++){
            System.out.printf("%-10d %-10.0f %-10.0f\n",
                    i,
                    Math.pow(i, 2),
                    Math.pow(i, 3));

        }
    }
}
