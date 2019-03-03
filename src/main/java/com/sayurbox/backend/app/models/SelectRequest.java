package com.sayurbox.backend.app.models;

import java.util.List;

import com.sayurbox.backend.app.domains.Customer;
import com.sayurbox.backend.app.domains.OrderItem;


public class SelectRequest {
	private List<OrderItem> orderItems;
	private Customer customer;

	
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	
}
