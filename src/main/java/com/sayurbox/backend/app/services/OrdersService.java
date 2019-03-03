package com.sayurbox.backend.app.services;

import com.sayurbox.backend.app.domains.Orders;
import com.sayurbox.backend.app.models.SelectRequest;

public interface OrdersService {

	public Orders addToCart(SelectRequest selectRequest);
	public Orders viewCart(String name);
	public Orders CheckOut(String name);
	public Orders processTransaction();

}
