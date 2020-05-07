package com.company.abc.order.management.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.abc.order.management.entity.Order;
import com.company.abc.order.management.exception.OrderNotFoundException;
import com.company.abc.order.management.service.OrderDAOService;
import com.company.abc.order.management.service.OrderJPAResource;

@RestController
public class OrderController {
	
	@Autowired
	OrderJPAResource jpaResource;
	@Autowired
	OrderDAOService orderDaoService;
	
	@GetMapping("/orders")
	public List<Order> retrieveOrders(){
		List<Order> list = orderDaoService.retrieveAllOrders();
		return list;
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> retrieveOrdersById(@PathVariable("id") Integer id){
		Order findById = orderDaoService.findById(id);
		return new ResponseEntity<>(findById, HttpStatus.OK);
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Order> deleteOrdersById(@PathVariable("id") Integer id){
		orderDaoService.deleteById(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/orders")
	public ResponseEntity<Object> postOrder(@Valid @RequestBody Order order) {
		Order savedOrder = orderDaoService.save(order);
//		URI location = ServletUriComponentsBuilder
//			.fromCurrentRequest()
//			.path("/{id}")
//			.buildAndExpand(savedOrder.getId()).toUri();
		
		return new ResponseEntity(savedOrder, HttpStatus.CREATED);
		
	}
	
	
	
}
