package com.app.service.service;

import com.app.service.model.Item;
import com.app.service.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> findByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public List<Item> findByPrice(double startPrice, double endPrice) {
        return itemRepository.findByPrice(startPrice, endPrice);
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id).orElse(new Item());
    }
}
