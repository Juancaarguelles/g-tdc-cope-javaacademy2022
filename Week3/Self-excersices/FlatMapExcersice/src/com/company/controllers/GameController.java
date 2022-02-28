package com.company.controllers;

import com.company.models.Game;

import java.util.ArrayList;
import java.util.List;

public class GameController extends AbstractController
{
    private static GameController gameController;

    private GameController()
    {
        super();
    }

    @Override
    public boolean create(Object... args)
    {
        try
        {
            this.getObjects().add(new Game((Integer) args[Game.ID], (String)args[Game.NAME], (Float) args[Game.PRICE]));
            return true;
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void readList()
    {
        if(this.getObjects().size() > 0) {
            this.getObjects().forEach(o -> {
                Game game = ((Game) o);
                System.out.println(game);
            });
        }else
            System.out.println("--THERE IS NO GAMES YET--");
    }

    @Override
    public boolean update(int index, Object... args)
    {
        try
        {
            this.getObjects().set(index, new Game((Integer)args[Game.ID], (String)args[Game.NAME], (Float)args[Game.PRICE]));
            return true;
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static GameController getGameController()
    {
        if(gameController == null)
            gameController = new GameController();
        return gameController;
    }

}
