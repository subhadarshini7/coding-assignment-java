package com.yourname.rewards.service;

import com.yourname.rewards.dto.RewardResponse;

import java.time.LocalDate;

public interface RewardService {

    RewardResponse calculateRewards(Long customerId, LocalDate startDate, LocalDate endDate);
}
