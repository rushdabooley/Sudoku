import java.util.Arrays;

public class Tests {
	public static int values[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	static boolean UsedSpace = false;
	static boolean UsedRow = false;
	static boolean UsedCol = false;
	static boolean UsedSubGrid = false;

	public static int getValue(int values[]) {
		
		int selectedValue;
		for (int i = 0; i < values.length;i++) {
				return selectedValue = values[i];
			//System.out.print(selectedValue);
		}
		return 0;
		
		/*int i = 0;
		while (i < 9) {
			 System.out.print(values[i]);
		}
				i++;*/

		

	}

	private boolean checkSudokuStatus(int[][] grid) {
		for (int i = 0; i < 9; i++) {

			int[] row = new int[9];
			int[] square = new int[9];
			int[] column = grid[i].clone();

			for (int j = 0; j < 9; j++) {
				row[j] = grid[j][i];
				square[j] = grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
			}
			if (!(validate(column) && validate(row) && validate(square)))
				return false;
		}
		return true;
	}

	private boolean validate(int[] check) {
		int i = 0;
		Arrays.sort(check);
		for (int number : check) {
			if (number != ++i)
				return false;
		}
		return true;
	}

	public static void spaceValid(int value, int[][] currentBoard, int currentRow, int currenCol) {
		if (currentBoard[currentRow][currenCol] != 0) {
			UsedSpace = true;
		}
	}

	public static boolean getSpace() {
		return Tests.UsedSpace;
	}

	public static void rowValid(int value, int[][] currentBoard, int currentRow) {

		// test1

		/*
		 * for(int row = 0; row < 9; row++) for(int col = 0; col < 8; col++) for(int
		 * col2 = col + 1; col2 < 9; col2++)
		 * if(currentBoard[row][col]==currentBoard[row][col2]) return false;
		 */

		// test 2
		for (int row = 0; row < currentBoard[0].length; row++) {
			if (currentBoard[currentRow][row] == value) {
				UsedRow = true;
			}
		}

	}

	public static boolean getRow() {
		return Tests.UsedRow;
	}

	public static void colValid(int value, int[][] currentBoard, int currenCol) {

		for (int col = 0; col < currentBoard.length; col++) {
			if (currentBoard[col][currenCol] == value) {
				UsedCol = true;
			}
		}

	

	}

	public static boolean getCol() {

		return Tests.UsedCol;
	}

	public static void subGridValid(int value, int[][] currentBoard,  int Row, int Col) {
		//UsedSubGrid
		int subRow = Row % 3;
		int subCol = Col % 3;
		for(int i = (Row = (Row%3)) ; i < subRow + 3; i++) {
			for (int j = subCol; j < subCol + 3; j++) {
				if (currentBoard[i][j] == value) {
					UsedSubGrid = true;
				}
			}
		}
		
	}

	public static boolean getSubGrid() {
		return Tests.UsedSubGrid;
	}

	public static void main(String[] args) {

		 int values[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		int[][] board = { { 1, 2, 3, 0, 0, 0, 0, 0, 0 },
						  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						  { 0, 0, 0, 4, 0, 6, 0, 0, 0 },

					      { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
					      { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
					      { 0, 0, 0, 0, 0, 0, 0, 0, 0, },

				          { 0, 0, 0, 0, 7, 0, 0, 0, 0 }, 
				          { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, 
				          { 0, 0, 0, 0, 9, 0, 0, 0, 0 } };
		
		//printing initial grid
		System.out.println("Initial Grid");
		for (int i = 0; i< 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		// checking space
		System.out.println("Checking space");
		spaceValid(1, board, 8, 8);
		System.out.println((getSpace()));
		board[8][8] = 1;
		spaceValid(3, board, 8, 8);
		System.out.println((getSpace()));
		
		// checking col
		System.out.println("Checking col");
		colValid(1, board, 0);
		System.out.println((getCol()));
		board[1][0] = 3;
		colValid(3, board, 0);
		System.out.println((getCol()));

		// checking row

		System.out.println("Checking row");
		rowValid(5, board, 0);
		System.out.println((getRow()));
		board[0][4] = 5;
		rowValid(5, board, 0);
		System.out.println((getRow()));
		
		// checking subgrid

		System.out.println("Checking subgrid");
		subGridValid(3, board, 1,1);
		System.out.println((getSubGrid()));
		board[1][0] = 5;
		subGridValid(5, board, 1,0);
		System.out.println((getSubGrid()));
		
		
		//printing  grid after checks
				System.out.println("Final Grid");
				for (int i = 0; i< 9; i++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(board[i][j] + " ");
					}
					System.out.println();
				}
		

		
		/*System.out.println("Printing values array");
		System.out.println(getValue(values));
		*/
		// placing a value into the array
		/*
		 * int i = 0; while (i >= 1 && i <= 9) {
		 * 
		 * for (int j = 0; j < 9; j++) { for (int k = 0; k < 9; k++) {
		 * System.out.print(board[j][k] = i); } System.out.println(); }
		 * 
		 * i++; }
		 */

	}

}
