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
		// String fileNameOnGitpod = "LAB II/labyrinth/model.txt";
		// this.setFileName(fileNameOnGitpod);
		this.setFileName(Ui.fileNamePrompt());
		this.setFileAsArray();
		this.debugFileAsArray();
		this.xplorer = new Explorer(this.fileAsArray,this.file.numberOfColumns,this.file.numberOfLines);
		boolean hasExit = this.xplorer.explore(new int[] {0,0});
		file.writeResult(hasExit);
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
		Ui.drawFile(this.fileAsArray,new int[] {0,0});
	}
}
