package com.sayurbox.backend.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sayurbox.backend.app.domains.Customer;
import com.sayurbox.backend.app.domains.Item;

public interface CustomerRepository extends CrudRepository<Customer, String>{
	public Customer findOneByName(String name);
}
