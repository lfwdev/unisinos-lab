import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
	public static String symbol = "%s";
	public static String defaultSlot = "%s";
	public int size;
	private String player;
	private String ai;
	private String player1;
	private String player2;
	public String winner;
	public static String[] options = {"X","O"};
	public int gridSize;
	protected String[] gameSlot;
	protected Boolean[] gameSlotAvailability;
	public Rules rules = new Rules();
	public static ArrayList<Integer> playerHistory = new ArrayList<Integer> ();
	public static ArrayList<Integer> aiHistory = new ArrayList<Integer> ();
	
	public Game() {
		this.newGame();
	}
	
	public void newGame() {
		this.size = Ui.promptForBoardSize();
		this.start();
		this.play();
	}
	
	public void setPlayerSymbol(String input) {
		this.player = Game.symbol.replace(Game.defaultSlot, input);
	}
			
	public void setAiSymbol(String input) {
		this.ai = Game.symbol.replace(Game.defaultSlot, input);
	}
	
	public void setWinner(String input) {
		this.winner = input;
	}
	
	public void resetState() {
		this.player = "";
		
		this.gridSize = (this.size) * (this.size);
		
		this.gameSlot = new String[this.gridSize + 1];
		this.gameSlotAvailability = new Boolean[this.gridSize + 1];
		
		for(int i = 0; i <= this.gridSize; i++){
			if(i != 0) {
				String slot = Game.symbol.replace(Game.defaultSlot, Integer.toString(i));
				this.setSlot(i, slot);
				this.toggleSlotAvailability(i, true);
			} else {
				this.setSlot(i, " R ");
				this.toggleSlotAvailability(i, false);
			}
		}
	}
	
	public void setSlot(int position, String slotContent) {
		this.gameSlot[position] = slotContent;
	}
	
	public void toggleSlotAvailability(int position, Boolean state) {
		this.gameSlotAvailability[position] = state;
	}
	
	public void start() {
		this.resetState();
		this.setSymbolSelection(Ui.promptForOption());
	}
	
	public void play() {
		
		Ui.drawBoard(this.size, this.gridSize, this.gameSlot);
		this.playerMove();
		
		if(this.hasEnded()) {
			Ui.drawBoard(this.size, this.gridSize, this.gameSlot);
			if(this.hasWinner()) {
				Ui.displayWinnerMessage(this.winner, this.player);
			} else {				
				Ui.displayEndOfGameMessage();
			}
			this.end();
		} 
		else {
			this.aiMove();
			this.play();
		}
	}
	
	public void playerMove() {
		int selection = Ui.promptForSlot(this.gridSize);
		if(Game.isSlotAvailable(this.gameSlotAvailability,selection)) {
			this.selectSlot(selection, this.player);
			Game.playerHistory.add(selection);
        } else {
        	this.playerMove();
        }
	}
	
	public void aiMove() {
		int selection = Ai.move(gameSlot, gameSlotAvailability);
		this.selectSlot(selection, this.ai);
		Game.aiHistory.add(selection);
	}
	
	public static boolean isSlotAvailable(Boolean[] gameSlotAvailability,int selection) {
		return gameSlotAvailability[selection];
	}
	
	public void selectSlot(int selection, String player) {
		
		this.gameSlot[selection] = player;
		this.gameSlotAvailability[selection] = false;
		
	}
	
	public void setSymbolSelection(String input) {
		
		if(input instanceof String) {
    		if(input.toUpperCase().contains(Game.options[0])) {
    			this.setPlayerSymbol(Game.options[0]);
    			this.setAiSymbol(Game.options[1]);
    		} else {
    			this.setPlayerSymbol(Game.options[1]);
    			this.setAiSymbol(Game.options[0]);
    		}
    	} else {
    		this.setSymbolSelection(Ui.promptForOption());
    	}
	}
	
	public boolean hasWinner() {
		for(List l : rules.winningCombinations) {
			if(Game.playerHistory.containsAll(l)) {
				this.setWinner(this.player);
				return true;
			}
			else if(Game.aiHistory.containsAll(l)) {
				this.setWinner(this.ai);
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
		String input = Ui.promptForNewGame();
		if(input.toUpperCase().contains("S")) {
			this.newGame();
		}
	}
}
