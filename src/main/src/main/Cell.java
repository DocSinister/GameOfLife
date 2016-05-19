package src.main;

import java.util.ArrayList;

public class Cell {
	private boolean alive;
	private ArrayList<Boolean> neighborsState;
	
	public Cell(boolean alive, int x, int y, int size) {
		initNeighborState();
		
		this.setAlive(alive);
	}
	
	private void initNeighborState() {
		neighborsState = new ArrayList<>();
		
		for(int i = 0; i < 8; i++) {
			neighborsState.add(false);
		}
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void setNeighborState(boolean isAlive, int index) {
		neighborsState.set(index, isAlive);	
	}
	
	public int checkMyNeighbors() {
		int count = 0;
		boolean isAlive;
		
		for(int i = 0; i < neighborsState.size(); i++) {
			isAlive = neighborsState.get(i);
			if(isAlive) {
				count++;
			}
		}
		
		return count;
	}
}
