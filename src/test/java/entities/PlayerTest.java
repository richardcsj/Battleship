package entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest  {
	private final int numberOfRows = 5;
	private final int numberOfCols = 5;
	private final int numberOfShips = 5;
	@Test 
	public void gettersMustReturnTheAttributesValues() {
		Player player = new Player("Richard", numberOfRows, numberOfCols, numberOfShips);
		assertEquals("Richard", player.getName());
		assertEquals(5, player.getNumberOfShips());
		assertEquals(5, player.getNonPlacedShips());
		assertEquals(0, player.getAttackedShips());
		assertEquals(5, player.getGrid().getCells().length);
		assertEquals(5, player.getGrid().getCells()[0].length);
	}
	@Test
	public void whenPlayerPlacesShipNonPlacedShipsMustDecrease() {
		Player player = new Player("Richard", numberOfRows, numberOfCols, numberOfShips);
		player.placeShip(0, 0);
		assertEquals(4, player.getNonPlacedShips());
	}
	@Test 
	public void whenPlayerGetAttackedInEmptyPositionTheNumberOfAttackedShipsMustNotIncrease() {
		Player player = new Player("Richard", numberOfRows, numberOfCols, numberOfShips);
		player.getAttacked(0, 0);
		assertEquals(0, player.getAttackedShips());
	}
	@Test 
	public void whenPlayerGetAttackedInShpPositionTheNumberOfAttackedShipsMustIncrease() {
		Player player = new Player("Richard", numberOfRows, numberOfCols, numberOfShips);
		player.placeShip(0, 0);
		player.getAttacked(0, 0);
		assertEquals(1, player.getAttackedShips());
	}
	@Test
	public void initGridMustReintializeTheAttributes() {
		Player player = new Player("Richard", numberOfRows, numberOfCols, numberOfShips);
		player.placeShip(0, 0);
		assertEquals(4, player.getNonPlacedShips());
		player.getAttacked(0, 0);
		assertEquals(1, player.getAttackedShips());
		player.initGrid(numberOfRows, numberOfCols, numberOfShips);
		assertEquals(5, player.getNumberOfShips());
		assertEquals(5, player.getNonPlacedShips());
		assertEquals(0, player.getAttackedShips());
		
	}

}
