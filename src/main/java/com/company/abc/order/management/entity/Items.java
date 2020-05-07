package com.company.abc.order.management.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="items")
public class Items {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="itemGenerator")
	@SequenceGenerator(name="itemGenerator", sequenceName = "item_sequence", initialValue=20001)
	private Integer id;
	
	@NotNull(message="items.productId should not be null")
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Item productId;
	
	public Item getProductId() {
		return productId;
	}
	public void setProductId(Item productId) {
		this.productId = productId;
	}
	@Column(name="item_total")
	private double itemTotal;
	private int quantity;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="order_id", nullable=false)
	private Order order;
	public Items() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", productId=" + productId + ", itemTotal=" + itemTotal + ", quantity=" + quantity
				+ ", order=" + order + "]";
	}
	
	
}
