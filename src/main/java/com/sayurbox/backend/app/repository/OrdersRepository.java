package com.sayurbox.backend.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sayurbox.backend.app.domains.Customer;
import com.sayurbox.backend.app.domains.Orders;

public interface OrdersRepository extends CrudRepository<Orders, String> {

	public Orders findOneByCustomerAndStatus(Customer customer, int status);
	public Orders findAllByCustomerAndStatus(Customer customer, int status);
	public Orders findByStatus(int status);

}
