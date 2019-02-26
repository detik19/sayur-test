package com.sayurbox.backend.app.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sayurbox.backend.app.domains.Item;
import com.sayurbox.backend.app.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Override
	public Item getItem(String id) {
		Item item=new Item();
		item.setName("Apel");
//		UUID uuid = UUID.randomUUID();
		item.setId(id);
		
		return item;
	}

}
