package com.company.abc.order.management.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.abc.order.management.entity.Item;
import com.company.abc.order.management.entity.Items;
import com.company.abc.order.management.entity.Order;

@Repository
@Transactional
public class OrderJPAResource{

@Autowired
private EntityManager entityManager;

public List<Order> findAll() {
	List<Order> resultList = entityManager.createQuery(" from Order", Order.class).getResultList();
	return resultList;
}

public Order findById(Integer id) {
	return entityManager.find(Order.class, id);
}

public Item findItemById(Integer id) {
	return entityManager.find(Item.class, id);
}

public Order save(Order order) {
	//If OrderId and ItemdId will be passed in request then setting as null
	order.setId(null);
	order.getItems().stream().forEach(items -> items.setId(null));
	entityManager.persist(order);
	for(Items item: order.getItems()){
		item.setOrder(order);
		Item findItemById = findItemById(item.getProductId().getId());
		item.setProductId(findItemById);
		entityManager.persist(item);
	}
	return order;
}

public Order saveOrUpdate(Order order) {
	//if order id will be exists then deleting the items and updating the new data
	if(order.getId() != null && findById(order.getId()) != null){
		Order findById = findById(order.getId());
		for(Items item: findById.getItems()){
			item.setOrder(findById);
			entityManager.remove(item);
		}
		entityManager.merge(order);
		for(Items item: order.getItems()){
			item.setOrder(order);
			item.setProductId(findItemById(item.getProductId().getId()));
			entityManager.merge(item);
		}
	}else{
		//if order will not be exist then persisting the new records
		this.save(order);
	}
	
	return order;
}

public Order deleteById(Integer id) {
	Order findById = findById(id);
	entityManager.remove(findById);
	return findById;
}

public void delete(Order findById) {
	if(findById.getItems() != null){
		for(Items item: findById.getItems()){
			entityManager.remove(item);
		}
	}
	entityManager.remove(findById);
	
}

}
