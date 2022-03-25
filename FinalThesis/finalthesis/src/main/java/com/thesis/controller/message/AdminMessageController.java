package com.thesis.controller.message;

import com.thesis.persistence.model.Message;
import com.thesis.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin-messages")
public class AdminMessageController
{
    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public List<Message> findAll()
    {
        return this.messageService.findAll();
    }
}
