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

        Welcome to the Account application
        Withdrawal or deposit? (w/d):w
        Checking or savings? (c/s):s
        Amount?101
        Continue? (y/n):y
        Withdrawal or deposit? (w/d):d
        Checking or savings? (c/s):c
        Amount?3434312
        Continue? (y/n):y
        Withdrawal or deposit? (w/d):d
        Checking or savings? (c/s):s
        Amount?2314
        Continue? (y/n):n

        Monthly Payments and Fees
        Checking fee:              $1.00               
        Savings interest payment:  $33.47              

        Final Balances
        Checking: $3435210.00         
        Saving:   $3347.14            

        ============CheckingAccountHistory============
        Init deposit                   $1000.00         | transaction time:2016-08-06T13:39:09.156
        Withdraw                       $-101.00         | transaction time:2016-08-06T13:39:13.367
        Saving                         $3434312.00      | transaction time:2016-08-06T13:39:19.038
        Checking fee                   $-1.00           | transaction time:2016-08-06T13:39:27.246

        ============SavingAccountHistory============
        Init deposit                   $1000.00         | transaction time:2016-08-06T13:39:09.246
        Saving                         $2314.00         | transaction time:2016-08-06T13:39:26.384
        Interest Rate                  $33.14           | transaction time:2016-08-06T13:39:27.246
