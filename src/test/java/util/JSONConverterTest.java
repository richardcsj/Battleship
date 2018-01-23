package util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Game;

public class JSONConverterTest {
	@Test
	public void gameObjectMustBeConvertedToJson() {
		Game game = Game.getInstance();
		String actual = JSONConverter.convert(game);
		String expected = "{\"NUMBER_OF_PLAYERS\":2,\"DEFAULT_GRID_ROWS\":5,\"DEFAULT_GRID_COLS\":5,\"DEFAULT_SHIPS\":5,\"gridRows\":5,\"gridCols\":5,\"numberOfShips\":5,\"playerTurn\":0,\"winner\":-1,\"players\":[],\"gameStatus\":\"NOT_STARTED\"}";
		assertEquals(expected,actual);
	}

}
