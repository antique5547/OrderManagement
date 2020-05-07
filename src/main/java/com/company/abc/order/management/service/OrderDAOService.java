package com.company.abc.order.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.abc.order.management.entity.Order;
import com.company.abc.order.management.exception.OrderNotFoundException;

@Service
public class OrderDAOService {

	@Autowired
	private OrderJPAResource orderJPAResource;
	
	public List<Order> retrieveAllOrders(){
		return orderJPAResource.findAll();
	}

	public Order save(Order order) {
		return orderJPAResource.saveOrUpdate(order);
	}

	public Order findById(Integer id) {
		Order findById = orderJPAResource.findById(id);
		if(findById == null)
			throw new OrderNotFoundException("Order Id : "+id+" does not exist");			
		return findById;
	}

	public void deleteById(Integer id) {
		Order findById = findById(id);
		orderJPAResource.delete(findById);
	}
}
