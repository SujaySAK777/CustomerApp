package com.example.customerApp;

import com.example.customerApp.model.Customer;
import com.example.customerApp.repository.CustomerRepository;
import com.example.customerApp.service.CustomerService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Test
    void testGetCustomerById_withoutSpring() throws Exception {
        CustomerService service = new CustomerService();

        CustomerRepository repo = new CustomerRepository() {
            @Override
            public Customer getCustomerById(Integer customerId) {
                if (customerId != null && customerId.equals(1)) {
                    return new Customer(1, "Alice", "a@e.com", "9000000000");
                }
                return null;
            }
        };

        Field f = CustomerService.class.getDeclaredField("customerRepository");
        f.setAccessible(true);
        f.set(service, repo);

        Customer customer = service.getCustomerById(1);
        assertNotNull(customer);
        assertEquals(Integer.valueOf(1), customer.getCustomerId());
        assertEquals("Alice", customer.getCustomerName());
    }
}