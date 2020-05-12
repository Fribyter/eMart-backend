package com.app.service.service;

import com.app.service.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll(Long userId);

    void save(Item item);

    void delete(Item item);
}
