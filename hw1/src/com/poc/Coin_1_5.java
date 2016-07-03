package com.poc;

import java.util.Scanner;

/**
 * Created by poc on 7/2/16.
 */
public class Coin_1_5 {

    Scanner rd = new Scanner(System.in);
    private static final int NICKEL = 5;
    private static final int DIME = 10;
    private static final int QUARTER = 25;
    boolean isKeepGoing = true;

    void getCoins(int amount) {
        int quarter = 0;
        int dime = 0;
        int nickel = 0;

        quarter = amount / QUARTER;
        if (quarter > 0) {
            amount -= (quarter * QUARTER);
        }
        dime = amount / DIME;
        if (dime > 0) {
            amount -= (dime * DIME);
        }
        nickel = amount / NICKEL;
        if (nickel > 0) {
            amount -= (nickel * NICKEL);
        }
        System.out.println("Quarters:" + quarter);
        System.out.println("Dimes:" + dime);
        System.out.println("Nickels:" + nickel);
        System.out.println("Pennies:" + amount);

    }

//A nickel is 5% of 100 cents = 1 dollar, hence it is 5 cents.
//A dime is 10% of 100 cents = 1 dollar, hence it is 10 cents.
//A quarter is 25% of 100 cents, hence it is 25 cents.


    boolean startProcedure() {
        do {
            System.out.print("Enter number of cents (0-99):");
            getCoins(rd.nextInt());
            rd.nextLine(); // eats the newline

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

}

