package com.poc;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by poc on 7/8/16.
 */
public class Interest_2_1 {


    static BigDecimal amount = new BigDecimal(0.0);
    static BigDecimal rate = new BigDecimal(0.0);
    static Scanner sc = new Scanner(System.in);
    static BigDecimal percent_normalized_factor = new BigDecimal(100);
    static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        String isContinue = "y";
        showWelcomePrompt();
        do {
            getUserInput();
            System.out.printf("continue? (y/n)");
            sc.nextLine(); // eats new line
            isContinue = sc.nextLine().trim();
        } while (isContinue.compareToIgnoreCase("y") == 0);

        System.out.printf("\nC u again!");

    }

    public static void showWelcomePrompt() {
        System.out.println("welcome to the interest calculator");
    }

    public static void getUserInput() {
        System.out.printf("enter loan amount:");
        amount = sc.nextBigDecimal();
        System.out.printf("enter rate:");
        rate = sc.nextBigDecimal();
        calculateRate();
    }

    public static void calculateRate() {
        System.out.println("Loan amount: "+ currencyFormatter.format(amount));
        System.out.println("Interest Rate: "+ String.format("%.3f", percent_normalized_factor.multiply(rate)) +"%");
        System.out.println("Interest: "+currencyFormatter.format(amount.multiply(rate)));
    }
}
