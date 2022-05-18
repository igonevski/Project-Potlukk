package dev.group1.Potlukk.controller;

import dev.group1.Potlukk.entities.Item;
import dev.group1.Potlukk.services.ItemService;
import dev.group1.Potlukk.utilities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@CrossOrigin("*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Add an item to a potlukk
    @PostMapping("/items")
    public Item postItem(@RequestBody Item item){
        return this.itemService.addItem(item);
    }

    // Update Item
    @PutMapping("/items/{id}")
    public Item putItem(@PathVariable int id, @RequestBody Item item){
        item.setId(id);
        return this.itemService.updateItem(item);
    }

    // Change status
    @PatchMapping("/items/{id}/{status}")
    public Item patchStatus(@PathVariable int id, @PathVariable Status status){
        Item item = itemService.getItemById(id);
        item.setStatus(status);
        return this.itemService.updateItem(item);
    }

    // Remove an item from the list
    @DeleteMapping("/items/{id}")
    public boolean deleteItem(@PathVariable int id){
        return this.itemService.removeItem(id);
    }
}
