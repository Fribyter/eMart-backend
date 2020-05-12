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
    public List<Item> findAll(Long userId) {
        return itemRepository.findAll(userId);
    }

    @Override
    public void save(Item item) {
        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public void delete(Item item) {
        this.itemRepository.delete(item);
    }
}
