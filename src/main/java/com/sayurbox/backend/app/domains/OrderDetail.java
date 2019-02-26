package com.sayurbox.backend.app.domains;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="ORDER_DETAIL")
public class OrderDetail {
	@Id
		@Column(name="id", length=36)
		@Length(min=36, max=36)
		@GeneratedValue(generator= "system-uuid")
		@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="order_detail_id")
	private Orders orders;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="qty")
	private int quantity;
	
	@Column(name="total")
	private BigDecimal total;
	
	@Column(name="selected_date")
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
