package com.yourname.rewards.model;

import java.time.LocalDate;

public class Transaction {

    private double amount;
    private LocalDate date;
    private Long customerId;

    public Transaction(double amount, LocalDate date, Long customerId) {
        this.amount = amount;
        this.date = date;
        this.customerId = customerId;
    }

    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
}
