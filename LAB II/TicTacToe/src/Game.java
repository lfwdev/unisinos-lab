import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
	protected String player;
	protected String ai;
	protected String[] options = {" X "," O "};
	protected String[] gameSlot;
	protected Boolean[] gameSlotAvailability;
	private static InputStreamReader inputStream = new InputStreamReader (System.in);
	private static BufferedReader buffer = new BufferedReader(inputStream);
	
	public void main() {
		this.start();
		this.play();
	}
	
	public void start() {
		this.resetState();
		this.promptForOption();
	}
	
	public void play() {
		this.selectSlot();
		if(this.hasEnded()) {
			
		} else {
			this.play();
		}
	}

	public void resetState() {
		this.player = "";
		this.gameSlot = new String[] {" R ", " 1 "," 2 "," 3 "," 4 "," 5 "," 6 "," 7 "," 8 "," 9 "};
		this.gameSlotAvailability = new Boolean[] {false,true,true,true,true,true,true,true,true,true};
	}
	
	public void drawBoard() {
		String gameLine =" %s | %s | %s \n";
		String lineSeparator = "-----+-----+----- \n";
		
		System.out.printf(gameLine,this.gameSlot[1],this.gameSlot[2],this.gameSlot[3]);
		System.out.printf(lineSeparator);
		System.out.printf(gameLine,this.gameSlot[4],this.gameSlot[5],this.gameSlot[6]);
		System.out.printf(lineSeparator);
		System.out.printf(gameLine,this.gameSlot[7],this.gameSlot[8],this.gameSlot[9]);

	}
	
	public void selectSlot() {
		
		this.drawBoard();
		int selection = this.promptForSlot();
		
		if(this.gameSlotAvailability[selection]) {
			this.gameSlot[selection] = this.player;
			this.gameSlotAvailability[selection] = false;
		} else {
			this.selectSlot();
		}
	}
	
	public int promptForSlot() {
		int opt = 0;
        System.out.print("\n Digite um número de 1 a 9 para selecionar um slot disponível... \n");
        try
        {
            String input = buffer.readLine();
            opt = Integer.parseInt(input);
        }
        catch (IOException error)
        {
            System.out.println ("Erro de I/O: " + error );
        }
        catch (NumberFormatException error)
        {
            System.out.println ("O valor digitado deve ser inteiro: " + error );
        }
        return (opt);
	}
	
	public void promptForOption()
    {   
		String prompt = "Digite X, ou O para iniciar... \n";
        System.out.print(prompt);
        
        try
        {
        	String input = buffer.readLine();
        	if(input instanceof String) {
        		if(input.toUpperCase().contains(this.options[0])) {
        			this.player = this.options[0];
        			this.ai = this.options[1];
        		} else {
        			this.player = this.options[1];
        			this.ai = this.options[0];
        		}
        		
        	} else {
        		
        		System.out.print(prompt);
        		this.promptForOption();
        		
        	}
        }
        catch (IOException error)
        {
           System.out.println ("Erro de I/O: " + error);
        }
    }
	
	public boolean hasEnded() {
		// TODO check if has winner
		// TODO check if has slots left
		return false;
	}
}
