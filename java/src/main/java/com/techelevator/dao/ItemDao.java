package com.techelevator.dao;

import com.techelevator.model.Item;

import java.util.List;

public interface ItemDao {
    ///boolean hasPermission(String username, int listId);
    void createItem(Item item);

    void deleteItem(int itemId);

    void updateItem(Item item);

    List<Item> listItems(int listId);

    void itemComplete(int groupId, int listId);

    void itemIncomplete(int groupId, int listId);
}
