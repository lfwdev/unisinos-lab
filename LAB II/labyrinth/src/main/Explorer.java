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
		
		this.move(x,y);
		this.labelAsDiscovered();
		this.discoverAdjacent(x,y);
//		this.explore(this.currPosX,this.currPosY);

	}
	
	public void discoverAdjacent(int x,int y) {
		
		boolean left = this.tryLeft(x,y);
		System.out.printf(" valid: %s \n", left);
		boolean down = this.tryDown(x,y);
		System.out.printf(" valid: %s \n", down);
		boolean right = this.tryRight(x,y);
		System.out.printf(" valid: %s \n", right);
		boolean up = this.tryUp(x,y);
		System.out.printf(" valid: %s \n", up);
	}
	
	public boolean isValidMove(int x,int y) {
		return this.areIndexesWithinBounds(x,y) && !this.isDiscovered(x,y);
	}

	public boolean isOpen(int x, int y) {
		return this.maze[x][y] == ' ';
	}
	
	public void move(int x,int y) {
		if(tryMove(x,y)) {
			this.currPosX = x;
			this.currPosY = y;
		}
	}

	public boolean tryMove(int x,int y) {
		if (this.isValidMove(x,y)) {
			return this.isOpen(x,y);
		}
		return false;
	}

	public boolean tryLeft(int x,int y) {
		int Y = y + 1;
		System.out.printf("left: %s,%s",x,Y);
		return this.tryMove(x,Y);
	}
	
	public boolean tryRight(int x,int y) {
		int Y = y - 1;
		System.out.printf("right: %s,%s",x,Y);
		return this.tryMove(x,Y);
	}
	
	public boolean tryDown(int x,int y) {
		int X = x + 1;
		System.out.printf("down: %s,%s",X,y);
		return this.tryMove(X,y);
	}
	
	public boolean tryUp(int x,int y) {
		int X = x - 1;
		System.out.printf("up: %s,%s",X,y);
		return this.tryMove(X,y);
	}
	
	public void labelAsDiscovered() {
		this.history[this.currPosX][this.currPosY] = true;
	}
	
	public boolean areIndexesWithinBounds(int X,int Y) {
		if(this.maze.length > X && X >= 0) {	
			if(this.maze[X].length > Y && Y >= 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isDiscovered(int x,int y) {
		try {
			return this.history[x][y];
		} catch(NullPointerException e) {
			return false;
		}
		
	}
	
	public void debugIndexesWithinBoundsMethod() {
        for(this.currPosX = 0; this.currPosX < this.maze.length; this.currPosX++){
        	for(this.currPosY = 0; this.currPosY < this.maze[this.currPosX].length; this.currPosY++){
        		System.out.printf("%s,%s : %s \n",this.currPosX,this.currPosY,this.areIndexesWithinBounds(this.currPosX,this.currPosY));
            }
        }
        this.currPosX = 0;
        this.currPosY = 0;
    }
	
	public void debugLabeledAsDiscovered() {
        for(this.currPosX = 0; this.currPosX < this.maze.length; this.currPosX++){
        	for(this.currPosY = 0; this.currPosY < this.maze[this.currPosX].length; this.currPosY++){
        		System.out.printf("%s,%s : %s \n",this.currPosX,this.currPosY,this.isDiscovered(this.currPosX,this.currPosY));
        		this.labelAsDiscovered();
        		System.out.printf("%s,%s : %s \n",this.currPosX,this.currPosY,this.isDiscovered(this.currPosX,this.currPosY));
            }
        }
        this.currPosX = 0;
        this.currPosY = 0;
    }
}
