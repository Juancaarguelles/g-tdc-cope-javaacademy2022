package com.thesis.services;

import com.thesis.exceptions.InvalidCredentialsException;
import com.thesis.exceptions.UserNotFoundException;
import com.thesis.exceptions.UserNotRegisteredException;
import com.thesis.exceptions.UserSessionException;
import com.thesis.persistence.model.Message;
import com.thesis.persistence.model.User;
import com.thesis.persistence.repository.IUserRepository;
import com.thesis.utils.EmailVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService implements ModelService<User> {
    public static final String USER_REGISTERED_EXCEPTION = "--USER IS REGISTERED ALREADY--";
    public static final String INVALID_CREDENTIALS_EXCEPTION = "--INVALID CREDENTIALS--";
    public static final String USER_NOT_FOUND_EXCEPTION = "--USER NOT FOUND--";
    public static final String USER_NOT_LOGGED_IN_EXCEPTION = "--USER HAS NOT LOGGED IN--";
    public static final String USER_LOGGED_IN_EXCEPTION = "--USER IS LOGGED IN--";

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private MessageService messageService;

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

    public Optional<User> findByUsername(String username)
    {
        return this.userRepository.findByUserName(username).stream().findFirst();
    }

    public User logout(String username) throws Exception
    {
        Optional<User> user = findByUsername(username);

        if(user.isEmpty())
            throw new UserNotFoundException(USER_NOT_FOUND_EXCEPTION);
        else
        {
            User userTemp = user.get();
            if(!userTemp.isActive())
                throw new UserSessionException(USER_NOT_LOGGED_IN_EXCEPTION);

            userTemp.setActive(false);
            return this.userRepository.save(userTemp);
        }
    }

    public void setDestinationAndCCOfMessage(String[]destinations, Message message, EmailVisibility visibility)
    {
        Message tempMessage = new Message(message);

        if(visibility == EmailVisibility.HIDDEN)
        tempMessage.setBcc("");

        Stream.of(destinations).forEach(userName ->{

            Optional<User>userTemp = this.findByUsername(userName);

            if(userTemp.isPresent() && userTemp.get().isActive()) {
                userTemp.get().addToReceivedMessages(tempMessage);
                userTemp.get().addToAllMessages(tempMessage);
                this.userRepository.save(userTemp.get());
            }
        });
    }


    public boolean sendMessage(String username, Message message) throws Exception
    {
        Optional<User>user = this.findByUsername(username);

        if(!user.isEmpty())
        {
            if(user.get().isActive())
            {
                message.setOrigin(user.get().getUserName());
                user.get().addToAllMessages(message);
                user.get().addToSentMessages(message);
                this.userRepository.save(user.get());

                String[]bcc = message.getBcc().split("[\\s,]+");
                this.setDestinationAndCCOfMessage(bcc, message, EmailVisibility.VISIBLE);

                String[]destinations = message.getDestination().split("[\\s,]+");
                //this.setDestinationAndCCOfMessage(destinations,message, EmailVisibility.HIDDEN);
                String[]cc = message.getCc().split("[\\s,]+");
                String[]destinationsCC = Stream.concat(Arrays.stream(destinations), Arrays.stream(cc)).
                        toArray(String[]::new);
                this.setDestinationAndCCOfMessage(destinationsCC, message, EmailVisibility.HIDDEN);

                return true;
            }
            else
            {
                throw new UserSessionException(USER_NOT_LOGGED_IN_EXCEPTION);
            }
        }
        throw new UserNotFoundException(USER_NOT_FOUND_EXCEPTION);
    }

}
