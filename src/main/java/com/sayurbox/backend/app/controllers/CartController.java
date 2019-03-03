package com.sayurbox.backend.app.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayurbox.backend.app.domains.Orders;
import com.sayurbox.backend.app.models.SelectRequest;
import com.sayurbox.backend.app.services.OrdersService;
import com.sayurbox.backend.app.util.HeaderUtil;
import com.sayurbox.backend.app.util.ResponseUtil;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    private final Logger log = LoggerFactory.getLogger(CartController.class);
    
    @Autowired
    private OrdersService ordersService;
    
	@PostMapping
	public ResponseEntity<Orders> addCart(@Valid @RequestBody SelectRequest selectRequest) {
        log.debug("REST request to post order : {}", selectRequest);
        Orders o=ordersService.addToCart(selectRequest);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("orders", o.getId().toString()))
                .body(o);
	}
	
    @GetMapping("/{name}") 
	public  ResponseEntity<Orders> viewCart(@PathVariable String name){
        log.debug("REST request to get order : {}", name);

    	Orders o=ordersService.viewCart(name);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(o));		
	}
}
