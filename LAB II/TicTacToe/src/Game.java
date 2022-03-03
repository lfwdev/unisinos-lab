
public class Game {
	public String player;
	public String ai;
	protected String[] gameSlot;
	protected Boolean[] gameSlotAvailability;
	protected String[] options = {" X "," O "};
	
	public void main() {
		this.start();
		this.play();
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
			this.end();
		} else {
			this.play();
		}
	}
	
	public void playerMove() {
		int selection = Ui.promptForSlot();
		if(this.gameSlotAvailability[selection]) {
			this.selectSlot(selection, this.player);
        } else {
        	this.playerMove();
        }
	}
	
	public void aiMove() {
		int selection = Ai.move(gameSlot, gameSlotAvailability);
		this.selectSlot(selection, this.ai);
	}
	
	public void selectSlot(int selection, String player) {
		
		this.gameSlot[selection] = player;
		this.gameSlotAvailability[selection] = false;
		
	}
	
	public void setSymbolSelection(String input) {
		if(input instanceof String) {
    		if(input.toUpperCase().contains(this.options[0])) {
    			this.player = this.options[0];
    			this.ai = this.options[1];
    		} else {
    			this.player = this.options[1];
    			this.ai = this.options[0];
    		}
    	} else {
    		this.setSymbolSelection(Ui.promptForOption());
    	}
	}
	
	public boolean hasEnded() {
		// TODO check if has winner
		// TODO check if has slots left
		return false;
//		Ui.displayEndOfGameMessage();
	}
	
	public void end() {
		// TODO check if player wants to go again
		String input = Ui.promptForNewGame();
		if(input.toUpperCase().contains("S")) {
			this.start();
			this.play();
		}
	}
}
