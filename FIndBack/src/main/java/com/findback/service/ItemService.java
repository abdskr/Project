package com.findback.service;

import com.findback.model.Item;
import com.findback.repository.ItemRepository;

import java.util.List;

public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService() {
        itemRepository = new ItemRepository();
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> searchItems(String keyword) {
        return itemRepository.search(keyword);
    }
}