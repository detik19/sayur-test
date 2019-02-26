package com.sayurbox.backend.app.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayurbox.backend.app.domains.Orders;

@RestController
@RequestMapping("/v1")
public class OrdersController {

	@PostMapping("/orders")
	public ResponseEntity<Orders> postOrder(@Valid @RequestBody Orders orders) {

		return null;

	}
}
