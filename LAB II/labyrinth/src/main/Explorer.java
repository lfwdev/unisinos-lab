package main;

public class Explorer {
	private char[][] maze;
	private int currPosX = 0;
	private int currPosY = 0;
	public boolean[][] history;
	
	public Explorer(char[][] maze,int cols,int rows) {
		this.maze = maze;
		this.history = new boolean[rows][cols];
	}

	public void explore(int x,int y) {
		
		this.currPosX = x;
		this.currPosY = y;

//		this.labelAsDiscovered();
//		this.discoverAdjacent();
//		this.explore(this.currPosX,this.currPosY);

	}
	
	public void discoverAdjacent() {
		
		boolean l = this.tryLeft();
		boolean d = this.tryDown();
		boolean r = this.tryRight();
		boolean u = this.tryUp();
		if (this.isValidMove()) {
			
		}
	}
	
	public boolean isValidMove() {
		return this.areIndexesWithinBounds() && !this.isDiscovered();
	}
	
	public boolean tryLeft() {
		return false;
	}
	
	public boolean tryRight() {
		return false;
	}
	
	public boolean tryDown() {
		return false;
	}
	
	public boolean tryUp() {
		return false;
	}
	
	public void labelAsDiscovered() {
		this.history[this.currPosX][this.currPosY] = true;
	}
	
	public boolean areIndexesWithinBounds() {
		if(this.maze.length >= this.currPosX && this.currPosX >= 0) {	
			if(this.maze[this.currPosX].length >= this.currPosY && this.currPosY >= 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isDiscovered() {
		try {
			return this.history[this.currPosX][this.currPosY];
		} catch(NullPointerException e) {
			return false;
		}
		
	}
	
	public void debugIndexesWithinBoundsMethod() {
        for(this.currPosX = 0; this.currPosX < this.maze.length; this.currPosX++){
        	for(this.currPosY = 0; this.currPosY < this.maze[this.currPosX].length; this.currPosY++){
        		System.out.printf("%s,%s : %s \n",this.currPosX,this.currPosY,this.areIndexesWithinBounds());
            }
        }
        this.currPosX = 0;
        this.currPosY = 0;
    }
	
	public void debugLabeledAsDiscovered() {
        for(this.currPosX = 0; this.currPosX < this.maze.length; this.currPosX++){
        	for(this.currPosY = 0; this.currPosY < this.maze[this.currPosX].length; this.currPosY++){
        		System.out.printf("%s,%s : %s \n",this.currPosX,this.currPosY,this.isDiscovered());
        		this.labelAsDiscovered();
        		System.out.printf("%s,%s : %s \n",this.currPosX,this.currPosY,this.isDiscovered());
            }
        }
        this.currPosX = 0;
        this.currPosY = 0;
    }
}
