package com.poc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Scanner;


/**
 * Created by poc on 7/9/16.
 */
public class MonthlyPayment_2_4 {
    static Scanner sc = new Scanner(System.in);
    String  isContinue = "y";
    static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();


    public static void main(String[] args) {
        System.out.println("Welcome to Loan Calculator!");
        doDataEntry();
    }

    static void doDataEntry(){
        BigDecimal loan_amount = getBigDecimalUserInput("Enter Loan Amount:", 0, 1000000);
        BigDecimal yearly_interest_rate = getBigDecimalUserInput("Enter yearly interest rate:", 0, 20);
        int num_of_years = getIntUserInput("Enter # of years:", 0, 100);
        getResult(loan_amount, yearly_interest_rate, num_of_years);
    }

    static BigDecimal getBigDecimalUserInput(String userPrompt, double min, double max){
        do{
            System.out.print(userPrompt);
            if(sc.hasNextBigDecimal()){
                BigDecimal result = sc.nextBigDecimal();
                if(result.doubleValue()>min && result.doubleValue()<max){
                    return result;
                }else{
                    System.out.printf("Invalid input, Range should be %.1f ~ %.1f.\n", min, max);
                }
            }else{
                System.out.println("Invalid input, please try again.");
                sc.nextLine();
            }
        }while(true);
    }

    static int getIntUserInput(String userPrompt, int min, int max){
        do{
            System.out.print(userPrompt);
            if(sc.hasNextInt()){
                int result = sc.nextInt();
                if(result > min && result < max){
                    return result;
                }else{
                    System.out.printf("Invalid input, Range should be %d ~ %d.\n", min, max);
                }
            }else{
                System.out.println("Invalid input, please try again.");
                sc.nextLine();
            }
        }while(true);
    }

    static void getResult(BigDecimal loan_amount, BigDecimal yearly_interest_rate, int num_of_years){
        double rate = (yearly_interest_rate.doubleValue()*100);
        double monthly_rate = yearly_interest_rate.doubleValue()/12;
        int num_of_month = num_of_years*12;
        double monthly_payment = loan_amount.doubleValue() * monthly_rate/(1-1/Math.pow(1+monthly_rate, num_of_month));

        System.out.println("FORMATTED RESULTS");
        System.out.printf("%-10s %-30s\n", "Loan amount:", currencyFormatter.format(loan_amount.doubleValue()));
        System.out.printf("%-10s %-30s\n",
                "yearly interest rate:",
                rate+"%");
        System.out.printf("%-10s %-30s\n", "# of years:", num_of_years);
        System.out.printf("%-10s %-30s\n", "monthly payment:",
                currencyFormatter.format(monthly_payment));

    }


}
