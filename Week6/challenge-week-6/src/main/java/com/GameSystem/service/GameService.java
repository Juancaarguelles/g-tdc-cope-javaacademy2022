package com.GameSystem.service;

import com.GameSystem.model.Game;
import com.GameSystem.repository.IGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService
{
    @Autowired
    private IGameRepository gameRepository;

    public List<Game>listGames()
    {
        return this.gameRepository.findAll();
    }

    public Game getGame(Integer id)
    {
        return this.gameRepository.findById(id).get();
    }

    public void saveGame(Game game)
    {
        this.gameRepository.save(game);
    }

    public void deleteGame(Integer id)
    {
        this.gameRepository.deleteById(id);
    }
}
