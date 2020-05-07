package com.company.abc.order.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.abc.order.management.entity.Item;
import com.company.abc.order.management.exception.ItemNotFoundException;

@Service
public class ItemsDAOService {
	@Autowired
	private ItemJPAResource itemJPAResource;
	
	public List<Item> retrieveAllItems(){
		return itemJPAResource.findAll();
	}

//	public Order save(Order order) {
//		return orderJPAResource.saveOrUpdate(order);
//	}
//
	public Item findById(Integer id) {
		Item findById = itemJPAResource.findById(id);
		if(findById == null)
			throw new ItemNotFoundException("Item Id : "+id+" does not exist");			
		return findById;
	}

	public Item deleteById(Integer id) {
		Item findById = findById(id);
		itemJPAResource.delete(findById);
		return findById;
	}

	public Item saveOrUpdate(Item item) {
		return itemJPAResource.saveOrUpdate(item);
	}

}
