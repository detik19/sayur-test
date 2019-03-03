package com.sayurbox.backend.app.domains;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="INVENTORY")
public class Inventory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3780915770413082815L;
	@Id
		@Column(name="id", length=36)
		@Length(min=36, max=36)
		@GeneratedValue(generator= "system-uuid")
		@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String id;
	
	@OneToOne
    @JoinColumn(unique=true)
	private Item item;
	

	private int quantity;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
