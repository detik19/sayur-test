package com.sayurbox.backend.app.services;

import javax.validation.Valid;

import com.sayurbox.backend.app.domains.Item;

public interface ItemService {
	public Item getItem(String id);
	public Item saveItem(@Valid Item item);

}
