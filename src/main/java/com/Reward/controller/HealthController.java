package com.yourname.rewards.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    @GetMapping
    public String healthCheck() {
        return "Service is up and running";
    }
}
