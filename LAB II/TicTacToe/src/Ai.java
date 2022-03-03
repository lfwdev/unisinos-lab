import java.util.Random;

public class Ai {

	public static int move(String[] gameSlot, Boolean[] gameSlotAvailability) {
		
		if(Game.isSlotAvailable(gameSlotAvailability,5)) {
			return 5;
		}
		
		int selection = Ai.getRandomIntInRange();
		
		System.out.println("Ai is deciding...");
		System.out.println(Game.playerHistory);
		System.out.println(Game.aiHistory);
		System.out.println(selection);
		System.out.println(Game.isSlotAvailable(gameSlotAvailability,selection));
		
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
