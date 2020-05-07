package com.company.abc.order.management.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="item_details")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="itemGenerator")
	@SequenceGenerator(name="itemGenerator", sequenceName="item_sequence", initialValue=10001)
	private Integer id;
	@NotNull(message="Name should not be null")
	@Size(min=5, message="Name should be more than 5 chars")
	private String name;
	@Size(min=5, message="descritpion should be more than 5 chars")
	private String descritpion;
	private String itemType;
	private String itemCategory;
	@NotNull
	private Double amount;
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
	public String getDescritpion() {
		return descritpion;
	}
	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
