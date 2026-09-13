package com.findback.service;

import com.findback.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemService {

    private final List<Item> items;

    public ItemService() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getAllItems() {
        return items;
    }

    public List<Item> searchItems(String keyword) {

    List<Item> results = new ArrayList<>();

    for (Item item : items) {

        if (item.getName().toLowerCase().contains(keyword.toLowerCase())
                || item.getCategory().toLowerCase().contains(keyword.toLowerCase())
                || item.getLocation().toLowerCase().contains(keyword.toLowerCase())) {

            results.add(item);
        }
    }

    return results;
}
}