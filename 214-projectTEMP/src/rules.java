import java.util.Arrays;

public class rules {
	/*
	 * this class will contain all the rules needed to run within the project
	 * 
	 */

	// Booleans used in methods

	static boolean duplicateInRow = false;
	static boolean duplicateInColumn = false;
	static boolean duplicateInSubgrid = false;

	public static void rule1a(int[][] board, int row, int col) {

		/*
		 * only place the value if that position can be filled by only one value
		 * if that position can be filled by another value don't place anything
		 * 
		 * if your possible values array contains more than 1 value then don't
		 * place anything.
		 */

		int getArrayLength = gameBoard.possibleValsGenerator(board, row, col).length;

		if (getArrayLength > 1) {
			System.out.println("No value can be placed");
		} else {

			System.out.println(Arrays.toString(gameBoard.possibleValsGenerator(board, row, col)));
		}

	}

	public static boolean isRowFull(int board[][], int row, int value) {
		/*
		 * if the sum of values in the row + value from possiblevalues array =
		 * 45 then the group is full
		 */
		boolean rowFull = false;
		int sumOfRow = 0;
		for (int i = 0; i < 9; i++) {

			sumOfRow = sumOfRow + board[row][i];

		}
		if ((value + sumOfRow) == 45) {
			rowFull = true;
		}
		// System.out.println(sumOfRow + " = sumOfRow " + row);

		return rowFull;
	}

	public static boolean isColumnFull(int board[][], int column, int value) {
		boolean columnFull = false;
		int sumOfColumn = 0;

		for (int i = 0; i < 9; i++) {

			sumOfColumn = sumOfColumn + board[i][column];

		}
		if ((value + sumOfColumn) == 45) {
			columnFull = true;
		}
		// System.out.println(sumOfColumn + " = sumOfColumn " + column);

		return columnFull;
	}

	public static boolean isSubGridFull(int board[][], int row, int column, int value) {
		boolean subGridFull = false;
		int sumOfSubGrid = 0;
		int startOfSubGridX = (row / 3) * 3;

		int startOfSubGridY = (column / 3) * 3;

		for (int i = startOfSubGridX; i < (startOfSubGridX + 3); i++) {
			for (int j = startOfSubGridY; j < (startOfSubGridY + 3); j++) {
				sumOfSubGrid = sumOfSubGrid + board[i][j];

			}
		}
		if ((value + sumOfSubGrid) == 45) {
			subGridFull = true;
		}

		// System.out.println(sumOfSubGrid + " sumOfSubGrid " + startOfSubGridX
		// + " " + startOfSubGridY);
		return subGridFull;
	}

	public static boolean rowCompare(int value) {

		return duplicateInRow;
	}

	public static boolean columnCompare(int value) {
		/*
		 * this method will determine if your value is contained in another
		 * possible values array
		 */

		return duplicateInColumn;
	}

	public static boolean subGridCompare(int value) {

		return duplicateInSubgrid;
	}

	public static void rule1b(int[][] board, int row, int col) {
		/*
		 * If any other position in the group can take that value don't print
		 * anything
		 */

		/*
		 * get possible location for each value use value to search for possible
		 * locations if more than 1 possible location don't place
		 * 
		 * e.g find where 9 can be placed if 9 can be placed in more than one
		 * position dont place
		 */

		int[] temp = gameBoard.possibleValsGenerator(board, row, col);
		// value is the number you're checking
		int value = temp[0];

		if (board[row][col] == 0) {
			/*
			 * if value is contained in any of the other possible value arrays
			 * don't place go through each group and check within your for loops
			 * change the value of duplicate boolean
			 * 
			 * if a group is full i.e will add up to 45 with your value place it
			 */
			if (isRowFull(board, row, value) == true || isColumnFull(board, col, value) == true
					|| isSubGridFull(board, row, col, value) == true) {
				System.out.println(Arrays.toString(gameBoard.possibleValsGenerator(board, row, col)));
			} else {
				System.out.println("No value was placed");
			}

		} else if ((board[row][col] != 0)) {
			System.out.println("location already filled");
		}

	}

	
	public static void rule4a(int[][] board, int row, int col, int value) {

		Graph g = new Graph(18);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				g.addEdge(row, (col + 9));
			}
		}

		BipartiteMatching bm = new BipartiteMatching(g);

		if (bm.isPerfect() == false) {
			if (bm.isMatched(row) && bm.mate(row) == (col + 9)) {
				System.out.println("-" + value);
			} else {
				
			}
		}

	}

}
