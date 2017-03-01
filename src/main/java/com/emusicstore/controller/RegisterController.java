package com.emusicstore.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emusicstore.model.BillingAddress;
import com.emusicstore.model.Customer;
import com.emusicstore.model.ShippingAddress;
import com.emusicstore.service.CustomerService;

/**
 * Created by pchapman on 1/25/2017.
 */

@Controller
@RequestMapping("/")
public class RegisterController {

	final static Logger log = Logger.getLogger(RegisterController.class);
	
    @Autowired
    private CustomerService customerService;

/*    @RequestMapping("/register")
    public String registerCustomer(Model model) {

        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer", customer);

        return "registerCustomer";

    }*/
    /*@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@ModelAttribute("customer") Customer customer, Model model) {

        customer.setEnabled(true);
        customerService.addCustomer(customer);

        return "registerCustomerSuccess";

    }*/
    
    //////new
    
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String goRegister() {
		/*Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);
        
        log.debug("-----------------------Adding customer to model");
        customerService.addCustomer(customer);*/

        return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute Customer customer) {
		BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);
		customer.setRole("ROLE_ADMIN");
		log.debug("---------About to addCustomer with customerService call........");
		log.debug("Customer: "+customer.toString());
		customerService.addCustomer(customer);
		log.debug("post customerService call.......................................");
		Authentication auth = new UsernamePasswordAuthenticationToken(customer, customer.getPassword(), customer.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		return "redirect:/";
	}

}
