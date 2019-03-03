package com.sayurbox.backend.app.services;

import com.sayurbox.backend.app.domains.Inventory;

public interface InventoryService {
	public Inventory saveInventory(Inventory inventory);
	public Inventory getInventory(String inventoryId);
}
