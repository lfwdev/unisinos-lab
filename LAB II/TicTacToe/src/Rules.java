import java.util.ArrayList;
import java.util.List;

public class Rules {
	public int[][] gameBoard; // Two-dimensional integer array of the game board with all positions
	public int grid; // Size of the game board
	public int slots; // Slots per line
	public ArrayList<List> winningCombinations = new ArrayList<List>(); // 3x3 = [[1, 2, 3], [1, 4, 7], [4, 5, 6], [2, 5, 8], [7, 8, 9], [3, 6, 9], [1, 5, 9], [3, 5, 7]]
	
	public Rules(int slots, int grid) {
		
		this.grid = grid; // 3x3 = 9
		this.slots = slots; // 3x3 = 3
		this.gameBoard = buildGameBoard(); // 3x3 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
		this.setCombinationsForRowsAndCols(); // 3x3 = [1, 2, 3], [1, 4, 7], [4, 5, 6], [2, 5, 8], [7, 8, 9], [3, 6, 9]
		this.setCombinationsForDiagonal(); // 3x3 = [1, 5, 9]
		this.setCombinationsForAntiDiagonal(); // 3x3 = [3, 5, 7]

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
		
		for(int d = 0; d < this.grid; d = d + this.slots) {
			d1.add(this.gameBoard[x][y]);
			x++;
			y++;
		}
		this.winningCombinations.add(d1);
	}
	
	public void setCombinationsForAntiDiagonal() {
		ArrayList<Integer> d2 = new ArrayList<>();
		int x = 0;
		int y = this.slots - 1;
		
		for(int d = this.grid; d > 0; d = d - this.slots) {
			d2.add(this.gameBoard[x][y]);
			x++;
			y--;
		}
		this.winningCombinations.add(d2);
	}
}
