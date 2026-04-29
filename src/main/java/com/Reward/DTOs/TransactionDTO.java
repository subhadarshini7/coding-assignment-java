package com.yourname.rewards.dto;

import java.time.LocalDate;

public class TransactionDTO {

    private double amount;
    private LocalDate date;
    private int points;

    public TransactionDTO(double amount, LocalDate date, int points) {
        this.amount = amount;
        this.date = date;
        this.points = points;
    }
}
