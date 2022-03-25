package com.thesis.services;

import com.thesis.persistence.model.Message;
import com.thesis.persistence.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements ModelService<Message>
{
    @Autowired
    private IMessageRepository messageRepository;

    @Override
    public List<Message> findAll() {
        return this.messageRepository.findAll();
    }

    @Override
    public Message getById(Integer id) {
        return this.messageRepository.findById(id).get();
    }

    @Override
    public Message save(Message message) {
        return this.messageRepository.save(message);
    }

    @Override
    public void delete(Integer id)
    {
        this.messageRepository.deleteById(id);
    }
}
