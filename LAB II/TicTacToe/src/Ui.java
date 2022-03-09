import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ui {
	public static String columnSlotSeparator = "|";
	public static String columnLineSeparator = "+";
	public static String slotLineSeparator = "-";
	public static String promptForName = "\n Digite o nome para o jogador %s : \n";
	public static String promptForSize =  "\n Digite um número inteiro maior que 3 (3x3) e menor ou igual à 9 (9x9) para definir o tamanho do tabuleiro... \n";
	public static String errorOfInput = "Erro de I/O: ";
	public static String errorOfInputWantsInt = "O valor digitado deve ser inteiro: ";
	public static String promptForSlotSelection =  "\n Turno do jogador %s. Digite um número de 1 a %s para selecionar um slot disponível... \n";
	public static String promptForOption = "Digite X, ou O para iniciar... \n";
	public static String promptForNewGame = "Gostaria de Iniciar uma nova partida? Digite S para sim e N para não... \n";
	public static String gameEnded = "O jogo acabou. Ninguém venceu. \n";
	public static String winnerMessage = "O jogo acabou. %s venceu. \n";
	public static String congratulations = "O jogo acabou. Parabéns, %s venceu. \n";
	private static InputStreamReader inputStream = new InputStreamReader (System.in);
	private static BufferedReader buffer = new BufferedReader(inputStream);
	
	public static void drawBoard(int size, int gridSize, String[] gameSlotState) {

		int slotPointer = 1;
		String lineSeparator = "";
		int slotLengthMultiplier = Integer.toString(gridSize).length();
		
		for(int row = 0; row < size; row++){
			
			String gameLine = "";
			
			for(int col = 0; col < size; col++){
				
				int spaces = slotLengthMultiplier;
				int slotLen = gameSlotState[slotPointer].length();
				
				if(slotLen < slotLengthMultiplier) {
					if((slotLen % 1) == 0) {
						spaces = spaces + 1;
					} else {
						spaces = spaces + 2;
					}
				}
				
				if((spaces % 1) == 0) {
					spaces = spaces + 1; 
				}
				
				String slotLineSeparator = Ui.getSlotLineSeparator(spaces);
				
				gameLine = gameLine + getSpaceFilledSlotSymbol(gameSlotState[slotPointer],spaces);
				if (row == 0) {
					lineSeparator = lineSeparator + slotLineSeparator; 
				}
				
				if (col != (size - 1)) {
					gameLine = gameLine + columnSlotSeparator;
					if (row == 0) {
						lineSeparator = lineSeparator + columnLineSeparator;
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
	
	public static String getSpaceFilledSlotSymbol(String symbol, int slotLengthMultiplier) {
		String preppend = "";
		String append = "";

		for(int i = 1; i <= (slotLengthMultiplier); i++) {
			if(i % 2 == 0) {
				preppend = preppend + " ";
			} else {
				append = append + " ";
			}
		}
		
		return (preppend + symbol + append);
	}
	
	public static String getSlotLineSeparator(int slotLengthMultiplier) {
		String slotLineSeparator = "";
		for(int i = 0; i <= (slotLengthMultiplier); i++) {
			slotLineSeparator = slotLineSeparator + Ui.slotLineSeparator;
		}
		return slotLineSeparator;
	}
	
	public static int promptForSlot(String playerSymbol, int gridSize) {
		System.out.printf(Ui.promptForSlotSelection,playerSymbol,gridSize);
		return Ui.getIntInput();
	}
	
	public static String promptForOption() {   
        System.out.print(Ui.promptForOption);
        return Ui.getStringInput();
    }
	
	public static String promptForPlayerName(String symbol) {   
        System.out.printf(Ui.promptForName,symbol);
        return Ui.getStringInput();
    }
	
	public static int promptForBoardSize() {
        System.out.print(Ui.promptForSize);
        int input = Ui.getIntInput();
        if(input > 3 && input < 10)
        {
        	return input;
        } else if(input > 9) {
        	return 9;
        } else {
        	return 3;
        }
        	
	}
	
	public static String promptForNewGame() {
        System.out.print(Ui.promptForNewGame);
        return Ui.getStringInput();
	}
	
	public static void displayWinnerMessage(Player winner) {
		System.out.printf(Ui.congratulations, winner.getName());		
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
