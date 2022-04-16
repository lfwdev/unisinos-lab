package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FM {
	public char[][] fileAsArray;
	public int numberOfLines;
	public int numberOfColumns;
	private FileReader fr;
	private BufferedReader br;
	private String fileName;
	public String PATH = System.getProperty("user.dir");

	public FM(String fileName) {
		this.fileName = fileName;
		this.setFileAsArray(this.fileName);
	}
	
	private String getNextBufferedLine() throws IOException {
		return this.br.readLine();
	}
	
	private void setNumberOfLines() throws NumberFormatException, IOException {
		this.numberOfLines = Integer.parseInt(this.getNextBufferedLine().trim());
	}
	
	private void setNumberOfColumns() throws NumberFormatException, IOException {
		this.numberOfColumns = Integer.parseInt(this.getNextBufferedLine().trim());
	}
	
	private void buildArrayFromFile() throws IOException {
		for(int i = 0; i < this.fileAsArray.length;i++) {
			String line = this.getNextBufferedLine();
			for (int j = 0; j < this.fileAsArray[i].length;j++)
				this.fileAsArray[i][j] = line.charAt(j);
		}
	}
	
	public void setFileAsArray(String nomearq) {
		// código da profa Tati, separei em diversos métodos
		String path = this.PATH + "/" + nomearq;
		try {
			this.fr = new FileReader(path);
			this.br = new BufferedReader(this.fr);
			this.setNumberOfLines();
			this.setNumberOfColumns();
			this.fileAsArray = new char[this.numberOfLines][this.numberOfColumns];
			this.buildArrayFromFile();
			this.br.close();
		} catch (FileNotFoundException e) {
			Ui.fileNotFoundAtPath(path);
			this.setFileAsArray(Ui.fileNamePrompt());
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}

	public static boolean createFile(String filePath) {
		File myObj = new File(filePath);
		return myObj.canWrite();
	}

	public static void writeToFile(String filePath,String content) {
		try {
			FM.createFile(filePath);
			FileWriter myWriter = new FileWriter(filePath);
			myWriter.write(content);
			myWriter.close();
			System.out.printf("Arquivo salvo em: %s \n", filePath);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	  }

	public void writeResult(boolean hasExit) {
		
		String success = "Existe um caminho para o labirinto";
		String fail = "Não existe um caminho para o labirinto";
		String savePath = this.PATH + "/" + "saidaLabirinto.txt";
		
		FM.writeToFile(savePath, (hasExit ? success : fail));
	}
}
