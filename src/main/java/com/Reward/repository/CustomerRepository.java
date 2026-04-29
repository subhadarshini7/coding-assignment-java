package com.yourname.rewards.repository;

import com.yourname.rewards.model.Customer;
import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(Long id);
}
