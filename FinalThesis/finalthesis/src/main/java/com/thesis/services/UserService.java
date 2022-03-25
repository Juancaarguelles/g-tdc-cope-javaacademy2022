package com.thesis.services;

import com.thesis.exceptions.UserNotRegisteredException;
import com.thesis.persistence.model.User;
import com.thesis.persistence.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements ModelService<User> {
    public static final String USER_REGISTERED_EXCEPTION = "--USER IS REGISTERED ALREADY--";

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        this.userRepository.deleteById(id);
    }


    public boolean isRegistered(String username) // throws Exception
    {
        Optional<User> user = this.userRepository.findByUserName(username).stream().findFirst();

        if (!user.isPresent())
            return false;
        //throw new UserNotRegisteredException(NOT_REGISTERED_EXCEPTION);
        return true;
    }

    public boolean couldRegisterUser(User user) throws Exception
    {
        if (!this.isRegistered(user.getUserName())) {
            this.save(user);
            return true;
        }
        throw new UserNotRegisteredException(USER_REGISTERED_EXCEPTION);
    }
}
