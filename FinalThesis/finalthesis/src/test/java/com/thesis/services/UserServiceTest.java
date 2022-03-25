package com.thesis.services;

import com.thesis.exceptions.InvalidCredentialsException;
import com.thesis.exceptions.UserNotFoundException;
import com.thesis.exceptions.UserNotRegisteredException;
import com.thesis.exceptions.UserSessionException;
import com.thesis.persistence.model.Message;
import com.thesis.persistence.model.User;
import com.thesis.persistence.repository.IUserRepository;
import com.thesis.utils.EmailVisibility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class UserServiceTest
{
    @Mock
    private IUserRepository userRepository;

    @Mock
    private MessageService messageService;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
        Mockito.when(userRepository.findAll()).thenReturn(getUsers());
        Mockito.when(userRepository.findByIdentificationOrUserName(Mockito.anyInt(), Mockito.any())).thenReturn(
                Arrays.asList(new User(987665, "monica","1234","Monica", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja"))
        );
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(null);
        Mockito.when(userRepository.findByUserNameAndPassword(Mockito.any(), Mockito.any())).
                thenReturn(Arrays.asList());


        Mockito.when(userRepository.findByUserName(Mockito.any())).thenReturn(Arrays.asList(
                new User(987665, "monica","1234","Monica", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja"))
        );


    }


    @Test
    public void return_true_if_user_exits()
    {
        Assertions.assertEquals(true, this.userService.isRegistered(123, "juanca"));
    }

    @Test
    public void fails_if_user_could_not_be_registered()
    {
        Exception ex = Assertions.assertThrows(UserNotRegisteredException.class, ()-> this.userService.couldRegisterUser(
                new User(987, "moca", "12","Monica", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja")
        ));
        Assertions.assertEquals(UserService.USER_REGISTERED_EXCEPTION, ex.getMessage());
    }

    @Test
    public void fail_if_cannot_log_in()
    {
        Exception ex = Assertions.assertThrows(InvalidCredentialsException.class,()-> this.userService.loggedIn("monica", "123"));
        Assertions.assertEquals(userService.INVALID_CREDENTIALS_EXCEPTION, ex.getMessage());
    }

    @Test
    public void fail_if_cannot_log_out()
    {
        Exception ex = Assertions.assertThrows(UserNotFoundException.class, ()-> this.userService.logout("juanca"));
        Assertions.assertEquals(UserService.USER_NOT_FOUND_EXCEPTION, ex.getMessage());
    }

    @Test
    public void return_true_if_finds_one()
    {
        Optional<User>user = this.userService.findByUsername(Mockito.any()).stream().findFirst();
        Assertions.assertEquals(new User(987665, "monica","1234","Monica", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja")
                , user.get());
    }

    @Test
    public void fails_if_message_is_not_sent_because_user_does_not_exists()
    {
        String username = "monicaaaa";
        Message tempMessage = new Message("spiderman","monica", "Tony Stark", "This is the test", "Hello kid! Im a text", "doc.pdf" );
        Exception ex = Assertions.assertThrows(UserNotFoundException.class, ()->this.userService.sendMessage(username, tempMessage));
        Assertions.assertEquals(this.userService.USER_NOT_FOUND_EXCEPTION, ex.getMessage());
    }

    @Test
    public void fails_when_user_is_not_logged_in()
    {
        String username = "monicaaaa";
        Message tempMessage = new Message("spiderman","monica", "Tony Stark", "This is the test", "Hello kid! Im a text", "doc.pdf" );
        Exception ex = Assertions.assertThrows(UserSessionException.class, ()->this.userService.sendMessage(username, tempMessage));
        Assertions.assertEquals(this.userService.USER_NOT_LOGGED_IN_EXCEPTION, ex.getMessage());
    }

    public List<User>getUsers()
    {
        User user1 = new User(1003456, "juanca","12","Juan Camilo", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja");
        User user2 = new User(12345,"juanda", "12","Juan David", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja");
        User user3 = new User(2345,"will", "12","William", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja");
        User user4 = new User(987665, "monica", "12","Monica", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja");

        return new ArrayList<>(Arrays.asList(user1, user2, user3, user4));
    }



}