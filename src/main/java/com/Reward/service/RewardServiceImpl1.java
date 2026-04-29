package com.yourname.rewards.service.impl;

import com.yourname.rewards.dto.RewardResponse;
import com.yourname.rewards.dto.TransactionDTO;
import com.yourname.rewards.model.Customer;
import com.yourname.rewards.model.Transaction;
import com.yourname.rewards.repository.TransactionRepository;
import com.yourname.rewards.service.CustomerService;
import com.yourname.rewards.service.RewardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public RewardResponse calculateRewards(Long customerId, LocalDate startDate, LocalDate endDate) {

        Customer customer = customerService.getCustomerById(customerId);

        List<Transaction> transactions = transactionRepository
                .findByCustomerIdAndDateBetween(customerId, startDate, endDate);

        Map<String, Integer> monthlyRewards = new HashMap<>();
        int totalRewards = 0;

        List<TransactionDTO> transactionDTOList = new ArrayList<>();

        for (Transaction txn : transactions) {

            int points = calculatePoints(txn.getAmount());

            String month = txn.getDate().getMonth().toString();

            monthlyRewards.put(month,
                    monthlyRewards.getOrDefault(month, 0) + points);

            totalRewards += points;

            transactionDTOList.add(new TransactionDTO(
                    txn.getAmount(),
                    txn.getDate(),
                    points
            ));
        }

        RewardResponse response = new RewardResponse();
        response.setCustomerId(customer.getId());
        response.setCustomerName(customer.getName());
        response.setMonthlyRewards(monthlyRewards);
        response.setTotalRewards(totalRewards);
        response.setTransactions(transactionDTOList);

        return response;
    }

    /**
     * Reward calculation logic
     */
    private int calculatePoints(double amount) {

        int points = 0;

        if (amount > 100) {
            points += (int) ((amount - 100) * 2);
            points += 50;
        } else if (amount > 50) {
            points += (int) (amount - 50);
        }

        return points;
    }
}
