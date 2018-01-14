package com.barkomkin.recommendations.models;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public Customer findByEmail(String email);
}
