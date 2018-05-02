import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Board {

	// private static Set<Integer> valuesSet = new HashSet<Integer>();

	int N = 9;
	// global variable so it's easily accessible

	int[][] gridTwoDim = new int[N][N];
	int[][] gameBoard = new int[N][N];

	// constructor will take in file name and create new board
	public Board() throws IOException {

		// this is the board you are going to give in to your value geverator.

		String key = "";

		{
			FileReader file = new FileReader("board_1.ins");
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(file);

			String line = reader.readLine();

			while (line != null) {
				key += line;
				line = reader.readLine();
			}

		}

		// int N = 9;
		char[] array = new char[N * N];
		array = key.toCharArray();
		int[] gridOneDim = new int[N * N];
		// int[][] gridTwoDim = new int[N][N];

		// print 1D array for input values

		for (int i = 0; i < N * N; i++) {
			// the line below populates 1d grid array from 1d char array
			gridOneDim[i] = (int) array[i] - 48;
		}
		// converting 1D array to 2d array

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				gridTwoDim[i][j] = gridOneDim[(j % 9 + i * 9)];
		}
		// code below is also to add boarders

		for (int m = 0; m < 9; m++) {
			if (m % 3 == 0)
				System.out.println(" -----------------------");
			for (int n = 0; n < 9; n++) {
				if (n % 3 == 0)
					System.out.print("| ");
				System.out.print(gridTwoDim[m][n]);

				System.out.print(' ');
			}
			System.out.println("|");
		}

		System.out.println(" -----------------------");

	}

	public int[][] board() {

		return gridTwoDim;

	}

	/*
	 * public static Set<Integer> valueSet(Set<Integer> valuesSet)) {
	 * 
	 * // this method creates the hash set and should return the set
	 * 
	 * // Set<Integer> valuesSet = new HashSet<Integer>();
	 * 
	 * valuesSet.add(1); valuesSet.add(2); valuesSet.add(3); valuesSet.add(4);
	 * valuesSet.add(5); valuesSet.add(6); valuesSet.add(7); valuesSet.add(8);
	 * valuesSet.add(9);
	 * 
	 * return valuesSet;
	 * 
	 * }
	 */

	/*
	 * public static Set<Integer> getSet() { return valuesSet; }
	 */

	public void printBoard() {
		// this function will print the board

		for (int m = 0; m < 9; m++) {
			if (m % 3 == 0)
				System.out.println(" -----------------------");
			for (int n = 0; n < 9; n++) {
				if (n % 3 == 0)
					System.out.print("| ");
				System.out.print(gridTwoDim[m][n]);

				System.out.print(' ');
			}
			System.out.println("|");
		}

		System.out.println(" -----------------------");

	}

	public int getColLocation() {
		return 0;
	}

	public int getRowLocation() {

		return 0;
	}

	public int getSubGridLocation() {

		// have if statements
		/*
		 * if (A){ you are in this subGrid }
		 */
		return 0;

	}

	public ValueSet possibilitySetGenerator(ValueSet values, int[][] board) {
		// this method will generate a set of possible values for each cell
		// therefore each each cell will contain a set.
		// the method will return a set and you will need another method to
		// populate you 2Darray of valSets
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != 0) {
					
					
					
					

				}
			}
		}

		return values;

	}

	public int[][] possibilityBoard(int inputboard[][],ValueSet values) {
		//is this method needed??? 
		for( int i = 0; i < 9; i++){
			for( int j =0; j <9; j++){
				
				gameBoard [i][j] =  possibilitySetGenerator(values,inputboard); 
				
			}
		}

		return gameBoard;
	}

	public static ValueSet rule1a(ValueSet values, int[][] boardArray) {

		// value of which sub grid, row and columns should also be given as
		// arguments for this rule

		// checking if value is contained in selected row

		for (int i = 0; i < 9; i++) {
			if (values.contains(boardArray[5][i])) {
				values.removeElement(boardArray[5][i]);

			}

			// System.out.print(boardArray[0][i]);
		}

		// checking if value is contained in selected column

		for (int j = 0; j < 9; j++) {
			if (values.contains(boardArray[j][5])) {
				values.removeElement(boardArray[j][5]);

			}

		}

		// Checking if value is contained in selected sub-grid
		for (int j = 3; j < 6; j++) {
			for (int i = 3; i < 6; i++) {
				// 2 if statments to remvove values from sub- grid rows and
				// sub-grid columns

				// remove from sub columns
				// j is which column you are in
				// i is which row you are in
				if (values.contains(boardArray[j][i])) {
					values.removeElement(boardArray[j][i]);

				}

			}
		}

		System.out.println("I am working :)");
		// this method returns the value set which you are left with
		return values;
	}

	public static int rule1b(ValueSet values, int[][] boardArray) {

		return 0;

	}

	public static void main(String[] args) throws IOException {

		// take in board file and rule file as arguments and then deal with them
		// appropriately

		Board a = new Board();
		ValueSet currentSet = new ValueSet();
		int[][] gameArray = a.board();

		// Try printing array in separate function

		for (int i = 0; i < 9; i++) {
			if (currentSet.contains(gameArray[0][i])) {
				currentSet.removeElement(gameArray[0][i]);

			}

			// System.out.println(gameArray[0][i]);
		}
		System.out.println(currentSet.valueSet());

		System.out.println(rule1a(currentSet, gameArray).valueSet());

		System.out.println("Testing value set gnerator");
	}

}
