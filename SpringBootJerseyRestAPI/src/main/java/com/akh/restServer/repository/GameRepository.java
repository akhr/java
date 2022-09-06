package com.akh.restServer.repository;

import com.akh.restServer.entity.GameEntity;
import com.akh.restServer.model.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class GameRepository {

    public List<Game> getAllGames(){
        List<Game> games = new ArrayList<>();

        Game game1 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "India", "Pakistan", "2", "2");
        Game game2 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "India", "NewZealand", "1", "3");
        Game game3 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "India", "England", "5", "2");
        Game game4 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "England", "Pakistan", "6", "8");
        Game game5 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "England", "NewZealand", "3", "2");
        Game game6 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "NewZealand", "Pakistan", "2", "5");

        Game game7 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "India", "Pakistan", "2", "5");
        Game game8 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "India", "NewZealand", "4", "3");
        Game game9 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "India", "England", "1", "2");
        Game game10 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "England", "Pakistan", "5", "7");
        Game game11 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "England", "NewZealand", "5", "4");
        Game game12 = new Game(generateId(), "FIFA World Cup", 2011, "GroupA", "NewZealand", "Pakistan", "3", "7");

        games.add(game1);
        games.add(game2);
        games.add(game3);
        games.add(game4);
        games.add(game5);
        games.add(game6);
        games.add(game7);
        games.add(game8);
        games.add(game9);
        games.add(game10);
        games.add(game11);
        games.add(game12);

        return games;
    }

    private int generateId(){
        return ThreadLocalRandom.current().nextInt(1000, 2000);
    }
}
