package main;

import java.util.Arrays;

public class Labyrinth {
	private String fileName;
	private char[][] fileAsArray;
	public String lines;
	public String columns;

	public static void main(String[] args) {
		new Labyrinth();
	}
	
	public Labyrinth() {
		this.setFileName(Ui.fileNamePrompt());
		this.setFileAsArray();
		this.debugFileAsArray();
	}
	
	private void setFileName(String name) {
		this.fileName = name;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public void setFileAsArray() {
		FM file = new FM(this.getFileName());
		this.fileAsArray = file.fileAsArray;
	}
	
	public void debugFileAsArray() {
		System.out.println(Arrays.toString(this.fileAsArray));
	}

}
