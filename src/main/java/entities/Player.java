package entities;

public class Player {

	private String name;
	private Grid grid;
	private int numberOfShips;
	private int nonPlacedShips;
	private int attackedShips;
	
	public Player(String name,int gridRows, int gridCols, int numberOfShips) {
		this.name = name;
		this.grid = new Grid(gridRows, gridCols);
		this.numberOfShips = numberOfShips;
		this.nonPlacedShips = numberOfShips;
		this.attackedShips = 0;
	}

	public String getName() {
		return name;
	}

	public Grid getGrid() {
		return grid;
	}

	public int getNumberOfShips() {
		return numberOfShips;
	}
	
	public int getNonPlacedShips() {
		return nonPlacedShips;
	}

	public int getAttackedShips() {
		return attackedShips;
	}

	public void initGrid(int gridRows, int gridCols, int numberOfShips) {
		
		this.grid = new Grid(gridRows,gridCols);
		this.numberOfShips = numberOfShips;
		this.nonPlacedShips = numberOfShips;
		this.attackedShips = 0;
	}

	public void getAttacked(int row, int col) {
		boolean sunk = this.grid.attack(row,col);
		if(sunk)
			this.attackedShips++;
			
		
	}

	public void placeShip(int row, int col) {
		this.grid.place(row,col);
		this.nonPlacedShips--;
		
	}
	
	

}
