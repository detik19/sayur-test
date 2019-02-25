package com.sayurbox.backend.app.domains;

import java.time.Instant;
import java.util.Set;

public class Orders {
	private String id;
	private Customer user;
	private Set<OrderDetails> orderList;
	private Instant orderDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	public Set<OrderDetails> getOrderList() {
		return orderList;
	}
	public void setOrderList(Set<OrderDetails> orderList) {
		this.orderList = orderList;
	}
	public Instant getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Instant orderDate) {
		this.orderDate = orderDate;
	} 
	
	
}
