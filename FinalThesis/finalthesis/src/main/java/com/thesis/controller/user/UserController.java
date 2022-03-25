package com.thesis.controller.user;

import com.thesis.persistence.dto.MessageDTO;
import com.thesis.persistence.dto.UserDTO;
import com.thesis.persistence.model.User;
import com.thesis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserDTO>listAll()
    {
        return this.userService.findAll().stream().map(x -> new UserDTO(x.getId(), x.getUserName(),x.getName(),
                x.getLastName(), x.getState(), x.getCountry(), x.isActive(),
                x.getAllMessages().stream().map(y -> new MessageDTO(y.getOrigin(),y.getDestination(),y.getCc(), y.getBcc(), y.getSubject(), y.getBody(), y.getAttachment())).collect(Collectors.toSet()),
                x.getSentMessages().stream().map(z -> new MessageDTO(z.getOrigin(),z.getDestination(),z.getCc(), z.getBcc(), z.getSubject(), z.getBody(), z.getAttachment())).collect(Collectors.toSet()),
                x.getReceivedMessages().stream().map(q -> new MessageDTO(q.getOrigin(),q.getDestination(),q.getCc(), q.getBcc(), q.getSubject(), q.getBody(), q.getAttachment())).collect(Collectors.toSet())
                ))
                .collect(Collectors.toList());
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
}
