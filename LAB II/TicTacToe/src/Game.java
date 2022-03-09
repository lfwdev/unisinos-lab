import java.util.Arrays;
import java.util.List;

public class Game {
	public int size;
	private Player player1 = new Player();
	private Player player2 = new Player();
	public Player winner;
	public static String[] options = {"X","O"};
	public int gridSize;
	protected String[] gameSlotState;
	protected Boolean[] gameSlotAvailability;
	public Rules rules;
	
	public Game() {
		this.player1.setSymbol(options[0]);
		this.player2.setSymbol(options[1]);
		this.player1.setName();
		this.player2.setName();
		this.newGame();
	}
	
	public void setWinner(Player player) {
		this.winner = player;
	}
	
	public void newGame() {
		this.size = Ui.promptForBoardSize();
		this.gridSize = (this.size) * (this.size);
		this.rules = new Rules(this.size,this.gridSize);
		this.resetState();
		this.play();
	}

	public void resetState() {
		this.player1.resetState();
		this.player2.resetState();
		this.setWinner(new Player());
		this.gameSlotState = new String[this.gridSize + 1];
		this.gameSlotAvailability = new Boolean[this.gridSize + 1];
		this.setSlot(0, " R ");
		this.toggleSlotAvailability(0, false);
		
		for(int i = 0; i <= this.gridSize; i++)
		{
			if(i != 0) 
			{
				String slot = Integer.toString(i);
				this.setSlot(i, slot);
				this.toggleSlotAvailability(i, true);
			}
		}
	}
	
	public void setSlot(int position, String slotContent) {
		this.gameSlotState[position] = slotContent;
	}
	
	public void toggleSlotAvailability(int position, Boolean state) {
		this.gameSlotAvailability[position] = state;
	}
	
	public void play() {
		if(!this.hasEnded()) 
		{
			Ui.drawBoard(this.size, this.gridSize, this.gameSlotState);
			this.player1.move(this);
		} 
		if(!this.hasEnded()) 
		{
			Ui.drawBoard(this.size, this.gridSize, this.gameSlotState);
			this.player2.move(this);
			this.play();
		}
		if(this.hasEnded()) 
		{
			this.end();
		}
	}
	
	public static boolean isSlotAvailable(Boolean[] gameSlotAvailability,int selection) {
		return gameSlotAvailability[selection];
	}
	
	public void selectSlot(int selection, String player) {
		this.gameSlotState[selection] = player;
		this.gameSlotAvailability[selection] = false;
	}
	
	public boolean hasWinner() {
		for(List l : rules.winningCombinations) {
			if(this.player1.getHistory().containsAll(l)) {
				this.setWinner(this.player1);
				this.player1.addScore();
				return true;
			}
			else if(this.player2.getHistory().containsAll(l)) {
				this.setWinner(this.player2);
				this.player2.addScore();
				return true;
			}
		}
		return false;
	}
	
	public boolean hasAvailableSlots() {
		if(Arrays.asList(this.gameSlotAvailability).contains(true)) {
			return true;
		}
		return false;
	}
	
	public boolean hasEnded() {
		return this.hasWinner() || !this.hasAvailableSlots();
	}
	
	public void end() {
		
		Ui.drawBoard(this.size, this.gridSize, this.gameSlotState);
		if(this.hasWinner()) 
		{
			Ui.displayWinnerMessage(this.winner);
		} 
		else 
		{ 		
			Ui.displayEndOfGameMessage();
		}
		
		Ui.displayScoreBoard(this.player1,this.player2);
		
		String input = Ui.promptForNewGame();
		if(input.toUpperCase().contains("S")) 
		{
			this.newGame();
		} 
		else 
		{
			System.exit(0);
		}
	}
}
