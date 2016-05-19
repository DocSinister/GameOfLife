package src.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.GameOfLife;

public class GameOfLifeTest {	
	@Test
	public void shouldCreatBoardWidthOfEight() {
		//Given that default board sized is 8x6
		GameOfLife myGame = new GameOfLife();
		
		myGame.main(null);
		
		//GameOfLife will generate a play area that is 8 wide
		assertEquals(8, myGame.getBoardWidth());
	}
	
	@Test
	public void shouldCreateBoardHeightOfSix() {
		//Given that default board sized is 8x6
		GameOfLife myGame = new GameOfLife();
		
		myGame.main(null);
		
		//GameOfLife will generate a play area that is 6 high
		assertEquals(6, myGame.getBoardHeight());
	}
}