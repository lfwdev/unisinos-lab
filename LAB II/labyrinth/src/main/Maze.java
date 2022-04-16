package main;

public class Maze {
	private String fileName;
	private char[][] fileAsArray;
	private FM file;
	private Explorer xplorer;

	public static void main(String[] args) {
		new Maze();
	}
	
	public Maze() {
		this.setFileName(Ui.fileNamePrompt());
		this.setFileAsArray();
		this.debugFileAsArray();
		this.xplorer = new Explorer(this.fileAsArray,this.file.numberOfColumns,this.file.numberOfLines);
		xplorer.explore(0,0);
	}
	
	private void setFileName(String name) {
		this.fileName = name;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public void setFileAsArray() {
		this.file = new FM(this.getFileName());
		this.fileAsArray = this.file.fileAsArray;
	}
	
	public void debugFileAsArray() {
		Ui.drawFile(this.fileAsArray);
	}
}
