package com.sayurbox.backend.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayurbox.backend.app.domains.Orders;
import com.sayurbox.backend.app.models.OrderRequest;
import com.sayurbox.backend.app.services.OrdersService;

@RestController
@RequestMapping("/v1")
public class OrdersController {

	@Autowired
	private OrdersService orderService;
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> postOrder(@Valid @RequestBody OrderRequest orderRequest) {
		orderService.CheckOut(orderRequest.getCustomerName());
		return null;

	}
	
	
}
