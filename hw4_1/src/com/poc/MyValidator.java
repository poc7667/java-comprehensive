package com.poc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by poc on 7/22/16.
 */
public class MyValidator extends OOValidator {
    protected static Scanner sc = new Scanner(System.in);
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public String getRequiredString(String prompt) {
        System.out.println("Required String Test");
        String userInput="";
        boolean isInvalid = true;
        while (isInvalid){
            System.out.println(prompt);
            userInput = sc.nextLine();
            if(validate(userInput)){
                isInvalid = false;
            }else{
                System.out.println("Error! This entry is required. Try again.");
            }
        }
        return userInput;
    }


    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    public String getChoiceString(String prompt, String s1, String s2) {
        System.out.println("String Choice Test");
        boolean isInvalid=true;
        String userInput = "";
        while(isInvalid){
            System.out.printf("%s (%s/%s):\n", prompt, s1, s2);
            userInput = sc.nextLine().trim();
            if(userInput.equals(s1) || userInput.equals(s2)){
                isInvalid = false;
            }else{
                System.out.printf("Error! This entry Select one (%s/%s)\n", s1, s2);
            }
        }
        return userInput;
    }

    public MyValidator() {
        super(sc);
    }

}
