import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rules {
	public int[][] gameBoard;
	public int grid;
	public int slots;
	public int slotsPerLine;
	public ArrayList<List> winningCombinations = new ArrayList<List>();
	
	public Rules(int slots, int grid) {
		
		this.grid = grid;
		this.slots = slots;
		this.slotsPerLine = grid;
		this.gameBoard = buildGameBoard();
		this.setCombinationsForRowsAndCols();
		this.setCombinationsForDiagonal();
		this.setCombinationsForAntiDiagonal();
	
		System.out.println("");
		System.out.println(this.winningCombinations);
		System.out.println("");
	}
	
	public int[][] buildGameBoard() {
		int[][] gameBoard =  new int[this.slots][this.slots];
	
		int position = 1;
		
		for(int x = 0; x < slots; x++) {
			for(int y = 0; y < slots; y++) { 
				gameBoard[x][y] = position;
				position++;
			}
		}
		
		return gameBoard;
	}
	
	public void setCombinationsForRowsAndCols() {
		for (int c = 0; c < this.slots; c++ ) {
			
			ArrayList<Integer> c1 = new ArrayList<>();
			ArrayList<Integer> c2 = new ArrayList<>();
			
			for(int x = 0; x < this.slots; x++) {
				c1.add(this.gameBoard[c][x]);
				c2.add(this.gameBoard[x][c]);
			}
			this.winningCombinations.add(c1);
			this.winningCombinations.add(c2);
		}
	}
	
	public void setCombinationsForDiagonal() {
		ArrayList<Integer> d1 = new ArrayList<>();
		int x = 0;
		int y = 0;
		
		for(int d = 0; d < grid; d = d + slots) {
			d1.add(this.gameBoard[x][y]);
			x++;
			y++;
		}
		this.winningCombinations.add(d1);
	}
	
	public void setCombinationsForAntiDiagonal() {
		ArrayList<Integer> d2 = new ArrayList<>();
		int x = 0;
		int y = slots - 1;
		
		for(int d = grid; d > 0; d = d - slots) {
			d2.add(this.gameBoard[x][y]);
			x++;
			y--;
		}
		this.winningCombinations.add(d2);

	}
}
