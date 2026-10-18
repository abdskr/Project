
package com.findback.service;

import com.findback.model.Item;
import com.findback.repository.ItemRepository;

import java.util.List;
import java.util.Set;

public class ItemService {

    private final ItemRepository itemRepository;

    private static final Set<String> ALLOWED_STATUSES =
            Set.of("LOST", "FOUND", "RETURNED");

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

    public boolean updateItemStatus(int id, String status) {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Item ID must be positive."
            );
        }

        if (status == null ||
                !ALLOWED_STATUSES.contains(
                        status.trim().toUpperCase()
                )) {
            throw new IllegalArgumentException(
                    "Status must be LOST, FOUND, or RETURNED."
            );
        }

        return itemRepository.updateStatus(
                id,
                status.trim().toUpperCase()
        );
    }
}
