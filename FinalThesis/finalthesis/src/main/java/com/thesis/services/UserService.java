package com.thesis.services;

import com.thesis.exceptions.InvalidCredentialsException;
import com.thesis.exceptions.UserNotFound;
import com.thesis.exceptions.UserNotRegisteredException;
import com.thesis.exceptions.UserSessionException;
import com.thesis.persistence.model.User;
import com.thesis.persistence.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements ModelService<User> {
    public static final String USER_REGISTERED_EXCEPTION = "--USER IS REGISTERED ALREADY--";
    public static final String INVALID_CREDENTIALS_EXCEPTION = "--INVALID CREDENTIALS--";
    public static final String USER_NOT_FOUND_EXCEPTION = "--USER NOT FOUND--";
    public static final String USER_NOT_LOGGED_IN_EXCEPTION = "--USER HAS NOT LOGGED IN--";
    public static final String USER_LOGGED_IN_EXCEPTION = "--USER IS LOGGED IN--";

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


    public boolean isRegistered(Integer id, String username) // throws Exception
    {
        Optional<User> user = this.userRepository.findByIdentificationOrUserName(id, username).stream().findFirst();
        if (!user.isPresent())
            return false;
        //throw new UserNotRegisteredException(NOT_REGISTERED_EXCEPTION);
        return true;
    }

    public boolean couldRegisterUser(User user) throws Exception
    {
        if (!this.isRegistered(user.getIdentification(), user.getUserName())) {
            this.save(user);
            return true;
        }
        throw new UserNotRegisteredException(USER_REGISTERED_EXCEPTION);
    }

    public User loggedIn(String userName, String password) throws Exception
    {
        Optional<User> user = this.userRepository.findByUserNameAndPassword(userName, password).stream().findFirst();

        if(user.isPresent()) {
            User userTemp = user.get();
            if(userTemp.isActive())
                throw new UserSessionException(USER_LOGGED_IN_EXCEPTION);

            userTemp.setActive(true);
            return this.userRepository.save(userTemp);
        }
        throw new InvalidCredentialsException(INVALID_CREDENTIALS_EXCEPTION);
    }

    public User logout(String username) throws Exception
    {
        Optional<User>user = this.userRepository.findByUserName(username).stream().findFirst();

        if(user.isEmpty())
            throw new UserNotFound(USER_NOT_FOUND_EXCEPTION);
        else
        {
            User userTemp = user.get();
            if(!userTemp.isActive())
                throw new UserSessionException(USER_NOT_LOGGED_IN_EXCEPTION);

            userTemp.setActive(false);
            return this.userRepository.save(userTemp);
        }
    }

}
