package com.yourname.rewards.repository.impl;

import com.yourname.rewards.model.Transaction;
import com.yourname.rewards.repository.TransactionRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    @Override
    public List<Transaction> findByCustomerIdAndDateBetween(Long customerId,
                                                           LocalDate start,
                                                           LocalDate end) {

        List<Transaction> data = List.of(
                new Transaction(120, LocalDate.now().minusDays(10), customerId),
                new Transaction(75, LocalDate.now().minusDays(20), customerId),
                new Transaction(200, LocalDate.now().minusDays(40), customerId)
        );

        return data.stream()
                .filter(t -> !t.getDate().isBefore(start) && !t.getDate().isAfter(end))
                .toList();
    }
}
