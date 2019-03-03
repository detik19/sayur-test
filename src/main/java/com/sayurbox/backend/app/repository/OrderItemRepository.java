package com.sayurbox.backend.app.repository;


import org.springframework.data.repository.CrudRepository;

import com.sayurbox.backend.app.domains.Item;
import com.sayurbox.backend.app.domains.OrderItem;
import com.sayurbox.backend.app.domains.Orders;

public interface OrderItemRepository extends CrudRepository<OrderItem, String>{
	public OrderItem findOneByOrdersAndItem(Orders orders, Item item);

}
