package main;

import java.util.ArrayList;

public class Explorer {
	private char[][] maze;
	private int[] currPos = {0,0};
	private ArrayList<int[]> pathBranching = new ArrayList<>();
	public boolean[][] history;
	
	public Explorer(char[][] maze,int cols,int rows) {
		this.maze = maze;
		this.history = new boolean[rows][cols];
	}

	public boolean explore(int[] c) {
		try {
			this.labelAsDiscovered(c);
			ArrayList<int[]> adjacentPaths = this.discoverAdjacent(c);
			this.exploreAdjacent(c, adjacentPaths);
			c = new int[] {this.currPos[0],this.currPos[1]};
			if(this.isExit(c)) {
				System.out.printf("Encontrei a saída em: %s,%s \n",c[0],c[1]);
				return true;
			}
			this.explore(c);
		} catch (Exception e) {
			System.out.printf("Execução encerrada; \n %s \n", e.getMessage());
		}
		return false;
	}
	
	// discovers adjacent counterclockwise
	public ArrayList<int[]> discoverAdjacent(int[] c) {
		int [][] adjacent = new int [4][2];
		
		adjacent[0] = this.getPosLeft(c); // left
		adjacent[1] = this.getPosDown(c); // down
		adjacent[2] = this.getPosRight(c); // right
		adjacent[3] = this.getPosUp(c); // up
		
		ArrayList<int[]> paths = new ArrayList<>();
		
		for(int[] pos : adjacent) {
			if(this.tryMove(pos)) {
				paths.add(pos);
			}
		}

		return paths;
	}

	public void exploreAdjacent(int[] c, ArrayList<int[]> paths) throws Exception {
		
		if(paths.size() > 1) {
			for(int[] pos : paths) {
				System.out.printf("Descobri um novo caminho %s,%s \n",pos[0],pos[1]);
				pathBranching.add(pos);
			}
			this.move(pathBranching.get(0));
			pathBranching.remove(0);
		} else if(paths.size() > 0) {
			this.move(paths.get(0));
		} else if(pathBranching.size() > 0) {
			this.move(pathBranching.get(0));
			pathBranching.remove(0);
		} else {
			throw new Exception("Todas as áreas exploradas.");
		}
	}

	public int[] getPosLeft(int[] c) {
		return new int[] {c[0],c[1] + 1};
	}

	public int[] getPosDown(int[] c) {
		return new int[] {c[0] + 1,c[1]};
	}

	public int[] getPosRight(int[] c) {
		return new int[] {c[0],c[1] - 1};
	}

	public int[] getPosUp(int[] c) {
		return new int[] {c[0] - 1,c[1]};
	}

	
	public boolean isValidMove(int[] c) {
		return this.areIndexesWithinBounds(c[0],c[1]) && !this.isDiscovered(c[0],c[1]);
	}

	public boolean isOpen(int[] c) {
		return this.maze[c[0]][c[1]] == ' ';
	}

	public boolean isExit(int[] c) {
		return this.maze[c[0]][c[1]] == 'D';
	}
	
	public void move(int[] c) {
		if(tryMove(c)) {
			this.currPos[0] = c[0];
			this.currPos[1] = c[1];
			System.out.printf("%s,%s \n",c[0],c[1]);
			Ui.drawFile(this.maze,c);
		}
	}

	public boolean tryMove(int[] c) {
		if(this.isValidMove(c)) {
			return this.isOpen(c) || this.isExit(c);
		}
		return false;
	}
	
	public void labelAsDiscovered(int[] c) {
		this.history[c[0]][c[1]] = true;
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
        for(this.currPos[0] = 0; this.currPos[0] < this.maze.length; this.currPos[0]++){
        	for(this.currPos[1] = 0; this.currPos[1] < this.maze[this.currPos[0]].length; this.currPos[1]++){
        		System.out.printf("%s,%s : %s \n",this.currPos[0],this.currPos[1],this.areIndexesWithinBounds(this.currPos[0],this.currPos[1]));
            }
        }
        this.currPos[0] = 0;
        this.currPos[1] = 0;
    }
	
	public void debugLabeledAsDiscovered() {
        for(this.currPos[0] = 0; this.currPos[0] < this.maze.length; this.currPos[0]++){
        	for(this.currPos[1] = 0; this.currPos[1] < this.maze[this.currPos[0]].length; this.currPos[1]++){
        		System.out.printf("%s,%s : %s \n",this.currPos[0],this.currPos[1],this.isDiscovered(this.currPos[0],this.currPos[1]));
        		int[] c = {this.currPos[0],this.currPos[1]};
				this.labelAsDiscovered(c);
        		System.out.printf("%s,%s : %s \n",this.currPos[0],this.currPos[1],this.isDiscovered(this.currPos[0],this.currPos[1]));
            }
        }
        this.currPos[0] = 0;
        this.currPos[1] = 0;
    }
}
