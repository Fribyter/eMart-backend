package com.app.service.controller;

import com.app.service.model.Item;
import com.app.service.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
/*
 Commented as its been called from Zuul Gateway Service
 Uncomment if to call directly
@CrossOrigin

*/
@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping("/findAll")
	@HystrixCommand(fallbackMethod = "getDefaultSearchResult")
	public List<Item> findAll() {
		List<Item> items = itemService.findAll();
		return items;
	}

	public List<Item> getDefaultSearchResult() {
		Item item = new Item();
		item.setDescription("no result found.");
		List<Item> list = Arrays.asList(item);
		return list;
	}
}
