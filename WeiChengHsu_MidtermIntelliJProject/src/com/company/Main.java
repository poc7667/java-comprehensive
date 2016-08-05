package com.company;

import com.sun.deploy.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

class Transaction {
    String eventName;
    BigDecimal amount;
    LocalDateTime created_at;


    public Transaction(String eventName, double amount) {
        this.eventName = eventName;
        this.amount = new BigDecimal(amount);
        this.created_at = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("%-15s: $ %10.2f, time:%-20s\n",
                this.eventName,
                this.amount.doubleValue(),
                this.created_at
        );
    }
}

class Account {
    //    https://gist.github.com/binjoo/3963864
    final int MINIMAL_NUM_OF_TRANSACTIONS = 1;
    final double INTERESTING_RATE = 0.01;
    final double CHECKING_FEE = 1;
    ArrayList<Transaction> checkingTransactions = new ArrayList<Transaction>(MINIMAL_NUM_OF_TRANSACTIONS);
    ArrayList<Transaction> savingTransactions = new ArrayList<Transaction>(MINIMAL_NUM_OF_TRANSACTIONS);

    public Account() {
        checkingTransactions.add(new Transaction("init deposit", 1000));
        savingTransactions.add(new Transaction("init deposit", 1000));
    }

    public void doTransaction(String actionType, String accountType, double amount) {
        String actionName = "Saving";
        if (actionType.equals("w")) {
            amount *= -1;
            actionName = "Withdraw";
        }
        if (accountType.equals("c")) {
            checkingTransactions.add(new Transaction(actionName, amount));
        } else {
            savingTransactions.add(new Transaction(actionName, amount));
        }
    }


    public double getBalanceOfCheckingAccount() {
        double balance = 0;
        for (Transaction t : checkingTransactions) {
            balance += t.amount.doubleValue();
        }
        return balance;
    }

    public void getCheckingAccountHistory() {
        System.out.println("\n===CheckingAccountHistory===");
        checkingTransactions.forEach(transaction ->
                System.out.println(transaction));
    }

    public void getSavingAccountHistory() {
        System.out.println("\n===SavingAccountHistory===");
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
        checkingTransactions.add(new Transaction("Checking fee", -1 * CHECKING_FEE));
        savingTransactions.add(new Transaction("Interest Rate:", getInterestingRate()));
        System.out.printf("Monthly Payments and Fees Checking fee: $ %.2f, Savings interest payment: $%.2f\n",
                CHECKING_FEE,
                getInterestingRate());
        System.out.printf("Final Balances Checking: $%.2f Saving: $%.2f",
                getBalanceOfCheckingAccount(),
                getBalanceOfSavingAccount());
    }

}

class User {

    String userId;
    String name;
    Account account = new Account();

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        List<String> toks = Arrays.asList(super.toString(), this.userId, this.name);
        return StringUtils.join(toks, ":");
    }

}

class Bank {

    private Map<String, User> users = new HashMap<String, User>();

    void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    User getUser(String userId) {
        return users.get(userId);
    }
}

class Server {

    private Scanner sc = new Scanner(System.in);
    private String isKeepingContinue = "y";

    public void showWelcomeMessage() {
        System.out.println("Welcome to the Account application");
    }

    public void createATransaction(User user) {
        System.out.print("Withdrawal or deposit? (w/d):");
        String action = sc.nextLine();
        System.out.print("Checking or savings? (c/s):");
        String accountType = sc.nextLine();
        System.out.print("Amount?");
        double amount = Double.parseDouble(sc.nextLine());
        user.account.doTransaction(action, accountType, amount);
    }

    public boolean isContinue() {
        System.out.print("Continue? (y/n):");
        String userInput = sc.nextLine();
        if (userInput.trim().substring(0, 1).toLowerCase().equals("y")) {
            return true;
        } else {
            return false;
        }
    }
}


public class Main {

    public static void main(String[] args) {
        // write your code here
        Server server = new Server();
        Bank bank = new Bank();
        server.showWelcomeMessage();
        User user = new User("95035", "Poc");
        bank.addUser(user);
        do {
            server.createATransaction(user);
        } while (server.isContinue());
        user.account.finishThisMonthTransaction();
        user.account.getCheckingAccountHistory();
        user.account.getSavingAccountHistory();


    }
}
