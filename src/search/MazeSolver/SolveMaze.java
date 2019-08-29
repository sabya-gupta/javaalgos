package search.MazeSolver;

import java.io.File;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class SolveMaze {

	String filename;
	int numrows, numcols, startPosCol, startPosRow;
	int[][]map, visited;

	
	void printMaze() {
		for (int i = 0; i < numrows; i++) {
			for (int j = 0; j < numcols; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	void readFile() {
		try {
			System.out.println("reading....");
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			for (int i = 0; i < numrows; i++) {
				for (int j = 0; j < numcols; j++) {
					map[i][j] = scanner.nextInt();
					if(map[i][j]==2) {
						startPosRow=i;
						startPosCol=j;
					}
				}
				
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void solveTheMazeWithDFS(int row, int col) throws Exception{
		String str = "Analysing [%d][%d]";
		System.out.println(String.format(str, row,col));
		if(row <=0 || row >= numrows) {
			return;
		}
		if(col <=0 || col >= numcols) {
			return;
		}
		if(visited[row][col]==1) {
			return;
		}
		if(map[row][col]==1) {
			return;
		}
		if(map[row][col] == 3) {
			throw new Exception("found escape!!!");
		}
		visited[row][col]=1;
		solveTheMazeWithDFS(row, col+1);
		solveTheMazeWithDFS(row+1, col);
		solveTheMazeWithDFS(row, col-1);
		solveTheMazeWithDFS(row-1, col);
	}
	
	public SolveMaze() {
		filename = "src/search/MazeSolver/Mazefile";
		numcols=numrows=5;
		map = visited = new int[numrows][numcols];
	}

	public static void main(String[] args) {
		SolveMaze sm = new SolveMaze();
		sm.readFile();
		sm.printMaze();
		try {
			sm.solveTheMazeWithDFS(sm.startPosRow, sm.startPosCol);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
}
