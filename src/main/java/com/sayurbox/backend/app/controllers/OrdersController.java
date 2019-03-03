package com.sayurbox.backend.app.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayurbox.backend.app.domains.Orders;
import com.sayurbox.backend.app.models.OrderRequest;
import com.sayurbox.backend.app.services.OrdersService;
import com.sayurbox.backend.app.util.ResponseUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="/v1",  produces=MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {

	@Autowired
	private OrdersService orderService;
	
	/**
	 * make a order
	 * @param orderRequest
	 * @return
	 */
    @ApiOperation(httpMethod = "POST", 
 		   value = "make a order request", 
 		   nickname="postOrder")
	@PostMapping("/orders")
	public ResponseEntity<Orders> postOrder(@Valid @RequestBody OrderRequest orderRequest) {
		Orders orders=orderService.CheckOut(orderRequest.getCustomerName());
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(orders));

	}
	
	
}
