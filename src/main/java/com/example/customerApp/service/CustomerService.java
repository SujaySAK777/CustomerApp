package com.example.customerApp.service;

import com.example.customerApp.model.Customer;
import com.example.customerApp.repository.CustomerRepository;
import com.example.customerApp.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers(){
        return customerRepository.getAllCustomers();
    }

    public void addCustomer(Customer customer){
        customerRepository.addCustomer(customer);
    }
    public void updateCustomer(Integer customerId, Customer customer){
        customerRepository.updateCustomer(customerId, customer);
    }
    public void deleteCustomer(Integer customerId){
        customerRepository.deleteCustomer(customerId);
    }
    public Customer getCustomerById(Integer customerId) {
        Customer customer = customerRepository.getCustomerById(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
        }
        return customer;
    }
    
}
