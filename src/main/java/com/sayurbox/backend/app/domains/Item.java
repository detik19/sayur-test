package com.sayurbox.backend.app.domains;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="ITEM")
public class Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1606815628692947162L;
	@Id
		@Column(name="id", length=36)
		@Length(min=36, max=36)
		@GeneratedValue(generator= "system-uuid")
		@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String id;
	
	@NotNull
	@Column(name = "name", unique=true, nullable=false)
	private String name;
	
	@Digits(integer=5, fraction=2)
	@Column(name="unitprice")
	private BigDecimal unitPrice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + "]";
	}
	
	
}
