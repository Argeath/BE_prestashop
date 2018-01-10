package com.barkomkin.recommendations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/fake-rating")
    public @ResponseBody String addCustomers() {
        Customer c = new Customer("Test", "Testowy", "test2@barkomkin.pl");

        customerRepository.save(c);

        return "created";
    }

    @GetMapping("/customers")
    public @ResponseBody Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
