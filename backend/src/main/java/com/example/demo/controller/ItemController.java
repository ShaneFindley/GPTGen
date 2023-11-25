package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        LOGGER.info("Fetching all items");
        return itemService.getAllItems();
    }

    @PostMapping
    public Item addItem(@RequestBody Item newItem) {
        LOGGER.info("Adding item: {}", newItem);
        return itemService.addItem(newItem);
    }
}
