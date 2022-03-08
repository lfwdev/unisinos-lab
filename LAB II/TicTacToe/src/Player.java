import java.util.ArrayList;

public class Player {
	public Boolean isAi = false;
	private String name;
	private String symbol;
	public ArrayList<Integer> history = new ArrayList<Integer> ();
	public int score = 0;
	
	public Player() {
		
	}
	
	public void setSymbol(String input) {
		this.symbol = Game.symbol.replace(Game.defaultSlot, input);
	}
	
	public void setName() {
		this.name = Ui.promptForPlayerName(this.getSymbol());
	}
	
	public String getName() {
		return this.name;
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
	
	public void move(Game game) {
		int selection = Ui.promptForSlot(this.getSymbol(),game.gridSize);
		if(Game.isSlotAvailable(game.gameSlotAvailability,selection)) {
			game.selectSlot(selection, this.getSymbol());
			this.history.add(selection);
        } else {
        	this.move(game);
        }
	}
}
