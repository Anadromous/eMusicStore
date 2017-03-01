package com.emusicstore.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Authorities;
import com.emusicstore.model.Cart;
import com.emusicstore.model.Customer;

/**
 * Created by pchapman on 1/25/2017.
 */

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	final static Logger log = Logger.getLogger(CustomerDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		log.debug(">>>>>>>>>>>>>>>>>>>>>>> session: " + session);
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);

		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());

		// these used to be User
		// customer.setUsername(customer.getUsername());
		// customer.setPassword(customer.getPassword());
		// customer.setCustomerId(customer.getCustomerId());

		Authorities newAuthority = new Authorities();
		newAuthority.setUsername(customer.getUsername());
		newAuthority.setAuthority("ROLE_USER");
		session.saveOrUpdate(customer);
		session.saveOrUpdate(newAuthority);

		Cart newCart = new Cart();
		newCart.setCustomer(customer);
		customer.setCart(newCart);
		customer.setEnabled(true);
		session.saveOrUpdate(customer);
		session.saveOrUpdate(newCart);

		session.flush();
	}

	public Customer getCustomerById(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		return (Customer) session.get(Customer.class, customerId);
	}

	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customerList = query.list();

		return customerList;
	}

	public Customer getCustomerByUsername(String username) {
		log.debug(">>>>>>>>>>>>>>>>>>>>>>> Getting the customergetCustomerByUsername: " + username);

		Session session = sessionFactory.getCurrentSession();
		log.debug(">>>>>>>>>>>>>>>>>>>>>>> session: " + session.toString());
		Query query = session.createQuery("from Customer where username = ?");
		query.setString(0, username);

		return (Customer) query.uniqueResult();
	}


}
