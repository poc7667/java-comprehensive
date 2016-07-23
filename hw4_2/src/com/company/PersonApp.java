package com.company;

import java.util.Scanner;

/**
 * Created by poc on 7/23/16.
 */
public class PersonApp {
    private Scanner sc = new Scanner(System.in);
    private Validator chk = new Validator(sc);
    private String userChoice = "";

    public void execute() {
        System.out.println("Welcome to the Person Tester application");
        while (true){
            userChoice = chk.getChoiceString("Create customer or employee?", "c", "e");
            if (userChoice.equals("c")) {
                createCustomer();
            } else if (userChoice.equals("e")) {
                createEmployee();
            }
            if(chk.getChoiceString("Continue?", "y", "n").equals("n")){
                break;
            }
        }
        System.out.println("See you later!");
    }



    private void createCustomer() {
        Customer customer = new Customer();
        customer.setFirstName(chk.getRequiredString("Enter first name"));
        customer.setLastName(chk.getRequiredString("Enter last name"));
        customer.setEmail(chk.getEmailAddress("Enter email address"));
        customer.setCustomerNumber(chk.getRequiredString("Enter customer number"));
        showResult(customer);
    }

    private void createEmployee() {
        Employee ee = new Employee();
        ee.setFirstName(chk.getRequiredString("Enter first name"));
        ee.setLastName(chk.getRequiredString("Enter last name"));
        ee.setEmail(chk.getEmailAddress("Enter email address"));
        ee.setSocialSecurityNumber(chk.getRequiredString("Enter SSN"));
        showResult(ee);
    }

    static private void showResult(Person p){
        System.out.printf("You entered!");
        System.out.println(p.getDisplayText());
    }


    public static void main(String[] args) {
        PersonApp app = new PersonApp();
        app.execute();
    }
}
