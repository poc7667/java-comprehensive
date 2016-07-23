package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by poc on 7/22/16.
 */
public class Validator {
    private Scanner sc;

    public Validator(Scanner sc) {
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

    public double getDouble(String prompt) {
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

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public String getEmailAddress(String prompt){
        boolean isValid = false;
        String emailStr = "";
        while(!isValid){
            System.out.printf(prompt+":");
            emailStr = sc.nextLine().trim();
            if(isValidEmail(emailStr)){
                isValid =true;
            }
        }
        return emailStr;
    }

    public boolean isValidEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public String getChoiceString(String prompt, String s1, String s2) {
        boolean isInvalid = true;
        String userInput = "";
        while (isInvalid) {
            System.out.printf("%s (%s/%s):", prompt, s1, s2);
            userInput = sc.nextLine().trim();
            if (userInput.equals(s1) || userInput.equals(s2)) {
                isInvalid = false;
            } else {
                System.out.printf("Error! This entry Select one (%s/%s)\n", s1, s2);
            }
        }
        return userInput;
    }

    public String getRequiredString(String prompt) {
        System.out.printf("%s:", prompt);
        boolean isInvalid = true;
        String userInput = "";
        while (isInvalid) {
            userInput = sc.nextLine().trim();
            if (userInput instanceof String && userInput.length() > 0) {
                isInvalid = false;
            } else {
                System.out.printf("Sorry, it's not a valid value");
            }
        }
        return userInput;
    }
}