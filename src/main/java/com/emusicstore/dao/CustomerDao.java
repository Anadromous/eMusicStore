package com.emusicstore.dao;

import com.emusicstore.model.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pchapman on 1/25/2017.
 */
public interface CustomerDao{

    void addCustomer (Customer customer);

    Customer getCustomerById (int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);
    
}
