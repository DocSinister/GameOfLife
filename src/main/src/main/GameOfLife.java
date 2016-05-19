/**
 * 
 */
package src.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

/**
 * @author J. Michael Brewer
 *
 */
public class GameOfLife {
	private static final int DEFAULT_WIDTH = 60;
	private static final int DEFAULT_HEIGHT = 60;
	private static final int DEFAULT_SIZE = 5;
	private static final int MAX_ITERATIONS = 1000;
	
	private static Cell[][] board;
	private static ArrayList<Cell> cellList;
	private static long seed;
	private static Random rand;
	private static JFrame window;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		seed = System.currentTimeMillis();
		rand = new Random(seed);
		cellList = new ArrayList<>();
		//display = new DisplayArea(20, 20);
		window = new JFrame();
	    
		generateBoard();
		
		createAndShowDisplay();
		
		for(int i = 0; i < MAX_ITERATIONS; i++) {
			updateLife();
			drawCells();
		}
	}
	
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void createAndShowDisplay() {       
		window = new JFrame();
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(30, 30, 300, 300);
	    window.getContentPane().add(new CellImages(20, 20, 300, 300));
	    window.setVisible(true);
	    
	    drawCells();
    }
	
	private static void drawCells() {
		Graphics g = window.getContentPane().getGraphics();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j].isAlive()) {
					g.setColor(Color.BLUE);
				} else {
					g.setColor(Color.WHITE);
				}
				g.fill3DRect(j * DEFAULT_SIZE, i * DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SIZE, true);
			}
		}
	}
	
	private static void generateBoard() {		
		board = new Cell[DEFAULT_HEIGHT][DEFAULT_WIDTH];
		
		fillBoardWithLife();
		setCellNeighbors();
	}
	
	private static void fillBoardWithLife() {
		Cell[] row;
		Cell newCell;
		
		for(int i = 0; i < getBoardHeight(); i++) {
			row = new Cell[getBoardWidth()];
			for(int j = 0; j < row.length; j++) {
				newCell = new Cell(getRandomState(), j, i, DEFAULT_SIZE);
				row[j] = newCell;
				cellList.add(newCell);
			}
			
			board[i] = row;
		}
	}
	
	private static void setCellNeighbors() {
		Cell tmpCell;
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				tmpCell = board[i][j];
				setANeighborState(tmpCell, j - 1, i - 1, 0);
				setANeighborState(tmpCell, j    , i - 1, 1);
				setANeighborState(tmpCell, j + 1, i - 1, 2);
				setANeighborState(tmpCell, j - 1, i, 3);
				setANeighborState(tmpCell, j + 1, i, 4);
				setANeighborState(tmpCell, j - 1, i + 1, 5);
				setANeighborState(tmpCell, j    , i + 1, 6);
				setANeighborState(tmpCell, j + 1, i + 1, 7);
			}
		}
	}

	private static void setANeighborState(Cell myCell, int x, int y, int index) {
		if(x >= 0 && y >= 0 && y < board.length && x < board[y].length ) {
			myCell.setNeighborState(board[y][x].isAlive(), index);
		} else {
			myCell.setNeighborState(false, index);
		}
		
	}
	
	private static void updateLife() {
		int numNeighbors = 0;
		Cell myCell;
		
		for(int i = 0; i < cellList.size(); i++) {
			myCell = cellList.get(i);
			numNeighbors = myCell.checkMyNeighbors();
			if(numNeighbors < 2 || numNeighbors > 3) {
				myCell.setAlive(false);;
			} else {
				myCell.setAlive(true);
			}
		}
		
		setCellNeighbors();
	}
	
	/*
	 * Return a boolean value to represent the state
	 * of a new cell.
	 * 
	 * true == alive, false == dead;
	 */
	private static boolean getRandomState() {
		return rand.nextBoolean();
	}
	
	/***** Accessors & Mutators *****/
	public static int getBoardWidth() {
		int width = 0;
		
		if(board != null) {
			width = board[0].length;
		}
		
		return width;
	}
	
	public static int getBoardHeight() {
		int height = 0;
		
		if(board != null) {
			height = board.length;
		}
		
		return height;
	}
	
	
}
