package com.yourname.rewards.repository;

import com.yourname.rewards.model.Transaction;
import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository {

    List<Transaction> findByCustomerIdAndDateBetween(
            Long customerId, LocalDate start, LocalDate end);
}
