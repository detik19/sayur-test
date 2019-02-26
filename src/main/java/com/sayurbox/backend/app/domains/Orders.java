package com.sayurbox.backend.app.domains;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

//@Entity
//@Table(name="ORDERS")
public class Orders implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4449685284665098460L;
	@Id
		@Column(name="id", length=36)
		@Length(min=36, max=36)
		@GeneratedValue(generator= "system-uuid")
		@GenericGenerator(name="system-uuid", strategy="uuid2")
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
