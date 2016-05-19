package src.test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import src.main.Cell;

public class CellTest {
	@Test
	public void cellIsCreatedWithAliveStatusOfTrue() {
		Cell myCell = new Cell(true, 1, 1, 5);
		assertEquals(true, myCell.isAlive());
	}
	
	@Test
	public void cellIsCreatedWithAliveStatusOfFalse() {
		Cell myCell = new Cell(false, 1, 1, 5);
		assertEquals(false, myCell.isAlive());
	}
	
	@Test
	public void cellIsCreatedWithAliveStatusOfTrueAndThanChangedToAliveStatusOfFalse() {
		Cell myCell = new Cell(true, 1, 1, 5);
		myCell.setAlive(false);
		
		assertEquals(false, myCell.isAlive());
	}
	
	@Test
	public void cellIsCreatedWithAliveStatusOfFalseAndThanChangedToAliveStatusOfTrue() {
		Cell myCell = new Cell(false, 1, 1, 5);
		myCell.setAlive(true);
		
		assertEquals(true, myCell.isAlive());
	}
	 
}
