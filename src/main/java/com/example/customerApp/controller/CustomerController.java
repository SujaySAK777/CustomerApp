package com.example.customerApp.controller;

import com.example.customerApp.model.Customer;
import com.example.customerApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> customer() {
        return customerService.getCustomers();
    }

    @PostMapping("/customers")
    public String addCustomer(@RequestBody Customer customer) {
        //TODO: process POST request
        customerService.addCustomer(customer);
        return "Customer Registered successfully";
    }
    
    @PutMapping("/customers/{customerId}")
    public String updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer customer) {
        customerService.updateCustomer(customerId, customer);
        return "Customer updated successfully";
    }

    @PutMapping("/customers")
    public String updateCustomerByBody(@RequestBody Customer customer) {
        customerService.updateCustomer(customer.getCustomerId(), customer);
        return "Customer updated successfully";
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Integer customerId) {
        customerService.deleteCustomer(customerId);
        return "Customer deleted successfully";
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") Integer customerId) {
        return customerService.getCustomerById(customerId);
    }
}