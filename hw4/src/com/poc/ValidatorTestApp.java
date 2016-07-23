package com.poc;

/**
 * Created by poc on 7/23/16.
 */
public class ValidatorTestApp {
    public static void main(String[] args) {
        MyValidator myValidator = new MyValidator();
        int intNumber = myValidator.getIntWithinRange("Enter an integer between -100 and 100:", -100, 100);
        double doubleValue = myValidator.getDoubleWithinRange("Enter any number between -100 and 100:", -100, 100);
        myValidator.getChoiceString("Please select one", "x", "y");
        myValidator.getRequiredString("Enter your email address:");
    }
}
