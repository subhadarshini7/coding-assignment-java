package com.yourname.rewards.service.impl;

import com.yourname.rewards.model.Customer;
import com.yourname.rewards.repository.CustomerRepository;
import com.yourname.rewards.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
