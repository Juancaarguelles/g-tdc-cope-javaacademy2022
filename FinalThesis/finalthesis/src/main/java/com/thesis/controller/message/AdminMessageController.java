package com.thesis.controller.message;

import com.thesis.persistence.model.Message;
import com.thesis.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/find-sort")
    public Page<Message>getMessages(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy)
    {
        return this.messageService.getMessages(page, sortBy);
    }

    @GetMapping("/find")
    public ResponseEntity<?>getFindMessagesBySubject(@RequestParam Optional<String> hint)
    {
        try {
            return new ResponseEntity<>(this.messageService.findSubjectContaining(hint.orElse("")), HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Not founded", HttpStatus.NOT_FOUND);
        }
    }


}
