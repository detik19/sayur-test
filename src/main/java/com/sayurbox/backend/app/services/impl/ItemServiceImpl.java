package com.sayurbox.backend.app.services.impl;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayurbox.backend.app.domains.Item;
import com.sayurbox.backend.app.repository.ItemRepository;
import com.sayurbox.backend.app.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item getItem(String id) {
		Item item=new Item();
		item.setName("Apel");
//		UUID uuid = UUID.randomUUID();
		item.setId(id);
		
		return item;
	}

	@Override
	public Item saveItem(@Valid Item item) {
		Item result=itemRepository.save(item);
		return result;
	}

}
