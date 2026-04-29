package com.yourname.rewards.service.impl;

import com.yourname.rewards.dto.*;
import com.yourname.rewards.model.*;
import com.yourname.rewards.repository.*;
import com.yourname.rewards.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public RewardResponse calculateRewards(Long customerId, LocalDate startDate, LocalDate endDate) {

        Customer customer = customerService.getCustomerById(customerId);

        List<Transaction> transactions =
                transactionRepository.findByCustomerIdAndDateBetween(customerId, startDate, endDate);

        Map<String, Integer> monthlyRewards = new HashMap<>();
        int total = 0;

        List<TransactionDTO> dtoList = new ArrayList<>();

        for (Transaction t : transactions) {

            int points = calculatePoints(t.getAmount());

            String month = t.getDate().getMonth().toString();

            monthlyRewards.put(month,
                    monthlyRewards.getOrDefault(month, 0) + points);

            total += points;

            dtoList.add(new TransactionDTO(t.getAmount(), t.getDate(), points));
        }

        RewardResponse response = new RewardResponse();
        response.setCustomerId(customer.getId());
        response.setCustomerName(customer.getName());
        response.setMonthlyRewards(monthlyRewards);
        response.setTotalRewards(total);
        response.setTransactions(dtoList);

        return response;
    }

    private int calculatePoints(double amount) {

        if (amount > 100) {
            return (int) ((amount - 100) * 2 + 50);
        } else if (amount > 50) {
            return (int) (amount - 50);
        }
        return 0;
    }
}
