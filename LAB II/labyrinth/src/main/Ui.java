package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ui {
	public static String fileNamePrompt = "Digite o nome do arquivo que deseja carregar;\n";
	public static String fileNotFoundExc = "Não foi possível encontrar o arquivo no caminho especificado; %s \n Tente novamente; \n";
	public static String errorOfInput = "Erro de I/O: ";
	public static String errorOfInputWantsInt = "O valor digitado deve ser inteiro: ";
	private static InputStreamReader inputStream = new InputStreamReader (System.in);
	private static BufferedReader buffer = new BufferedReader(inputStream);
	
    public static void drawFile(char[][] fileAsArray,int[] c) {
        for(int x = 0; x < fileAsArray.length; x++){
        	for(int y = 0; y < fileAsArray[x].length; y++){
                if(c[0] == x && c[1] == y) {
                    System.out.print("\uD83D\uDE00");
                } else {
                    if(fileAsArray[x][y] == ' ') {
                        System.out.printf(" %s ",fileAsArray[x][y]);
                    } else {
                        System.out.printf("|%s|",fileAsArray[x][y]);
                    }
                }
            }
        	System.out.print("\n");
        }
    }

    public static void dumpFileAsArray(char[][] fileAsArray) {
        System.out.println(Arrays.deepToString(fileAsArray));
    }

	public static String fileNamePrompt() {   
        System.out.print(Ui.fileNamePrompt);
        return Ui.getStringInput();
    }
	
	public static void fileNotFoundAtPath(String path) {
        System.out.printf(Ui.fileNotFoundExc,path);
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
