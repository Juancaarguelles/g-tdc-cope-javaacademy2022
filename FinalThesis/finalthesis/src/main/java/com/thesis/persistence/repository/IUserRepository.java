package com.thesis.persistence.repository;

import com.thesis.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>
{
   List<User> findByIdentificationOrUserName(int id, String username);
   List<User>findByUserNameAndPassword(String userName, String password);
   List<User>findByUserName(String username);
}
