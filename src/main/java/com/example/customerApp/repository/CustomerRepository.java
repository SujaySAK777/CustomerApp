package com.example.customerApp.repository;

import com.example.customerApp.model.Customer;
import com.example.customerApp.RowMapper.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomers(){
        String sql = "SELECT customer_id, customer_name, customer_email, customer_mobile FROM customer";
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }

    public void addCustomer(Customer customer){
        String sql = "INSERT INTO customer (customer_id, customer_name, customer_email, customer_mobile) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerEmail(), customer.getCustomerMobile());
    }

    public void updateCustomer(Integer customerId, Customer customer){
        String sql = "UPDATE customer SET customer_name = ?, customer_email = ?, customer_mobile = ? WHERE customer_id = ?";
        jdbcTemplate.update(sql, customer.getCustomerName(), customer.getCustomerEmail(), customer.getCustomerMobile(), customerId);
    }
    public void deleteCustomer(Integer customerId){
        String sql = "DELETE FROM customer WHERE customer_id = ?";
        jdbcTemplate.update(sql, customerId);
    }
    public Customer getCustomerById(Integer customerId) {
        String sql = "SELECT customer_id, customer_name, customer_email, customer_mobile FROM customer WHERE customer_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{customerId}, new CustomerRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}