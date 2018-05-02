import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Scanner;

public class Input {

	public static void main(String[] args) throws IOException {

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
		int N = 9;
		char[] array = new char[N * N];
		array = key.toCharArray();
		int[] gridOneDim = new int[N * N];
		int[][] gridTwoDim = new int[N][N];

		// print 1D array for input values
		System.out.println("Printing as single line of input");
		System.out.println();
		for (int i = 0; i < N * N; i++)
			// the line below populates 1d grid array from 1d char array
			gridOneDim[i] = (int) array[i] - 48;
		// System.out.print(grid[i] = (int) array[i] - 48);
		System.out.println();

		// converting 1D array to 2d array
		System.out.println();
		System.out.println("Printing as 2D array");
		System.out.println();
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				gridTwoDim[i][j] = gridOneDim[(j % 9 + i * 9)];

		// printing out input file in grid format
		for (int m = 0; m < 9; m++) {
			for (int n = 0; n < 9; n++) {
				System.out.print(gridTwoDim[m][n] + " ");
			}
			System.out.println();

		}

		// code below is also to add boarders
		System.out.println();
		System.out.println("Printing with borders");
		System.out.println();

		for (int m = 0; m < 9; m++) {
			if (m % 3 == 0)
				System.out.println(" -----------------------");
			for (int n = 0; n < 9; n++) {
				if (n % 3 == 0)
					System.out.print("| ");
				System.out.print(gridTwoDim[m][n]);

				// System.out.print(gridTwoDim[m][n] == 0 ? " " :
				// Integer.toString(gridTwoDim[m][n]));

				System.out.print(' ');
			}
			System.out.println("|");
		}

		System.out.println(" -----------------------");

		
		
		

	}

}
