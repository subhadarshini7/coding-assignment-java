package com.yourname.rewards.dto;

import java.util.List;
import java.util.Map;

public class RewardResponse {

    private Long customerId;
    private String customerName;
    private Map<String, Integer> monthlyRewards;
    private Integer totalRewards;
    private List<TransactionDTO> transactions;

    public void setCustomerId(Long id) { this.customerId = id; }
    public void setCustomerName(String name) { this.customerName = name; }
    public void setMonthlyRewards(Map<String, Integer> m) { this.monthlyRewards = m; }
    public void setTotalRewards(Integer t) { this.totalRewards = t; }
    public void setTransactions(List<TransactionDTO> t) { this.transactions = t; }
}
