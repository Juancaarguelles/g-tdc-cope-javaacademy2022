package com.thesis.controller.user;

import com.thesis.persistence.dto.UserDTO;
import com.thesis.persistence.model.Message;
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

    @GetMapping("/login/{userName}/{password}")
    public ResponseEntity<?>login(@PathVariable String userName,@PathVariable String password)
    {
        try
        {
            User user = this.userService.loggedIn(userName, password);
            UserDTO userDTO = new UserDTO(user.getIdentification(), user.getUserName(),
                    user.getName(), user.getLastName(), user.getState(), user.getCountry(), user.isActive());
            return new ResponseEntity<>("Logged in"+userDTO, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/logout/{username}")
    public ResponseEntity<?>logout(@PathVariable String username)
    {
        try{
            User user = this.userService.logout(username);
            UserDTO userDTO = new UserDTO(user.getIdentification(), user.getUserName(),
                    user.getName(), user.getLastName(), user.getState(), user.getCountry(), user.isActive());
            return new ResponseEntity<>("Logged out"+userDTO, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/send-message/{username}")
    public ResponseEntity<?>sendMessage(@PathVariable String username,  @RequestBody Message message)
    {
        try
        {
            this.userService.sendMessage(username, message);
            return new ResponseEntity<>("Message sended : "+message, HttpStatus.OK);
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
