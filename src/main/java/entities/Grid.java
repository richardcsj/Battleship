package entities;

public class Grid {
	
	private Cell[][] cells;
	
	public Grid(int gRows, int gCols) {
		
		this.cells = new Cell[gRows][gCols];	
		for(int i=0;i<gRows;i++) {
			for(int j=0;j<gCols;j++) {
				this.cells[i][j] = Cell.EMPTY;
			}
		}
	}

	public Cell[][] getCells() {
		return cells;
	}

	public boolean attack(int row, int col) {
		switch(cells[row][col]) {
			case EMPTY : 
				cells[row][col] = Cell.ALREADY_TAKEN;
				return false; 
			case SHIP : 
				cells[row][col] = Cell.SUNKEN_SHIP;
				return true;
		default:
			return false;
		}
		
	}

	public void place(int row, int col) {
		cells[row][col] = Cell.SHIP;
		
	}
	
	

}
