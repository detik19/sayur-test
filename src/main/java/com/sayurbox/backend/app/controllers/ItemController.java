package com.sayurbox.backend.app.controllers;

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

import com.sayurbox.backend.app.domains.Item;
import com.sayurbox.backend.app.services.ItemService;
import com.sayurbox.backend.app.util.HeaderUtil;
import com.sayurbox.backend.app.util.ResponseUtil;


@RestController
@RequestMapping("/v1/item")
public class ItemController {
    private final Logger log = LoggerFactory.getLogger(ItemController.class);
    
    @Autowired
    private ItemService itemService;
    
    @GetMapping("/{id}") 
    public ResponseEntity<Item> getBooks(@PathVariable String id) {
        log.debug("REST request to get Item : {}", id);
        Item item=itemService.getItem(id);
//        Book book = bookService.getBookByPermalik(permalink);
//        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(book));
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(item));
    }
    
    @PostMapping
    public ResponseEntity<Item> postitem(@Valid @RequestBody Item item) {
        log.debug("REST request to POST  Item : {}", item);
        Item result = itemService.saveItem(item);

        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("item", item.getId().toString()))
                .body(result);    }
    

}
