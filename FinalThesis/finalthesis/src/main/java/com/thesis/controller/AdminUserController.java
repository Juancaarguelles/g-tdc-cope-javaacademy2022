package com.thesis.controller;

import com.thesis.persistence.model.User;
import com.thesis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin-users")
public class AdminUserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> findAll()
    {
        return this.userService.findAll();
    }


    @PostMapping("/register")
    public ResponseEntity<?>registerUser(@RequestBody User user)
    {
        try
        {
            this.userService.couldRegisterUser(user);
            return new ResponseEntity<>("User Registered Succesfully", HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/test-add")
    public ResponseEntity<?> saveUser(@RequestBody User user)
    {
        try
        {
            this.userService.save(user);
            return new ResponseEntity<>("User added succesfully", HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>("User couldn't be added succesfully",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/test-check/{identification}/{username}")
    public ResponseEntity<?>checkUserRegistered(@PathVariable int identification, @PathVariable String username)
    {
        if(this.userService.isRegistered(identification, username))
            return new ResponseEntity<>("User is registered already", HttpStatus.OK);
        else
            return new ResponseEntity<>("User is not registered already", HttpStatus.NOT_FOUND);
    }

}
