package com.company;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by poc on 8/6/16.
 */
public class Transaction {
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
        return String.format("%-30s $%-15.2f | transaction time:%-20s",
                this.eventName,
                this.amount.doubleValue(),
                this.created_at
        );
    }
}
