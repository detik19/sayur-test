package com.sayurbox.backend.app.controllers;

import java.net.URISyntaxException;
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

import com.sayurbox.backend.app.domains.Inventory;
import com.sayurbox.backend.app.domains.Orders;
import com.sayurbox.backend.app.services.InventoryService;
import com.sayurbox.backend.app.util.HeaderUtil;
import com.sayurbox.backend.app.util.ResponseUtil;




@RestController
@RequestMapping("/v1/inventory")
public class InventoryController {
    private final Logger log = LoggerFactory.getLogger(InventoryController.class);
    
    @Autowired
    private InventoryService inventoryService;
    
    /**
     * save inventory
     * @param inventory
     * @return
     * @throws URISyntaxException
     */
    @PostMapping
    public ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory) throws URISyntaxException {
        log.debug("REST request to update Books : {}", inventory);
        Inventory result = inventoryService.saveInventory(inventory);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("inventory", result.getId().toString()))
            .body(result);
    }
    
    /**
     * view inventory
     * @param id
     * @return
     */
    @GetMapping("/{id}") 
	public  ResponseEntity<Inventory> viewInventory(@PathVariable String id){
        log.debug("REST request to get inventory : {}", id);
        Inventory result= inventoryService.getInventory(id);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(result));		
    		
	}
    
}
