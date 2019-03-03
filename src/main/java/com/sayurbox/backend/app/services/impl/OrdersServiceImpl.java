package com.sayurbox.backend.app.services.impl;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayurbox.backend.app.domains.Customer;
import com.sayurbox.backend.app.domains.Inventory;
import com.sayurbox.backend.app.domains.OrderItem;
import com.sayurbox.backend.app.domains.Orders;
import com.sayurbox.backend.app.models.Constants;
import com.sayurbox.backend.app.models.SelectRequest;
import com.sayurbox.backend.app.repository.CustomerRepository;
import com.sayurbox.backend.app.repository.InventoryRepository;
import com.sayurbox.backend.app.repository.OrderItemRepository;
import com.sayurbox.backend.app.repository.OrdersRepository;
import com.sayurbox.backend.app.services.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{
    private final Logger log = LoggerFactory.getLogger(OrdersServiceImpl.class);

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrdersRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	
	@Autowired 
	private InventoryRepository inventoryRepository;
	
	@Override
	public Orders addToCart(SelectRequest selectRequest) {
		
		Orders o=orderRepository.findOneByCustomerAndStatus(selectRequest.getCustomer(), Constants.STATUS_ORDER_CART);
		if(o!=null) {
			saveOrderItems(selectRequest, o);
			
		}
		else {
			o=new Orders();
			o.setCustomer(selectRequest.getCustomer());
			o=orderRepository.save(o);
			saveOrderItems(selectRequest, o);
			
		}
		
		
		// TODO Auto-generated method stub
		return orderRepository.findById(o.getId()).get();
	}


	private void saveOrderItems(SelectRequest selectRequest, Orders o) {
		for(OrderItem oi:selectRequest.getOrderItems()) {
			oi.setOrders(o);
			oi.setSelectedDate(new Date().toInstant());
			OrderItem oiexist=orderItemRepository.findOneByOrdersAndItem(o, oi.getItem());
			if(oiexist!=null) {
				int qty=oi.getQuantity()+oiexist.getQuantity();
				BigDecimal price= oi.getPrice().add(oiexist.getPrice());
				oiexist.setQuantity(qty);
				oiexist.setPrice(price);
				orderItemRepository.save(oiexist);

			}else {
				orderItemRepository.save(oi);

			}
		}
	}


	@Override
	public Orders viewCart(String name) {
		Customer c=customerRepository.findOneByName(name);
		Orders o=orderRepository.findOneByCustomerAndStatus(c, Constants.STATUS_ORDER_CART);
		return o;
	}


	@Override
	public Orders CheckOut(String name) {
		Customer c=customerRepository.findOneByName(name);
		Orders o=orderRepository.findOneByCustomerAndStatus(c, Constants.STATUS_ORDER_CART);
		Set<OrderItem> lastOrderItem=new HashSet<OrderItem>();
		log.debug("check inventory");
		for(OrderItem oi:o.getOrderItems()) {
			OrderItem oi2=checkInventory(oi);
			lastOrderItem.add(oi2);
		}
		
		o.setOrderItems(lastOrderItem);
		o.setStatus(Constants.STATUS_ORDER_PAID);
		o=orderRepository.save(o);
		
		
		return o;
	}
	
	private OrderItem checkInventory(OrderItem oi) {
		Inventory inv=inventoryRepository.findOneByItem(oi.getItem());
		if(inv.getQuantity()==0) {
			oi.setQuantity(0);
		}
		else if(inv.getQuantity()>=oi.getQuantity()) {
			int sisa=inv.getQuantity()-oi.getQuantity();
			inv.setQuantity(sisa);
			
		}else if(inv.getQuantity()<oi.getQuantity()) {
			oi.setQuantity(inv.getQuantity());
			inv.setQuantity(0);
		}
		return oi;
		
	}


	@Override
	public Orders processTransaction() {
		//Orders o=orderRepository.findByStatus(status)

		return null;
	}



}
