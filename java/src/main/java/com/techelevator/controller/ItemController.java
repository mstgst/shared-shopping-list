package com.techelevator.controller;

import com.techelevator.dao.ItemDao;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.UtilDao;
import com.techelevator.dao.exceptions.CreateException;
import com.techelevator.dao.exceptions.DeleteException;
import com.techelevator.dao.exceptions.GetException;
import com.techelevator.dao.exceptions.UpdateException;
import com.techelevator.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/groups/{groupId}/lists/{listId}/items")
@PreAuthorize("isAuthenticated()")
public class ItemController {
    private final ItemDao itemDao;
    private final UtilDao utilDao;
    private final UserDao userDao;
    public ItemController(ItemDao itemDao, UtilDao utilDao, UserDao userDao) {

        this.itemDao = itemDao;
        this.utilDao = utilDao;
        this.userDao = userDao;
    }
    //TODO chqange to pathvar not working
    //TODO change sql statement to check verifiication
    @GetMapping("")
    public List<Item> getAllItems(@PathVariable int groupId, @PathVariable int listId, Principal principal) {
        if (!utilDao.isVerified(principal.getName(), groupId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you do not have permission");
        }
        try {
            return itemDao.listItems(listId);
        } catch (GetException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not retrieve all items");
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@PathVariable int groupId, @PathVariable int listId, @RequestParam String itemName, @RequestParam int quantity, Principal principal) {
        if (!utilDao.isVerified(principal.getName(), groupId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you do not have permission");
        }
        Item item = new Item();
        item.setGroupId(groupId);
        item.setListId(listId);
        item.setItemName(itemName);
        item.setQuantity(quantity);
        System.out.println(item.toString());
        item.setLastModifier(userDao.findIdByUsername(principal.getName()));
        try {
            itemDao.createItem(item);
        } catch (CreateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not create item");
        }
    }

    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable int groupId, @PathVariable int listId, @PathVariable int itemId, Principal principal) {
        if (!utilDao.isVerified(principal.getName(), groupId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you do not have permission");
        }
        try {
             itemDao.deleteItem(itemId);
        } catch (DeleteException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not delete item");
        }
    }

    @PutMapping("/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateItem(@PathVariable int groupId, @PathVariable int listId, @PathVariable  int itemId, @RequestBody Item item, Principal principal) {
        if (!utilDao.isVerified(principal.getName(), groupId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you do not have permission");
        }
        item.setLastModifier(userDao.findIdByUsername(principal.getName()));
        try {
            itemDao.updateItem(item);
        } catch (UpdateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not update item");
        }
    }

    @PutMapping("/isComplete")
    public void itemComplete(@PathVariable int groupId, @PathVariable int listId) {
        try {
            itemDao.itemComplete(groupId, listId);
        } catch (UpdateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not update item");
        }
    }

    @PutMapping("/isIncomplete")
    public void itemIncomplete(@PathVariable int groupId, @PathVariable int listId) {
        try {
            itemDao.itemIncomplete(groupId, listId);
        } catch (UpdateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not update item");
        }
    }
}
