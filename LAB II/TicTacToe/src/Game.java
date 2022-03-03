import java.util.Arrays;

public class Game {
	public static String symbol = " %s ";
	private String player;
	private String ai;
	public static String[] options = {"X","O"};
	protected String[] gameSlot;
	protected Boolean[] gameSlotAvailability;
	
	
	public void main() {
		this.start();
		this.play();
	}
	
	public void setPlayerSymbol(String input) {
		this.player = Game.symbol.replace("%s", input);
	}
			
	public void setAiSymbol(String input) {
		this.ai = Game.symbol.replace("%s", input);
	}
	
	public void resetState() {
		this.player = "";
		this.gameSlot = new String[] {" R ", " 1 "," 2 "," 3 "," 4 "," 5 "," 6 "," 7 "," 8 "," 9 "};
		this.gameSlotAvailability = new Boolean[] {false,true,true,true,true,true,true,true,true,true};
	}
	
	public void start() {
		this.resetState();
		this.setSymbolSelection(Ui.promptForOption());
	}
	
	public void play() {
		
		Ui.drawBoard(gameSlot);
		this.playerMove();
		this.aiMove();
		
		if(this.hasEnded()) {
			Ui.displayEndOfGameMessage();
			Ui.drawBoard(gameSlot);
			this.end();
		} else {
			this.play();
		}
	}
	
	public void playerMove() {
		int selection = Ui.promptForSlot();
		if(Game.isSlotAvailable(this.gameSlotAvailability,selection)) {
			this.selectSlot(selection, this.player);
        } else {
        	this.playerMove();
        }
	}
	
	public void aiMove() {
		Ai.move(gameSlot, gameSlotAvailability);
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
    			this.player = symbol.replace("%s", Game.options[1]);
    			this.ai = symbol.replace("%s", Game.options[0]);
    		}
    	} else {
    		this.setSymbolSelection(Ui.promptForOption());
    	}
	}
	
	public boolean hasWinner() {
		// TODO check if has winner
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
			this.start();
			this.play();
		}
	}
}
