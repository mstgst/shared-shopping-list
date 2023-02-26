package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.exceptions.CreateException;
import com.techelevator.dao.exceptions.DeleteException;
import com.techelevator.dao.exceptions.GetException;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@PreAuthorize("isAuthenticated()")
public class UserController {
    private UserDao userDao;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        try {
            return userDao.findAll();
        } catch (GetException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not retrieve users");
        }
    }
//
//    @GetMapping(path = "/{userId}")
//    public User getUserById(@PathVariable("userId") int userId) {
//        try {
//            return userDao.getUserById(userId);
//        } catch (GetException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not retrieve user");
//        }
//    }
//
//    @GetMapping("/username")
//    public User findByUsername(@RequestBody @Valid String username) {
//        try {
//            return userDao.findByUsername(username);
//        } catch (GetException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not retrieve user");
//        }
//    }
//    @GetMapping("")
//    public int findIdByUsername(@RequestBody @Valid String username) {
//        try {
//            return userDao.findIdByUsername(username);
//        } catch (GetException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not retrieve user");
//        }
//    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createUser(@RequestBody @Valid String username, String password, String role) {
        try {
            return userDao.create(username, password, role);
        } catch (CreateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not create user");
        }
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(Principal principal) {
        try {
            userDao.deleteUser(principal.getName());
        } catch (DeleteException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "could not delete user");
        }
    }


}
