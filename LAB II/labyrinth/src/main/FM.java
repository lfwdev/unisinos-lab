package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FM {
	public char[][] fileAsArray;
	public String PATH = System.getProperty("user.dir");

	public FM(String fileName) {
		this.setFileAsArray(fileName);
	}
	
	public void setFileAsArray(String nomearq) {
		
		char[][] mat = new char[0][0];
		// código da profa Tati 
		try {
			FileReader fr = new FileReader(this.PATH + "/" + nomearq);
			BufferedReader br = new BufferedReader(fr);
			 
			String line = br.readLine();
			int linha = Integer.parseInt(line.trim());
			 
			line = br.readLine();
			int coluna = Integer.parseInt(line.trim());
			 
			mat = new char[linha][coluna];
	
			for(int i = 0; i < mat.length;i++) {
				line = br.readLine();
				for (int j = 0; j <mat[i].length;j++)
					mat[i][j] = line.charAt(j);
			}
			 
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.fileAsArray = mat;
	}

}
