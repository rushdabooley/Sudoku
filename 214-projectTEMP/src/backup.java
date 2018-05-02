import java.util.Arrays;

public class backup {

	/*
	 * back up old method here
	 *
	 */

	public static int[] possibleValsGenerator(int[][] board, int row, int col) {
		// this method populates an array with possible values at a given
		// position
		// which will later be copied over to you object array

		int[] alreadyUsed;
		int[] vals = new int[9];
		int currentIndex = 0;
		int size = 0;
		boolean valueMatch;

		if (board[row][col] != 0) {
			return new int[] { board[col][row] };
		} else {
			alreadyUsed = new int[26];
			// Go into Row x and store all available numbers in alreadyUsed
			for (int i = 0; i < board.length; i++) {
				if (board[row][i] != 0) {
					alreadyUsed[currentIndex] = board[row][i];
					currentIndex++;
				}

			}
			// Go into Column y and store all available numbers in alreadyInUse
			for (int j = 0; j < board.length; j++) {
				if (board[j][col] != 0) {
					alreadyUsed[currentIndex] = board[j][col];
					currentIndex++;
				}
			}

			// Go into subarray and store all available numbers in alreadyUsed
			int x_position = (row / 3) * 3;
			int y_position = (col / 3) * 3;

			for (int i = x_position; i < (x_position + 3); i++) {
				for (int j = y_position; j < (y_position + 3); j++) {
					if (board[i][j] != 0) {
						alreadyUsed[currentIndex] = board[i][j];
						currentIndex++;
					}
				}

			}

			// Now your array contains duplicates so you need to
			// compare 1-9 with the numbers stored in alreadyInUse array

			for (int i = 1; i < 10; i++) {
				valueMatch = false;
				// if there is a pair that matches, break

				for (int j = 0; j < alreadyUsed.length; j++) {
					if (alreadyUsed[j] == i) {
						valueMatch = true;
						break;
					}
				}

				// If there are no pair matches, store the value (i) in an
				// unsorted array
				if (!valueMatch) {
					size++;
					vals[i - 1] = i;
				}

			}
			// Re-use alreadyInUse array
			alreadyUsed = new int[size];
			size = 0;
			// Remove the zeros and store the rest of the numbers in
			// alreadyInUse array
			for (int i = 0; i < vals.length; i++) {
				if (vals[i] != 0) {
					alreadyUsed[size] = vals[i];
					size++;
				}
			}

		}

		return alreadyUsed;

	}

	public static void rule1B(int[][] board, int row, int col) {
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

		boolean duplicateInRow = false;
		boolean duplicateInColumn = false;
		boolean duplicateInSubgrid = false;
		int[] temp = possibleValsGenerator(board, row, col);
		// value is the number your checking
		int value = temp[0];

		// place for loops to change boolean values

		if (board[row][col] == 0) {
			/*
			 * if value is contained in any of the other possible value arrays
			 * don't place go through each group and check within your for loops
			 * change the value of duplicate boolean
			 * 
			 */
			// place individual checks here
			// checking with possible value arrays in row

			for (int i = 0; i < 9; i++) {
				if (i != col) {
					// don't generate a possible values array for row and column
					// given
					int[] rowCompares = possibleValsGenerator(board, row, i);
					for (int j = 0; j < rowCompares.length; j++) {
						if (rowCompares[j] == value) {
							duplicateInRow = true;
							// System.out.println("Nah");

						}
					}
				}

			}

			// // checking with possible value arrays in column
			for (int j = 0; j < 9; j++) {
				while (j != row) {
					int[] coloumnCompares = possibleValsGenerator(board, j, col);
					for (int i = 0; i < coloumnCompares.length; i++) {
						if (value == coloumnCompares[i]) {
							duplicateInColumn = true;
							System.out.println("Whaaaa");

						}
					}
				}

			}

			if (duplicateInColumn == false) {

				System.out.println(Arrays.toString(possibleValsGenerator(board, row, col)));
				System.out.println("I didn't make it this far");

			}

			System.out.println(Arrays.toString(possibleValsGenerator(board, row, col)));

		} else if ((board[row][col] != 0)) {
			System.out.println("location already filled");
		}

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

		// int[] temp = possibleValsGenerator(board, row, col);
		// // value is the number you're checking
		// int value = temp[0];
		//
		// if (board[row][col] == 0) {
		// /*
		// * if value is contained in any of the other possible value arrays
		// * don't place go through each group and check within your for loops
		// * change the value of duplicate boolean
		// *
		// * if a group is full i.e will add up to 45 with your value place it
		// */
		// if (isRowFull(board, row, value) == true || isColumnFull(board, col,
		// value) == true
		// || isSubGridFull(board, row, col, value) == true) {
		// System.out.println(Arrays.toString(possibleValsGenerator(board, row,
		// col)));
		// } else {
		//
		// }
		//
		// } else if ((board[row][col] != 0)) {
		// System.out.println("location already filled");
		// }

	}

}
