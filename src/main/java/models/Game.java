package models;
import entities.*;
import java.util.ArrayList;

public class Game {
	
	private final int NUMBER_OF_PLAYERS = 2;
	private final int DEFAULT_GRID_ROWS = 5;
	private final int DEFAULT_GRID_COLS = 5;
	private final int DEFAULT_SHIPS = 5;
	private int gridRows;
	private int gridCols;
	private int numberOfShips;
	private int playerTurn;
	private int winner;
	private ArrayList<Player> players ;
	private Status gameStatus;
	private static Game gameInstance;

	private Game() {
		this.gridRows = DEFAULT_GRID_ROWS;
		this.gridCols = DEFAULT_GRID_COLS;
		this.numberOfShips = DEFAULT_SHIPS;
		this.players = new ArrayList<Player>();
		this.playerTurn = 0;
		this.gameStatus = Status.NOT_STARTED;
		this.winner = -1;
	}
		
	public static Game getInstance() {
		if(gameInstance == null) {
			initGame();
		}
		return gameInstance;
	}
	
	public static void initGame() {
		gameInstance = new Game();
;	}
	public boolean addPlayer(String name) {
		if(this.players.size()==NUMBER_OF_PLAYERS)
			return false;
		else {
			Player player = new Player(name, this.gridRows, this.gridCols, this.numberOfShips);
			this.players.add(player);
			if(this.players.size()==NUMBER_OF_PLAYERS)
				this.gameStatus = Status.ON_GOING;
			return true;
		}	
	}
	
	public void setGameSettings(int gridRows,int gridCols,int numberOfShips) {
		this.gridRows = gridRows;
		this.gridCols = gridCols;
		this.numberOfShips = numberOfShips;
		for(Player player:this.players) {
			player.initGrid(gridRows, gridCols, numberOfShips);
		}
	}
	

	public int getGridRows() {
		return gridRows;
	}

	public int getGridCols() {
		return gridCols;
	}

	public int getNumberOfShips() {
		return numberOfShips;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public int getPlayerTurn() {
		return playerTurn;
	}
	
	public Status getGameStatus() {
		return this.gameStatus;
	}
	
	public int getWinner() {
		return this.winner;
	}

	public void attack(int player, int row, int col) {
		this.players.get(player).getAttacked(row,col);
		this.playerTurn++;
		this.playerTurn = this.playerTurn%NUMBER_OF_PLAYERS;
		this.updateStatus();
		if(this.gameStatus == Status.GAME_OVER)
			this.updateWinner();
		
	}

	private void updateWinner() {
		for(int i=0;i<this.players.size();i++) {
			Player player = this.players.get(i);
			if(player.getAttackedShips()<player.getNumberOfShips())
				this.winner = i;
			
		}
		
	}

	private void updateStatus() {
		boolean gameOver = false;
		for(Player player:this.players) {
			gameOver = gameOver || (player.getAttackedShips()==player.getNumberOfShips());
		}
		if(gameOver)
			this.gameStatus = Status.GAME_OVER;
		
	}

	public void placeShip(int playerIndex, int row, int col) {
	    Player player = this.players.get(playerIndex);
		player.placeShip(row,col);
		if(player.getNonPlacedShips()==0) {
    		this.playerTurn++;
    		this.playerTurn = this.playerTurn%NUMBER_OF_PLAYERS;
		}
	}
   


}
