package com.sayurbox.backend.app.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayurbox.backend.app.domains.Customer;
import com.sayurbox.backend.app.repository.CustomerRepository;
import com.sayurbox.backend.app.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer findCustomer(String name) {
		Customer cust=customerRepository.findOneByName(name);
		
		return cust;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
