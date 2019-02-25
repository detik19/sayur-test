package com.sayurbox.backend.app.domains;

import java.math.BigDecimal;
import java.time.Instant;

public class OrderDetails {
	private String id;
	private Item item;
	private BigDecimal price;
	private int quantity;
	private BigDecimal total;
	private Instant selectedDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Instant getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(Instant selectedDate) {
		this.selectedDate = selectedDate;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", product=" + item + ", price=" + price + ", quantity=" + quantity
				+ ", total=" + total + ", selectedDate=" + selectedDate + "]";
	}
	
	
	
}
