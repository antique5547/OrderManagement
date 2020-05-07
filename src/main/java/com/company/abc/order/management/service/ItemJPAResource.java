package com.company.abc.order.management.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.abc.order.management.entity.Item;

@Service
@Transactional
public class ItemJPAResource {
	@Autowired
	private EntityManager entityManager;

	public List<Item> findAll() {
		List<Item> resultList = entityManager.createQuery(" from Item", Item.class).getResultList();
		return resultList;
	}

	public Item findById(Integer id) {
		return entityManager.find(Item.class, id);
	}

	public void delete(Item findById) {
		entityManager.remove(findById);
	}
	
	public Item deleteById(Integer id) {
		Item findById = findById(id);
		entityManager.remove(findById);
		return findById;
	}
	
	public Item saveOrUpdate(Item item) {
		if(item.getId() != null && findById(item.getId()) != null){
			entityManager.merge(item);
		}else{
			item.setId(null);
			entityManager.persist(item);
		}
		return item;
	}
}
