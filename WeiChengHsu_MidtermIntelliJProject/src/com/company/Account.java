package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by poc on 8/6/16.
 */
public
class Account {
    //    https://gist.github.com/binjoo/3963864
    final int MINIMAL_NUM_OF_TRANSACTIONS = 1;
    final double INTERESTING_RATE = 0.01;
    final double CHECKING_FEE = 1;
    final double INIT_DEPOSIT = 1000;

    private  final String SAVING_ACTION = "Saving";
    private  final String WITHDRAW_ACTION = "Withdraw";
    private final String CHECKING_ACCOUNT = "c";
    private final String SAVING_ACCOUNT = "s";
    private User owner;

    ArrayList<Transaction> checkingTransactions = new ArrayList<Transaction>(MINIMAL_NUM_OF_TRANSACTIONS);
    ArrayList<Transaction> savingTransactions = new ArrayList<Transaction>(MINIMAL_NUM_OF_TRANSACTIONS);

    public Account(User user) {
        checkingTransactions.add(new Transaction("Init deposit", INIT_DEPOSIT));
        savingTransactions.add(new Transaction("Init deposit", INIT_DEPOSIT));
        owner = user;
    }

    public void submitTransaction(String actionType, String accountType, double amount) {
        String actionName = SAVING_ACTION;
        if (actionType.equals("w")) {
            actionName = WITHDRAW_ACTION;
        }
        doTransaction(actionName, accountType, amount);
    }

    private boolean doTransaction(String actionName,String accountType, double amount){
        boolean status = true;
        switch (actionName){
            case SAVING_ACTION:
                if(accountType.equals(CHECKING_ACCOUNT)){
                    checkingTransactions.add(new Transaction(actionName, amount));
                }else if(accountType.equals(SAVING_ACCOUNT)){
                    savingTransactions.add(new Transaction(actionName, amount));
                }else{
                    // should raise exception
                }
                break;
            case WITHDRAW_ACTION:
                if(accountType.equals(CHECKING_ACCOUNT)){
                    if(amount <= getBalanceOfCheckingAccount()){
                        checkingTransactions.add(new Transaction(actionName, -1*amount));
                    }else{
                        checkingTransactions.add(new Transaction("Level lower than:"+amount, 0));
                        status = false;
                    }

                }else if(accountType.equals(SAVING_ACCOUNT)){
                    if(amount <= getBalanceOfSavingAccount()){
                        checkingTransactions.add(new Transaction(actionName, -1*amount));
                    }else{
                        checkingTransactions.add(new Transaction("Level lower than:"+amount, 0));
                        status = false;
                    }
                }else{
                    // should raise exception
                }
                break;
        }
        return status;
    }

    public double getBalanceOfCheckingAccount() {
        double balance = 0;
        for (Transaction t : checkingTransactions) {
            balance += t.amount.doubleValue();
        }
        return balance;
    }

    public void getCheckingAccountHistory() {
        System.out.println("\n============CheckingAccountHistory============");
        checkingTransactions.forEach(transaction ->
                System.out.println(transaction));
    }

    public void getSavingAccountHistory() {
        System.out.println("\n============SavingAccountHistory============");
        savingTransactions.forEach(transaction ->
                System.out.println(transaction));
    }

    public double getBalanceOfSavingAccount() {
        double balance = 0;
        for (Transaction t : savingTransactions) {
            balance += t.amount.doubleValue();
        }
        return balance;
    }

    private double getInterestingRate() {
        return getBalanceOfSavingAccount() * INTERESTING_RATE;
    }

    public void finishThisMonthTransaction() {
        DecimalFormat currency = new DecimalFormat("$0.00");
        checkingTransactions.add(new Transaction("Checking fee", -1 * CHECKING_FEE));
        savingTransactions.add(new Transaction("Interest Rate", getInterestingRate()));
        System.out.println("\nMonthly Payments and Fees");
        System.out.printf("%-27s","Checking fee:");
        System.out.printf("%-20s", currency.format(CHECKING_FEE));
        System.out.printf("\n%-27s","Savings interest payment:");
        System.out.printf("%-20s%n", currency.format(getInterestingRate()));
        System.out.printf("\nFinal Balances");
        System.out.printf("\n%-10s","Checking:");
        System.out.printf("%-20s", currency.format(getBalanceOfCheckingAccount()));
        System.out.printf("\n%-10s","Saving:");
        System.out.printf("%-20s", currency.format(getBalanceOfSavingAccount()));
        System.out.printf("\n");
    }

    public void finishTransactions(){
        finishThisMonthTransaction();
        getCheckingAccountHistory();
        getSavingAccountHistory();
    }
}

