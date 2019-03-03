package com.sayurbox.backend.app.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayurbox.backend.app.domains.Customer;
import com.sayurbox.backend.app.services.CustomerService;
import com.sayurbox.backend.app.util.HeaderUtil;
import com.sayurbox.backend.app.util.ResponseUtil;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);
    
    @Autowired
    private CustomerService customerService;
    
    /**
     * Create  new customer
     * @param customer
     * @return
     */
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
        log.debug("REST request to post order : {}", customer);
        Customer cust=customerService.saveCustomer(customer);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("customer", cust.getId().toString()))
                .body(cust);

	}
	
	/**
	 * get customer
	 * @param name
	 * @return
	 */
	@GetMapping("/{name}")
	public ResponseEntity<Customer> Customer(@PathVariable String name) {
        log.debug("REST request to get order : {}", name);
        Customer cust= customerService.findCustomer(name);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(cust));

	}
}
