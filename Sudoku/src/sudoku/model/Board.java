package sudoku.model;

///** An abstraction of Sudoku puzzle. */
//public class Board {
//
//    /** Size of this board (number of columns/rows). */
//    public final int size;
//
//    /** Create a new board of the given size. */
//    public Board(int size) {
//        this.size = size;
//
//        // WRITE YOUR CODE HERE ...
//    }
//
//    /** Return the size of this board. */
//    public int size() {
//    		return size;
//    }
//
//    // WRITE YOUR CODE HERE ..
//}

/*
 * This class will provide all the functionality for creating a sudoku board
 * and keep track of the board itself.
 */
public class Board {
	
	public int size;
	private int[][] puzzle;
	public int xpos;
	public int ypos;
	
	/*
	 * The default size of the board will be 4 and makes a call to 
	 * makeOriginalBoard which will create a 2D array with this given size.
	 */
	public Board() {
		size = 4;
		makeOriginalBoard();
	}

	/* 
	 * Constructor that receives an integer value and sets its value to 
	 * 'int size'. It then makes a call to makeOriginalBoard which will create
	 * a 2D array with this given size.
	 */
	public Board(int size) {
		this.size = size;
		makeOriginalBoard();
	}
	
	/* 
	 * makeOriginalBoard takes the size stored into 'int size' and creates a
	 * new 2D Array with the row length = to size and the column length  = to 
	 * size. After creating the array, it sets all initial values to -1.  
	 */
	public void makeOriginalBoard() {
		puzzle = new int[size][size];
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[i].length; j++) {
				puzzle[i][j] = -1; 
			}
		}
	}
	
	/* 
	 * isSolved will iterate throughout the entire 2D Array to check
	 * and make sure there are no more unchanged numbers (-1's). Once all 
	 * numbers have been changed from -1's to another int value then this
	 * method will return true.
	 */
	public boolean isSolved() {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[i].length; j++) {
				if (puzzle[i][j] == -1) {
					return false;
				}
			}
		}
		return true;
	}
	
	/*
	 * modifyBoard receives 3 integers (x, y, v) and modifies the 2D Array
	 * puzzle. 'x' represents the row, 'y' represents the column, and 'v'
	 * represents the number that will be placed into the array at positions
	 * x & y.
	 */
	public void modifyBoard(int x, int y, int v) {
		puzzle[x][y] = v;
	}
	
	/* 
	 * chekcBoard receives 3 integers (x, y, v) and checks to make sure that
	 * 'v' is not found anywhere in row 'x' nor column 'y'. If 'v' is found in
	 * either row x or row y then this method will return false otherwise this
	 * method will return true.
	 */
	public boolean checkBoard(int x, int y, int v) {
		// Check rows.
		for (int i = 0; i < puzzle.length; i++) {
			if (puzzle[i][y] == v) 
				return false;	
		}
		
		// Check columns.
		for (int j = 0; j < puzzle[x].length; j++) {
			if (puzzle[x][j] == v)
				return false;
		}
		
		// Check surrounding box.
		double sqrtSize = Math.sqrt(size);
		int rowCounter = 1;
		while (x >= sqrtSize * rowCounter) {
			rowCounter++;
		}
		//System.out.println("This is the quadrent for row: " + rowCounter);
		
		int colCounter = 1;
		while (y >= sqrtSize * colCounter) {
			colCounter++;
		}
		//System.out.println("This is the quadrent for column: " + colCounter);
		
		for (int i = (int)(sqrtSize * rowCounter) - 1; i > ((rowCounter * sqrtSize) - sqrtSize) - 1; i--) {
			for (int j = (int)(sqrtSize * colCounter) - 1; j > ((colCounter * sqrtSize) - sqrtSize) - 1; j--) {
				//System.out.print("(" + (i) + ", " + (j) + ") ");
				if (puzzle[i][j] == v) {
					return false;
				}
			}
			System.out.println();
		}
		
		return true;
	}
	
	/*
	 * printBoard will iterate though the 2D Array and print out all the integer
	 * values found within the Array that are not -1. Since makeOriginalBoard set
	 * all the initial values to -1 then all -1 values will be ignored and instead
	 * of printing a number will print a blank space.
	 */
	public void printBoard() {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[i].length; j++) {
				if (puzzle[i][j] == -1) {
					System.out.print(" (" + (i) + ", " + (j) + ") ");
				}
				
				else {
					System.out.print("   " + puzzle[i][j] + "    ");
				}
			}
			System.out.println("");
		}
	}
	
	/* 
	 * getSize will return the size of 'int size' to whichever method calls it.
	 */
	public int size() {
		return size;
	}
}
