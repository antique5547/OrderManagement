package com.company.abc.order.management.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name="order_details")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderDetailsGenerator")
	@SequenceGenerator(name="orderDetailsGenerator", sequenceName = "order_details_sequence", initialValue=30001)
	private Integer id;
	
	@NotNull(message="Name should not be null")
	@Size(min=5, message="name should be more than 5 chars")
	@Column(length=50)
	private String name;
	
	@Past(message="Order Date should not in future date")
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 50)
	private Status status;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	@NotEmpty(message="items should be present atleast one")
	@OneToMany(mappedBy="order")
	private Set<Items> items;
	//Address
	//User
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
	public void setItems(Set<Items> items) {
		this.items = items;
	}
	public Set<Items> getItems() {
		return items;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", orderDate=" + orderDate + ", status=" + status + ", items="
				+ items + "]";
	} 
	
	
}
