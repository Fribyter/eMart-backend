package com.app.service.service;

import com.app.service.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    List<Item> findByName(String name);

    List<Item> findByPrice(double startPrice, double endPrice);

    Item findById(Long id);
}
