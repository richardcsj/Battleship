package entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GridTest {
	
	private final int numberOfRows = 2;
	private final int numberOfCols = 2;
	
	@Test
	public void whenWeCreateGridWeMustHaveEmptySpotsInCells() {
		Grid grid = new Grid(numberOfRows, numberOfCols);
		Cell[][] cells = {{Cell.EMPTY,Cell.EMPTY},{Cell.EMPTY,Cell.EMPTY}};
		for(int i=0;i<grid.getCells().length;i++) {
			for(int j=0;j<grid.getCells()[i].length;j++) {
				assertEquals(grid.getCells()[i][j], cells[i][j]);
			}
		}
		
	}
	@Test
	public void placingAShipMustChangeTheGrid() {
		Grid grid = new Grid(numberOfRows, numberOfCols);
		Cell[][] cellsBefore = {
								{Cell.EMPTY,Cell.EMPTY},
								{Cell.EMPTY,Cell.EMPTY}
								};
		Cell[][] cellsAfter = {
								{Cell.SHIP,Cell.EMPTY},
								{Cell.EMPTY,Cell.EMPTY}
								};
		
		for(int i=0;i<grid.getCells().length;i++) {
			for(int j=0;j<grid.getCells()[i].length;j++) {
				assertEquals(grid.getCells()[i][j], cellsBefore[i][j]);
			}
		}
		
		grid.place(0, 0);
		
		for(int i=0;i<grid.getCells().length;i++) {
			for(int j=0;j<grid.getCells()[i].length;j++) {
				assertEquals(grid.getCells()[i][j], cellsAfter[i][j]);
			}
		}
	}
	
	@Test
	public void attackingEmtySpotMakeItAlreadyTaken() {
		Grid grid = new Grid(numberOfRows, numberOfCols);
		Cell[][] cellsBefore = {
								{Cell.EMPTY,Cell.EMPTY},
								{Cell.EMPTY,Cell.EMPTY}
								};
		Cell[][] cellsAfter = {
								{Cell.ALREADY_TAKEN,Cell.EMPTY},
								{Cell.EMPTY,Cell.EMPTY}
								};
		
		for(int i=0;i<grid.getCells().length;i++) {
			for(int j=0;j<grid.getCells()[i].length;j++) {
				assertEquals(grid.getCells()[i][j], cellsBefore[i][j]);
			}
		}
		
		grid.attack(0, 0);
		
		for(int i=0;i<grid.getCells().length;i++) {
			for(int j=0;j<grid.getCells()[i].length;j++) {
				assertEquals(grid.getCells()[i][j], cellsAfter[i][j]);
			}
		}
	}
	@Test
	public void attackingAShipMakeItSunkenShip() {
		Grid grid = new Grid(numberOfRows, numberOfCols);
		Cell[][] cellsBefore = {
								{Cell.SHIP,Cell.EMPTY},
								{Cell.EMPTY,Cell.EMPTY}
								};
		Cell[][] cellsAfter = {
								{Cell.SUNKEN_SHIP,Cell.EMPTY},
								{Cell.EMPTY,Cell.EMPTY}
								};
		grid.place(0, 0);
		for(int i=0;i<grid.getCells().length;i++) {
			for(int j=0;j<grid.getCells()[i].length;j++) {
				assertEquals(grid.getCells()[i][j], cellsBefore[i][j]);
			}
		}
		
		grid.attack(0, 0);
		
		for(int i=0;i<grid.getCells().length;i++) {
			for(int j=0;j<grid.getCells()[i].length;j++) {
				assertEquals(grid.getCells()[i][j], cellsAfter[i][j]);
			}
		}
	}

}
