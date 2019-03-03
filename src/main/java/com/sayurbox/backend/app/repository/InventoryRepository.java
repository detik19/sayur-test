package com.sayurbox.backend.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sayurbox.backend.app.domains.Inventory;
import com.sayurbox.backend.app.domains.Item;

@Transactional
public interface InventoryRepository extends CrudRepository<Inventory, String> {
	public Inventory findOneByItem(Item item);
}
