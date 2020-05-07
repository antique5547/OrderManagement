package com.company.abc.order.management.model;

import java.util.Date;
import java.util.Set;

import com.company.abc.order.management.entity.Items;
import com.company.abc.order.management.entity.Status;

public class OrderDTO {
	private Integer id;
	private String name;
	private Date orderDate;
	private Status status;
	private Set<ItemsTO> items;
	
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public OrderDTO(Integer id, String name, Date orderDate, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.orderDate = orderDate;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setItems(Set<ItemsTO> items) {
		this.items = items;
	}
	public Set<ItemsTO> getItems() {
		return items;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", orderDate=" + orderDate + ", status=" + status + ", items="
				+ items + "]";
	} 
}
