package com.app.service.controller;

import com.app.service.model.Item;
import com.app.service.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/*
 Commented as its been called from Zuul Gateway Service
 Uncomment if to call directly
@CrossOrigin

*/
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/findAll/{userId}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getDefaultSearchResult")
    public List<Item> findAll(@PathVariable("userId") Long userId) {
        List<Item> items = itemService.findAll(userId);
        return items;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Item item) {
        this.itemService.save(item);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody Item item) {
        this.itemService.delete(item);
    }

    public List<Item> getDefaultSearchResult(Long userId) {
        Item item = new Item();
        item.setDescription("no result found.");
        List<Item> list = Arrays.asList(item);
        return list;
    }
}
