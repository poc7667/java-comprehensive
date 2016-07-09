package com.poc;

import java.util.Scanner;

/**
 * Created by poc on 7/9/16.
 */
public class TempratureWithValidation_2_3 {
    Scanner rd = new Scanner(System.in);
    boolean isKeepGoing = true;

    double getCelcuis(double fah){
        return (fah-32)*5/9;
    }

    boolean startProcedure() {
        do {
            float fahrenheit = getFahrenheitDegree();
            System.out.println("Degrees in Celsius:"+getCelcuis(fahrenheit));
            rd.nextLine();
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

    float getFahrenheitDegree(){
        do{
            System.out.print("Enter Fahrenheit:");
            if(rd.hasNextFloat()){
                return rd.nextFloat();
            }else{
                rd.nextLine();
            }
        }while(true);
    }

    public void kick() {
        System.out.println("Welcome to the Temperature Converter");
        startProcedure();
    }

    public static void main(String[] args) {
        TempratureWithValidation_2_3 go = new TempratureWithValidation_2_3();
        go.kick();
    }
}
