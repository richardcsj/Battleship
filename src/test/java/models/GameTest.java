package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entities.Status;

public class GameTest {
	private final int numberOfRows = 2;
	private final int numberOfCols = 2;
	private final int numberOfShips = 1;
	
	private Game game;
	
	@Before
	public void initialize() {
		this.game = Game.getInstance();
		
	}
	@Test
	public void initGameMustInitializeGameWithDefaultValues() {
		Game.initGame();
		this.game = Game.getInstance();
		assertEquals(Status.NOT_STARTED, this.game.getGameStatus());
		assertEquals(5, this.game.getGridCols());
		assertEquals(5, this.game.getGridRows());
		assertEquals(5, this.game.getNumberOfShips());
		assertEquals(0, this.game.getPlayers().size());
		assertEquals(0, this.game.getPlayerTurn());
		assertEquals(-1, this.game.getWinner());
		
	}
	@Test
	public void setSettingsShouldChangeGameSettings() {
		Game.initGame();
		this.game = Game.getInstance();
		this.game.setGameSettings(numberOfRows, numberOfCols, numberOfShips);
		assertEquals(Status.NOT_STARTED, this.game.getGameStatus());
		assertEquals(2, this.game.getGridCols());
		assertEquals(2, this.game.getGridRows());
		assertEquals(1, this.game.getNumberOfShips());
		assertEquals(0, this.game.getPlayers().size());
		assertEquals(0, this.game.getPlayerTurn());
		assertEquals(-1, this.game.getWinner());
	}
	@Test
	public void addPlayerShouldAddPlayerToTheListOfPlayers() {
		Game.initGame();
		this.game = Game.getInstance();
		this.game.setGameSettings(numberOfRows, numberOfCols, numberOfShips);
		this.game.addPlayer("Richard");
		assertEquals(Status.NOT_STARTED, this.game.getGameStatus());
		assertEquals(1, this.game.getPlayers().size());
		assertEquals("Richard", this.game.getPlayers().get(0).getName());
	}
	@Test
	public void gameStatusMustChangeToOnGoingWhenWeAddTwoPlayers() {
		Game.initGame();
		this.game = Game.getInstance();
		this.game.setGameSettings(numberOfRows, numberOfCols, numberOfShips);
		this.game.addPlayer("Richard");
		this.game.addPlayer("Chun");
		assertEquals(Status.ON_GOING, this.game.getGameStatus());
		assertEquals(2, this.game.getPlayers().size());
		assertEquals("Richard", this.game.getPlayers().get(0).getName());
		assertEquals("Chun", this.game.getPlayers().get(1).getName());
	}
	@Test
	public void weCantAddPlayersIfWeReachTheMaxNumberOfPlayers() {
		Game.initGame();
		this.game = Game.getInstance();
		this.game.setGameSettings(numberOfRows, numberOfCols, numberOfShips);
		this.game.addPlayer("Richard");
		boolean added = this.game.addPlayer("Chun");
		assertTrue(added);
		added = this.game.addPlayer("test");
		assertFalse(added);
		assertEquals(Status.ON_GOING, this.game.getGameStatus());
		assertEquals(2, this.game.getPlayers().size());
		assertEquals("Richard", this.game.getPlayers().get(0).getName());
		assertEquals("Chun", this.game.getPlayers().get(1).getName());
	}
	@Test
	public void whenfirstPlayerPlacesHisShipThePlayerTurnMustChange() {
		Game.initGame();
		this.game = Game.getInstance();
		this.game.setGameSettings(numberOfRows, numberOfCols, numberOfShips);
		this.game.addPlayer("Richard");
		this.game.addPlayer("Chun");
		this.game.placeShip(0, 0, 0);
		assertEquals(1, this.game.getPlayerTurn());
	}
	
	@Test
	public void whenSecondPlayerGetAttackedThePlayerTurnMustChenge() {
		Game.initGame();
		this.game = Game.getInstance();
		this.game.setGameSettings(numberOfRows, numberOfCols, numberOfShips);
		this.game.addPlayer("Richard");
		this.game.addPlayer("Chun");
		this.game.attack(0, 0, 0);
		assertEquals(1, this.game.getPlayerTurn());
	}
	@Test
	public void whenSecondPlayerGetAllHisShipsSunkenTheGameIsOVerAndTheFirstPlayerIsTheWinner() {
		Game.initGame();
		this.game = Game.getInstance();
		this.game.setGameSettings(numberOfRows, numberOfCols, numberOfShips);
		this.game.addPlayer("Richard");
		this.game.addPlayer("Chun");
		this.game.placeShip(0, 0, 0);
		this.game.placeShip(1, 0, 0);
		this.game.attack(1,0,0);
		assertEquals(1, this.game.getPlayerTurn());
		assertEquals(Status.GAME_OVER, this.game.getGameStatus());
		assertEquals(0, this.game.getWinner());
	}
}
