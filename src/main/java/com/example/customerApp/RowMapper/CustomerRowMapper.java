package com.example.customerApp.RowMapper;

import com.example.customerApp.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();

        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setCustomerName(rs.getString("customer_name"));
        customer.setCustomerEmail(rs.getString("customer_email"));
        customer.setCustomerMobile(rs.getString("customer_mobile"));

        return customer;
    }
}