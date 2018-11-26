package board;

import java.util.List;

import unit.Unit;

public class Board {
	
	private int width, height;
	private Tile[][] board;
	
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		createBoard();
	}
	
	public void createBoard() {
		board = new Tile[width][height];
	}
	
	public Tile getTile(int x, int y) {
		return board[x][y];
	}
	
	public void addUnit(int x, int y, Unit units) {
		board[x][y].setUnits(units);
	}
	
	public List<Unit> getUnit(int x, int y) {
		return board[x][y].getUnits();
	}

}