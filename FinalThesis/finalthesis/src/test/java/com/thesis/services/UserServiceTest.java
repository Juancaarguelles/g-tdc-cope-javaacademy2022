package com.thesis.services;

import com.thesis.exceptions.UserNotRegisteredException;
import com.thesis.persistence.model.User;
import com.thesis.persistence.repository.IUserRepository;
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

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest
{
    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
        Mockito.when(userRepository.findAll()).thenReturn(getUsers());
        Mockito.when(userRepository.findByUserName(Mockito.any())).thenReturn(
                Arrays.asList(new User())
        );
    }


    @Test
    public void return_true_if_user_exits()
    {
        /*Exception ex = Assertions.assertThrows(UserNotRegisteredException.class, ()
                ->this.userService.isRegistered(Mockito.any()));*/

        //Assertions.assertEquals(UserService.USER_REGISTERED_EXCEPTION, ex.getMessage());

        Assertions.assertEquals(true, this.userService.isRegistered(Mockito.any()));
    }

    public List<User>getUsers()
    {
        User user1 = new User("juanca","Juan Camilo", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja");
        User user2 = new User("juanda","Juan David", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja");
        User user3 = new User("will","William", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja");
        User user4 = new User("monica","Monica", "Arguelles Ardila", "Cra 2 # 32-49", "1234455", "Boyaca", "Tunja");

        return new ArrayList<>(Arrays.asList(user1, user2, user3, user4));
    }



}