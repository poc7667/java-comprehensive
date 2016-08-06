# How to execute this project

cd `WeiChengHsu_MidtermIntelliJProject/out/production/WeiChengHsu_MidtermIntelliJProject`

Run `java com.company.Main`

![inline](https://i.imgur.com/1nveTsZ.png=300x "Title")

# Feature

- Good design and readable OOP code
- Using Collection: Hash, ArrayList, Set
- Can tracking every transactions
- Can avoid withdraw too much money
- Can validate user input data
- Can be used for multiple users

# DEMO

    ➜  WeiChengHsu_MidtermIntelliJProject git:(master) ✗ java com.company.Main  
    Welcome to the UserAccount application
    Withdrawal or deposit? (w/d):w
    Checking or savings? (c/s):c
    Amount?fdsdj
    Error! Invalid decimal value. Try again.
    Amount?2312312
    Error! Not enough deposit, please withdraw with a smaller amount
    Continue? (y/n):y
    Withdrawal or deposit? (w/d):w
    Checking or savings? (c/s):c
    Amount?21
    Continue? (y/n):y
    Withdrawal or deposit? (w/d):d
    Checking or savings? (c/s):123412
    Error! Choice. Try again.
    Checking or savings? (c/s):s
    Amount?414343
    Continue? (y/n):n

    Monthly Payments and Fees
    Checking fee:              $1.00
    Savings interest payment:  $4194.96

    Final Balances
    Checking: $978.00
    Saving:   $419496.43

    ============CheckingAccountHistory============
    Init deposit                   $1000.00         | transaction time:2016-08-06T13:55:36.545
    Level lower than:2312312.0     $0.00            | transaction time:2016-08-06T13:55:43.625
    Withdraw                       $-21.00          | transaction time:2016-08-06T13:55:51.831
    Checking fee                   $-1.00           | transaction time:2016-08-06T13:56:04.766

    ============SavingAccountHistory============
    Init deposit                   $1000.00         | transaction time:2016-08-06T13:55:36.602
    Saving                         $414343.00       | transaction time:2016-08-06T13:56:02.526
    Interest Rate                  $4153.43         | transaction time:2016-08-06T13:56:04.766