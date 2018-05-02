import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PossibleValues {

	private int[] values = new int[9];
	int N = 9;
	// global variable so it's easily accessible

	int[][] gridTwoDim = new int[N][N];
	int[][] gameBoard = new int[N][N];

	public int [][] board() throws IOException{
		
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
				
				
				return gridTwoDim[][]
		
		
	}

	public static int[] possibleVals(int[][] board, int row, int col) {
		int[] alreadyUsed;
		int[] vals = new int[9];
		ValueSet currentSet = new ValueSet();
		
		//possibleValSet values = new possibleValSet();
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

			for (int i = x_position; i < (x_position + 2); i++) {
				for (int j = y_position; j < (y_position + 2); j++) {
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
		     //Re-use alreadyInUse array
			 alreadyUsed = new int[size];
		     size = 0;
			 //Remove the zeros and store the rest of the numbers in alreadyInUse array
			 for(int i = 0; i < vals.length; i++){
				 if(vals[i] !=0 ){
					 alreadyUsed[size] = vals[i];
					 size++;
				 }
			 }
			 
		}

		return alreadyUsed;

	}
	public static void main(String[] args) throws IOException {
		
		int[][] board = { 
			  { 1, 2, 3, 0, 0, 0, 0, 0, 0 },
			  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			  { 0, 0, 0, 4, 0, 6, 0, 0, 0 },

		      { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		      { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		      { 0, 0, 0, 0, 0, 0, 0, 0, 0, },

	          { 0, 0, 0, 0, 7, 0, 0, 0, 0 }, 
	          { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, 
	          { 0, 0, 0, 0, 9, 0, 0, 0, 0 } };
		
	//	System.out.println(possibleVals(board, 0,0));
		  System.out.println(Arrays.toString(possibleVals(board, 3,8)));
		
		
		
	}

}
