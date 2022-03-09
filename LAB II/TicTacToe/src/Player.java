import java.util.ArrayList;

public class Player {
	private String name = "";
	private String symbol = "";
	public ArrayList<Integer> history = new ArrayList<Integer> ();
	public int score;
	
	public Player() {
		this.score = 0;
	}
	
	public void setSymbol(String input) {
		this.symbol = input;
	}
	
	public void setName() {
		this.name = Ui.promptForPlayerName(this.getSymbol());
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getScoreAsString() {
		return Integer.toString(this.score);
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public void addScore() {
		this.score = this.score + 1;
	}
	
	public ArrayList<Integer> getHistory() {
		return this.history;
	}
	
	public void resetState() {
		this.history = new ArrayList<Integer> ();
	}
	
	public void move(Game game) {
		int selection = Ui.promptForSlot(this,game.gridSize);
		if(Game.isSlotAvailable(game.gameSlotAvailability,selection)) {
			game.selectSlot(selection, this.getSymbol());
			this.history.add(selection);
        } else {
        	this.move(game);
        }
	}
}
