package com.yourname.rewards.controller;

import com.yourname.rewards.dto.RewardResponse;
import com.yourname.rewards.service.RewardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/rewards")
@Validated
public class RewardController {

    @Autowired
    private RewardService rewardService;

    /**
     * Get rewards for a customer within a date range
     */
    @GetMapping
    public ResponseEntity<RewardResponse> getRewards(
            @RequestParam Long customerId,
            
            @RequestParam 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate startDate,

            @RequestParam 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate endDate) {

        RewardResponse response = rewardService.calculateRewards(customerId, startDate, endDate);
        return ResponseEntity.ok(response);
    }
}
