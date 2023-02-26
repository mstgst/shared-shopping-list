package com.techelevator.controller;

import com.techelevator.dao.GroupDao;
import com.techelevator.dao.ListDao;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.UtilDao;
import com.techelevator.dao.exceptions.CreateException;
import com.techelevator.dao.exceptions.DeleteException;
import com.techelevator.dao.exceptions.GetException;
import com.techelevator.dao.exceptions.UpdateException;
import com.techelevator.model.Group;
import com.techelevator.model.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/groups/{groupId}/lists")
@PreAuthorize("isAuthenticated()")


public class ListController {
    private final ListDao listDao;
    private final GroupDao groupDao;
    private final UserDao userDao;
    private final UtilDao utilDao;

    public ListController(ListDao listDao, GroupDao groupDao, UserDao userDao, UtilDao utilDao) {
        this.listDao = listDao;
        this.groupDao = groupDao;
        this.userDao = userDao;
        this.utilDao = utilDao;
    }


    @GetMapping("")
    public java.util.List<List> getAllLists(@PathVariable int groupId, Principal principal) {
        if (!utilDao.isVerified(principal.getName(), groupId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you do not have permission");
        }
        try {
            return listDao.getAllListsForGroup(groupId);
        } catch (GetException e) {
            System.out.println("made it here list controller");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not retrieve lists");
        }
    }

    @GetMapping("/{listId}")
    public List getListByListId(@PathVariable int groupId, @PathVariable int listId, Principal principal) {
        if (!utilDao.isVerified(principal.getName(), groupId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you do not have permission");
        }
        try {
            return listDao.getList(groupId, listId);
        } catch (GetException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not retrieve list with id");
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAList(@PathVariable int groupId, @RequestParam String listName, @RequestParam String listDescription, Principal principal) {
        if (!utilDao.isVerified(principal.getName(), groupId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you do not have permission");
        }
        List list = new List();
        list.setListName(listName);
        list.setDescription(listDescription);
        list.setGroupId(groupId);
        try {
            listDao.createList(list);
        } catch (CreateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not create list");
        }
    }

    @PutMapping("")
    public void updateAList(@PathVariable int groupId, @PathVariable int listId, @RequestBody List list, Principal principal) {
        if (!utilDao.isVerified(principal.getName(), groupId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you do not have permission");
        }
        try {
            listDao.updateList(list);
        } catch (UpdateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not update list");
        }
    }

    //TODO: Should only be able to delete a list you have claimed(?)
    @DeleteMapping("/{listId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAList(@PathVariable int groupId, @PathVariable int listId, Principal principal) {
        if (!isOwner(principal.getName(), listDao.getList(groupId, listId).getClaimedId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "only list owner can delete a list");
        }
            if (!utilDao.isVerified(principal.getName(), groupId)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you do not have permission");
            }
            try {
                listDao.deleteList(groupId, listId);
            } catch (DeleteException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not delete list");
            }
        }

    @PutMapping("/{listId}/claim")
    public void claimAList(@PathVariable int groupId, @PathVariable int listId, Principal principal) {
        if (listDao.getList(groupId, listId).getClaimedId() > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "this list is already claimed");
        }
        if (!utilDao.isVerified(principal.getName(), groupId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you do not have permission");
        }
        try {
            listDao.claimList(groupId, listId, userDao.findIdByUsername(principal.getName()));
        } catch (UpdateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not update list");
        }
    }

    @PutMapping("/{listId}/unclaim")
    public void unclaimAList(@PathVariable int groupId, @PathVariable int listId, Principal principal) {
        if (!isOwner(principal.getName(), listDao.getList(groupId, listId).getClaimedId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "only list owner can unclaim a list");
        }
        if (!utilDao.isVerified(principal.getName(), groupId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you do not have permission");
        }
        try {
            listDao.unclaimList(groupId, listId, userDao.findIdByUsername(principal.getName()));
        } catch (UpdateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not update list");
        }
    }

    @PutMapping("/{listId}/isComplete")
    public void completeList(@PathVariable int groupId, @PathVariable int listId) {
        try {
            listDao.completeList(groupId, listId);
        } catch (UpdateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not update list");
        }
    }

    @PutMapping("/{listId}/isIncomplete")
    public void incompleteList(@PathVariable int groupId, @PathVariable int listId) {
        try {
            listDao.completeList(groupId, listId);
        } catch (UpdateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not update list");
        }
    }


    private boolean isOwner (String username,int ownerId){
        int userId = userDao.findIdByUsername(username);
        boolean owner = false;
        if (userId == ownerId) {
            owner = true;
        }
        return owner;
    }

}