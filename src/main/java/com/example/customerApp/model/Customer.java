package com.example.customerApp.model;

public class Customer {
    private Integer customerId;
    private String customerName;
    private String customerEmail;
    private String customerMobile;

    public Customer() {
    }

    public Customer(Integer customerId, String customerName, String customerEmail, String customerMobile) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerMobile = customerMobile;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }
}
