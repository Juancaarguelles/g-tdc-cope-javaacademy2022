package com.GameSystem.repository;

import com.GameSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer>
{

}
