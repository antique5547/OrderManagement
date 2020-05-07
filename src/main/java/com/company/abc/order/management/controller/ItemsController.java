package com.company.abc.order.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.abc.order.management.entity.Item;
import com.company.abc.order.management.service.ItemsDAOService;
import com.company.abc.order.management.service.OrderJPAResource;

@RestController
public class ItemsController {

	@Autowired
	OrderJPAResource jpaResource;
	@Autowired
	ItemsDAOService itemDaoService;
	
	@GetMapping("/items")
	public List<Item> retrieveItems(){
		List<Item> list = itemDaoService.retrieveAllItems();
		return list;
	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<Object> retrieveItemsById(@PathVariable("id") Integer id){
		Item findById = itemDaoService.findById(id);
		return new ResponseEntity(findById, HttpStatus.OK);
	}
	
	@DeleteMapping("/items/{id}")
	public ResponseEntity<Object> deleteItemsById(@PathVariable("id") Integer id){
		itemDaoService.deleteById(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/items")
	public ResponseEntity<Object> postItems(@RequestBody Item item){
		Item savedItem = itemDaoService.saveOrUpdate(item);
		return new ResponseEntity(savedItem, HttpStatus.CREATED);
	}
	
	
	
	
	
}
