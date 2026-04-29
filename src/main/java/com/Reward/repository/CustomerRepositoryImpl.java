package com.yourname.rewards.repository.impl;

import com.yourname.rewards.model.Customer;
import com.yourname.rewards.repository.CustomerRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.of(new Customer(id, "John Doe"));
    }
}
