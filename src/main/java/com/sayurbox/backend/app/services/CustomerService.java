package com.sayurbox.backend.app.services;

import com.sayurbox.backend.app.domains.Customer;

public interface CustomerService {
	
	public Customer findCustomer(String name);
	public Customer saveCustomer(Customer customer);

}
