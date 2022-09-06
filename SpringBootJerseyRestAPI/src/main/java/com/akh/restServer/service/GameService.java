package com.akh.restServer.service;

import com.akh.restServer.model.Game;
import com.akh.restServer.repository.GameRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames(){
        return gameRepository.getAllGames();
    }

    public List<Game> getGamesOfATeam(String team){
        List<Game> allGames = getAllGames();

        List<Game> filterGames = allGames.stream()
                .filter(new Predicate<Game>() {
                    @Override
                    public boolean test(Game game) {
                        return (game.getTeam1().equalsIgnoreCase(team) || game.getTeam2().equalsIgnoreCase(team));
                    }
                }).collect(Collectors.toList());
        return filterGames;
    }

    public List<Game> getGamesBetweenTeams(String team1, String team2){
        List<Game> allGames = getAllGames();

        if (team1 == null && team2 == null)
            return allGames;

        List<Game> filterGames = allGames.stream()
                .filter(new Predicate<Game>() {
                    @Override
                    public boolean test(Game game) {
                        return (game.getTeam1().equalsIgnoreCase(team1) && game.getTeam2().equalsIgnoreCase(team2)) ||
                                (game.getTeam1().equalsIgnoreCase(team2) && game.getTeam2().equalsIgnoreCase(team1));
                    }
                }).collect(Collectors.toList());
        return filterGames;
    }
}
