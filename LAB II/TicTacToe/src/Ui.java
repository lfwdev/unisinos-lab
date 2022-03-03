import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ui {
	public static String errorOfInput = "Erro de I/O: ";
	public static String errorOfInputWantsInt = "O valor digitado deve ser inteiro: ";
	public static String promptForSlotSelection =  "\n Digite um número de 1 a 9 para selecionar um slot disponível... \n";
	public static String promptForOption = "Digite X, ou O para iniciar... \n";
	public static String promptForNewGame = "Gostaria de Iniciar uma nova partida? Digite S para sim e N para não... \n";
	public static String gameEnded = "O jogo acabou. \n";
	
	private static InputStreamReader inputStream = new InputStreamReader (System.in);
	private static BufferedReader buffer = new BufferedReader(inputStream);
	
	public static void drawBoard(String[] gameSlot) {
		String borderLine = "\n";
		String gameLine ="  %s | %s | %s  \n";
		String lineSeparator = " -----+-----+-----  \n";
		
		System.out.printf(borderLine);
		System.out.printf(gameLine,gameSlot[1],gameSlot[2],gameSlot[3]);
		System.out.printf(lineSeparator);
		System.out.printf(gameLine,gameSlot[4],gameSlot[5],gameSlot[6]);
		System.out.printf(lineSeparator);
		System.out.printf(gameLine,gameSlot[7],gameSlot[8],gameSlot[9]);
		System.out.printf(borderLine);

	}
	
	public static int promptForSlot() {
		System.out.print(Ui.promptForSlotSelection);
		return Ui.getIntInput();
	}
	
	public static String promptForOption() {   
        System.out.print(Ui.promptForOption);
        return Ui.getStringInput();
    }
	
	public static String promptForNewGame() {
        System.out.print(Ui.promptForNewGame);
        return Ui.getStringInput();
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
