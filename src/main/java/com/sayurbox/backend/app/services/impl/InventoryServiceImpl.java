package com.sayurbox.backend.app.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayurbox.backend.app.domains.Inventory;
import com.sayurbox.backend.app.domains.Item;
import com.sayurbox.backend.app.repository.InventoryRepository;
import com.sayurbox.backend.app.repository.ItemRepository;
import com.sayurbox.backend.app.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final Logger log = LoggerFactory.getLogger( InventoryService.class);

    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Autowired
    private ItemRepository ItemRepository;

	@Override
	public Inventory saveInventory(Inventory inventory) {	
		
		Inventory inv=inventoryRepository.findOneByItem(inventory.getItem());
		if(inv!=null) {
			inv.setQuantity(inventory.getQuantity());
			return inventoryRepository.save(inv);
		}
		

		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory getInventory(String itemid) {

		Optional<Item> itemOpt=ItemRepository.findById(itemid);
		if(itemOpt.isPresent()) {
			
			return inventoryRepository.findOneByItem(itemOpt.get());
		}
		return null;
	}


    
    
}
