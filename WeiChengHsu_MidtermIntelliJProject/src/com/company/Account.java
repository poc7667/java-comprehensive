package com.company;

/**
 * Created by poc on 8/6/16.
 */
public interface Account {

    public void submitTransaction(String actionType, String accountType, double amount);
    public void getCheckingAccountHistory();
    public void getSavingAccountHistory();
    public double getBalanceOfCheckingAccount();
    public double getBalanceOfSavingAccount();

}
