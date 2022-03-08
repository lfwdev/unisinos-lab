import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ui {
	public static String promptForSize =  "\n Digite um número inteiro maior que 3 para definir o tamanho do tabuleiro... \n";
	public static String errorOfInput = "Erro de I/O: ";
	public static String errorOfInputWantsInt = "O valor digitado deve ser inteiro: ";
	public static String promptForSlotSelection =  "\n Digite um número de 1 a 9 para selecionar um slot disponível... \n";
	public static String promptForOption = "Digite X, ou O para iniciar... \n";
	public static String promptForNewGame = "Gostaria de Iniciar uma nova partida? Digite S para sim e N para não... \n";
	public static String gameEnded = "O jogo acabou. Ninguém venceu. \n";
	public static String winnerMessage = "O jogo acabou. %s venceu. \n";
	public static String congratulations = "O jogo acabou. Parabéns, você venceu. \n";
	
	private static InputStreamReader inputStream = new InputStreamReader (System.in);
	private static BufferedReader buffer = new BufferedReader(inputStream);
	
	public static void drawBoard(int size, String[] gameSlot) {

		int slotPointer = 1;
		String lineSeparator = "";
		
		for(int row = 0; row < size; row++){
			
			String gameLine = "";
			
			for(int col = 0; col < size; col++){
				
				if (col == (size - 1)) {
					gameLine = gameLine + Game.symbol.replace("%s", gameSlot[slotPointer]);
					if (row == 0) {
						lineSeparator = lineSeparator + "-----"; 
					}
				} else {
					gameLine = gameLine + Game.symbol.replace("%s", gameSlot[slotPointer]) + "|";
					if (row == 0) {
						lineSeparator = lineSeparator + "-----+";
					}
				}
				
				slotPointer++;
			}
			
			System.out.println(gameLine);
			if (row != (size - 1)) {
				System.out.println(lineSeparator);
			}
		}
		
	}
	
	public static int promptForSlot() {
		System.out.print(Ui.promptForSlotSelection);
		return Ui.getIntInput();
	}
	
	public static String promptForOption() {   
        System.out.print(Ui.promptForOption);
        return Ui.getStringInput();
    }
	
	public static int promptForBoardSize() {
        System.out.print(Ui.promptForSize);
        return Ui.getIntInput();
	}
	
	public static String promptForNewGame() {
        System.out.print(Ui.promptForNewGame);
        return Ui.getStringInput();
	}
	
	public static void displayWinnerMessage(String winner, String player) {
		if(winner.contains(player)) {
			System.out.print(Ui.congratulations);
		} else {	
			System.out.printf(Ui.winnerMessage,winner);
		}			
	}
	
	public static void displayEndOfGameMessage() {
		System.out.print(Ui.gameEnded);
	}
	
	public static int getIntInput() {
		int selection = 0;
        try
        {
            String input = buffer.readLine();
            selection = Integer.parseInt(input); 
        }
        catch (IOException error)
        {
            System.out.println (Ui.errorOfInput + error );
        }
        catch (NumberFormatException error)
        {
            System.out.println (Ui.errorOfInputWantsInt + error );
        }
        return selection;
	}
	
	public static String getStringInput() {
		String input = "";
		try
        {
        	input = buffer.readLine();
        }
        catch (IOException error)
        {
           System.out.println (Ui.errorOfInput + error);
        }
        return input;
	}
}
