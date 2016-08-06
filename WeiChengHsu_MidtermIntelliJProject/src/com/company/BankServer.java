package com.company;

import java.util.Scanner;

/**
 * Created by poc on 8/6/16.
 */
public class BankServer {

    private Scanner sc = new Scanner(System.in);
    private OOValidator validator = new OOValidator(sc);
    private final double MAX_DEPOSIT = 99999999999999.0;

    public void showWelcomeMessage() {
        System.out.println("Welcome to the UserAccount application");
    }

    public void createTransaction(User user) {
        user.userAccount.submitTransaction(
                validator.getChoice("Withdrawal or deposit? (w/d):", new String[]{"w", "d"}),
                validator.getChoice("Checking or savings? (c/s):", new String[]{"c", "s"}),
                validator.getDoubleWithinRange("Amount?", 1, MAX_DEPOSIT)
        );
    }

    public boolean isContinue() {
        String userInput = validator.getChoice("Continue? (y/n):",
                new String[]{"y", "n"});
        if (userInput.trim().substring(0, 1).toLowerCase().equals("y")) {
            return true;
        } else {
            return false;
        }
    }
}

