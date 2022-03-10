package com.GameSystem.repository;

import com.GameSystem.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameRepository extends JpaRepository<Game, Integer>
{

}
