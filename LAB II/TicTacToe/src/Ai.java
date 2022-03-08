import java.util.Random;

public class Ai {

	public static int move(String[] gameSlot, Boolean[] gameSlotAvailability) {
		
		int selection = Ai.getRandomIntInRange();
		
		if(Game.isSlotAvailable(gameSlotAvailability,selection)) {
			return selection;
		} else {
        	return Ai.move(gameSlot,gameSlotAvailability);
        }
		
	}
	
	public static int getRandomIntInRange() {
	    Random r = new Random();
	    return r.nextInt(9) + 1;
	}
}
