import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class gameBoard {

	/*
	 * Every position in your board will have every possible value 1-9 then when
	 * the input is board is loaded the possible values at every position will
	 * change then every time you run a rule values will be inserted into the
	 * board have a solve method too!
	 */

	

	public int getRowIndex(String fileName) throws IOException {
		int row = 0;
		String key = "";

		{

			FileReader file = new FileReader(fileName);
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(file);

			String line = reader.readLine();

			while (line != null) {
				key += line;
				line = reader.readLine();
			}

		}

		if (key.contains("A 0 0") || key.contains("A 0 1") || key.contains("A 0 2") || key.contains("A 0 3")
				|| key.contains("A 0 4") || key.contains("A 0 5") || key.contains("A 0 6") || key.contains("A 0 7")
				|| key.contains("A 0 8")) {
			row = 0;

		} else if (key.contains("B 0 0") || key.contains("B 0 1") || key.contains("B 0 2") || key.contains("B 0 3")
				|| key.contains("B 0 4") || key.contains("B 0 5") || key.contains("B 0 6") || key.contains("B 0 7")
				|| key.contains("B 0 8")) {
			row = 0;
		}

		return row;

	}

	public static int[] possibleValsGenerator(int[][] board, int row, int col) {

		/*
		 * this method populates an array with possible values at a given
		 * position which will later be copied over to you object array
		 * 
		 * NB. You wont specify the position from the terminal. this method must
		 * be put through a for loop
		 * 
		 */
		int[] possibleValues;
		int[] vals = new int[9];
		int currentIndex = 0;
		int size = 0;
		boolean valueMatch;

		if (board[row][col] != 0) {
			return new int[] { board[col][row] };
		}

		else {
			possibleValues = new int[26];
			// Go into Row x and store all available numbers in possibleValues
			for (int i = 0; i < board.length; i++) {
				if (board[row][i] != 0) {
					possibleValues[currentIndex] = board[row][i];
					currentIndex++;
				}

			}
			// Go into Column y and store all available numbers in
			// possibleValues
			for (int j = 0; j < board.length; j++) {
				if (board[j][col] != 0) {
					possibleValues[currentIndex] = board[j][col];
					currentIndex++;
				}
			}

			// Go into subarray and store all available numbers in
			// possibleValues
			int x_position = (row / 3) * 3;
			int y_position = (col / 3) * 3;

			for (int i = x_position; i < (x_position + 3); i++) {
				for (int j = y_position; j < (y_position + 3); j++) {
					if (board[i][j] != 0) {
						possibleValues[currentIndex] = board[i][j];
						currentIndex++;
					}
				}

			}

			// Now your array contains duplicates so you need to
			// compare 1-9 with the numbers stored in possibleValues array

			for (int i = 1; i < 10; i++) {
				valueMatch = false;
				// if there is a pair that matches, break

				for (int j = 0; j < possibleValues.length; j++) {
					if (possibleValues[j] == i) {
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
			// Re-use possibleValues array
			possibleValues = new int[size];
			size = 0;
			// Remove the zeros and store the rest of the numbers in
			// possibleValues array
			for (int i = 0; i < vals.length; i++) {
				if (vals[i] != 0) {
					possibleValues[size] = vals[i];
					size++;
				}
			}

		}

		return possibleValues;

	}

	public static possibleValSet getValueObject(int[][] board, int row, int col) {

		/*
		 * this method returns the object which contains the array holding your
		 * possible values at a given position
		 */
		possibleValSet values = new possibleValSet();
		values.valueSet = possibleValsGenerator(board, row, col);
		return values;
	}

	public static Object board(int[][] board, int row, int col) {
		/*
		 * this method populates your object array containing your possible
		 * values array at every position is this method needed and will it even
		 * work?
		 */

		Object[][] boardArray = new Object[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				boardArray[i][j] = getValueObject(board, row, col);
			}
		}

		return boardArray;

	}

	public void printBoard(int[][] board, int row, int col) {
		/*
		 * print possible values array then print object array
		 */
	}

	public static void testingRule1a() throws IOException {
		System.out.println("Testing 1a");
		rules.rule1a(inputFile.getBoard(), 0, 4);
		rules.rule1a(inputFile.getBoard(), 0, 4);
		rules.rule1a(inputFile.getBoard(), 5, 4);
		rules.rule1a(inputFile.getBoard(), 5, 5);
		rules.rule1a(inputFile.getBoard(), 5, 7);
		rules.rule1a(inputFile.getBoard(), 7, 1);
	//	rules.rule1a(inputFile.getBoard("board_6.ins"), 7, 1);
	}

	public static void testingRule1b() throws IOException {
		//rules.rule1b(inputFile.getBoard("board_1.ins"), 0, 8);
		System.out.println("Testing 1b");
		rules.rule1b(inputFile.getBoard(), 0, 8);
		rules.rule1b(inputFile.getBoard(), 8, 0);
		rules.rule1b(inputFile.getBoard(), 4, 4);
		rules.rule1b(inputFile.getBoard(), 3, 5);
		rules.rule1b(inputFile.getBoard(), 7, 4);
		rules.rule1b(inputFile.getBoard(), 2, 5);

	}

	public static void testingRule4a() throws IOException{
		System.out.println("Testing 4a");
		rules.rule4a(inputFile.getBoard(), 3, 3,2);
		//rules.rule4a(inputFile.getBoard(), 0, 2,3);
		//rules.rule4a(inputFile.getBoard(), 0, 5,7);
		//rules.rule4a(inputFile.getBoard(), 6, 0,4);
		//rules.rule4a(inputFile.getBoard(), 4, 4,2);
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 testingRule1a();
		//testingRule1b();
		//testingRule4a();
	}
	

}
