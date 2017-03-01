package com.emusicstore.service.impl;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Customer;
import com.emusicstore.service.CustomerService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pchapman on 1/25/2017.
 */

@Service
public class CustomerServiceImpl implements CustomerService{

	final static Logger log = Logger.getLogger(CustomerServiceImpl.class);
	
    @Autowired
    private CustomerDao customerDao;

    public void addCustomer (Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username) {
    	log.debug(">>>>>>>>>>>>>>>>>>>>>>> CustomerServiceImpl.getCustomerByUserName.........................");
        return customerDao.getCustomerByUsername(username);
    }
}
