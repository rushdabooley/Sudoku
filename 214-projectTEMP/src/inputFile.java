import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class inputFile {
	
	/*
	 * This class will deal with the board input file and the command input file
	 */
	
	
	
	public static String getBoardFileName(){
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		System.out.flush();
		String filename = scanner.nextLine();
		//File file = new File(filename);
		return filename;
		
	}
	

	public static int[][] getBoard() throws IOException {
		
		
		String fileName = getBoardFileName();
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
		int N = 9;
		char[] array = new char[N * N];
		array = key.toCharArray();
		int[] gridOneDim = new int[N * N];
		int[][] gridTwoDim = new int[N][N];

		for (int i = 0; i < N * N; i++) {
			// the line below populates 1d grid array from 1d char array
			gridOneDim[i] = (int) array[i] - 48;
		}

		// converting 1D array to 2d array

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				gridTwoDim[i][j] = gridOneDim[(j % 9 + i * 9)];

			}

		}

		return gridTwoDim;
	}
	
public static String getCommandFileName(){
	
	/*
	 * This method takes the command file name in as input and returns it as a String (name of the file not it's contents)
	 */
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		System.out.flush();
		String filename = scanner.nextLine();
		//File file = new File(filename);
		return filename;
		
	}
	
	public static String getCommandFile () throws IOException{
		
		/*
		 * This method only gets the contents of the command file and returns it's contents as a String
		 */
		String fileName = getCommandFileName();
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
		
		
		return key;
		
	}
	

}
