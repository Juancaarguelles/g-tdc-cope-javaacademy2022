package com.GameSystem.service;

import com.GameSystem.model.User;
import com.GameSystem.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    private IUserRepository userRepository;

    public List<User> listUsers()
    {
        return userRepository.findAll();
    }

    public void saveUser(User user)
    {
        this.userRepository.save(user);
    }

    public User getUser(Integer id)
    {
        return this.userRepository.findById(id).get();
    }

    public void deleteUser(Integer id)
    {
        this.userRepository.deleteById(id);
    }
}
