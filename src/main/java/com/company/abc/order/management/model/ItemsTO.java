package com.company.abc.order.management.model;

import com.company.abc.order.management.entity.Order;

public class ItemsTO {
	private long id;
	private String itemId;
	private double itemTotal;
	private int quantity;
	public ItemsTO() {
		// TODO Auto-generated constructor stub
	}
	public ItemsTO(long id, String itemId, double itemTotal, int quantity) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.itemTotal = itemTotal;
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	
	
}
