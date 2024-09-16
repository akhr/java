package com.akh.restServer.service;

import com.akh.restServer.model.Game;
import com.akh.restServer.repository.GameRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

	@Mock
	GameRepository gameRepositoryMock;

	@InjectMocks
	GameService gameService;

	@Before
	public void setUp() throws Exception {
		Mockito.when(gameRepositoryMock.getAllGames()).thenReturn(getTestGamesList());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getAllGames() {
		List<Game> games = gameService.getAllGames();
		Assert.assertNotNull(games);
		Assert.assertEquals(12, games.size());
	}

	@Test
	public void getGamesOfATeam() {
		List<Game> actualGames = gameService.getGamesOfATeam("India");
		int expectedGamesCount = 6;
		Assert.assertEquals(expectedGamesCount, actualGames.size());
	}

	@Test
	public void getGamesBetweenTeams() {
		List<Game> actualGames = gameService.getGamesBetweenTeams("India", "Pakistan");
		int expectedGamesCount = 2;
		Assert.assertEquals(expectedGamesCount, actualGames.size());
	}

	private List<Game> getTestGamesList(){
		List<Game> games = new ArrayList<>();
		Game game1 = new Game(1, "FIFA World Cup", 2011, "GroupA", "India", "Pakistan", "2", "2");
		Game game2 = new Game(2, "FIFA World Cup", 2011, "GroupA", "India", "NewZealand", "1", "3");
		Game game3 = new Game(3, "FIFA World Cup", 2011, "GroupA", "India", "England", "5", "2");
		Game game4 = new Game(4, "FIFA World Cup", 2011, "GroupA", "England", "Pakistan", "6", "8");
		Game game5 = new Game(5, "FIFA World Cup", 2011, "GroupA", "England", "NewZealand", "3", "2");
		Game game6 = new Game(6, "FIFA World Cup", 2011, "GroupA", "NewZealand", "Pakistan", "2", "5");
		Game game7 = new Game(7, "FIFA World Cup", 2011, "GroupA", "Pakistan", "India", "2", "5");
		Game game8 = new Game(8, "FIFA World Cup", 2011, "GroupA", "India", "NewZealand", "4", "3");
		Game game9 = new Game(9, "FIFA World Cup", 2011, "GroupA", "India", "England", "1", "2");
		Game game10 = new Game(10, "FIFA World Cup", 2011, "GroupA", "England", "Pakistan", "5", "7");
		Game game11 = new Game(11, "FIFA World Cup", 2011, "GroupA", "England", "NewZealand", "5", "4");
		Game game12 = new Game(12, "FIFA World Cup", 2011, "GroupA", "NewZealand", "Pakistan", "3", "7");
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
}