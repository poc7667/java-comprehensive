package com.company;

public class Main {

    public static void main(String[] args) {
        final String USER_ID = "95035";
        final String USER_NAME = "PocHsu";
        BankServer bankServer = new BankServer();
        Bank bank = new Bank();
        bankServer.showWelcomeMessage();
        bank.addUser(new User(USER_ID, USER_NAME));
        do {
            bankServer.createTransaction(bank.getUser(USER_ID));
        } while (bankServer.isContinue());

        bank.getUser(USER_ID).userAccount.finishTransactions();

    }
}
