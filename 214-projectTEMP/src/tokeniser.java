import java.io.IOException;
import java.util.StringTokenizer;

public class tokeniser {

	/*
	 * this method will break down your input file into tokens
	 * 
	 * split up input file into tokens 1st token will be rule 2nd token will be
	 * sub-grid block 3rd token will be row 4th token will be column 5th token
	 * will be a value entered if needed
	 * 
	 * create a method to get each token place all tokens in an array if you are
	 * in putting a value you will have 5 tokens instead of 4 The method will
	 * return the desired token in the correct format, int etc.
	 * 
	 * this class will also used to determine the real location of a move in
	 * relation to how the project will run e.g B 0 1 = (0,4);
	 *
	 */

	public static String fileName;
	public static String rule;
	public static String block;
	public static int row;
	public static int column;
	public static int value;

	public static int actualRow;
	public static int actualColumn;

	public static void commandFile() throws IOException {
		fileName = inputFile.getCommandFile();

	}

	public static String[] tokeniseFile(String commandFileName) {

		/*
		 * Store each token as a string in a String array
		 */

		StringTokenizer commandFN = new StringTokenizer(commandFileName);
		int lengthOfToken = commandFN.countTokens();
		String[] fileInput = new String[lengthOfToken];

		while (commandFN.hasMoreTokens()) {
			for (int i = 0; i < fileInput.length; i++) {
				fileInput[i] = commandFN.nextToken();
			}

		}

		return fileInput;
	}

	public static String getRule(String[] inputFile) {

		rule = inputFile[0];
		return rule;

	}

	public static String getSubGridBlock(String[] inputFile) {
		block = inputFile[1];
		return block;

	}

	public static int getRow(String[] inputFile) {

		String stringRow = inputFile[2];

		row = Integer.parseInt(stringRow);
		return row;

	}

	public static int getColumn(String[] inputFile) {
		String stringColumn = inputFile[3];
		column = Integer.parseInt(stringColumn);
		return column;

	}

	public static int getValue(String[] inputFile) {

		String stringValue = inputFile[4];

		value = Integer.parseInt(stringValue);
		return value;

	}

	public static int actualRow(String block, int row) {
		// For A
		if (block == "A" && row == 0) {
			actualRow = 0;
		} else if (block == "A" && row == 1) {
			actualRow = 1;
		} else if (block == "A" && row == 2) {
			actualRow = 2;
		}

		// For B
		else if (block == "B" && row == 0) {
			actualRow = 0;
		} else if (block == "B" && row == 1) {
			actualRow = 1;
		} else if (block == "B" && row == 2) {
			actualRow = 2;
		}
		// For C
		else if (block == "C" && row == 0) {
			actualRow = 0;
		} else if (block == "C" && row == 1) {
			actualRow = 1;
		} else if (block == "C" && row == 2) {
			actualRow = 2;
		}
		// For D
		else if (block == "D" && row == 0) {
			actualRow = 3;
		} else if (block == "D" && row == 1) {
			actualRow = 4;
		} else if (block == "D" && row == 2) {
			actualRow = 5;
		}
		// For E
		else if (block == "E" && row == 0) {
			actualRow = 3;
		} else if (block == "E" && row == 1) {
			actualRow = 4;
		} else if (block == "E" && row == 2) {
			actualRow = 5;
		}
		// For F
		else if (block == "F" && row == 0) {
			actualRow = 3;
		} else if (block == "F" && row == 1) {
			actualRow = 4;
		} else if (block == "F" && row == 2) {
			actualRow = 5;
		}
		// For G
		else if (block == "G" && row == 0) {
			actualRow = 6;
		} else if (block == "G" && row == 1) {
			actualRow = 7;
		} else if (block == "G" && row == 2) {
			actualRow = 8;
		}
		// For H
		else if (block == "H" && row == 0) {
			actualRow = 6;
		} else if (block == "H" && row == 1) {
			actualRow = 7;
		} else if (block == "H" && row == 2) {
			actualRow = 8;
		}

		// For I
		else if (block == "I" && row == 0) {
			actualRow = 6;
		} else if (block == "I" && row == 1) {
			actualRow = 7;
		} else if (block == "I" && row == 2) {
			actualRow = 8;
		}
		return actualRow;

	}

	public static int actualColumn(String block, int column) {

		// For A
		if (block == "A" && column == 0) {
			actualColumn = 0;
		} else if (block == "A" && column == 1) {
			actualColumn = 1;
		} else if (block == "A" && column == 2) {
			actualColumn = 2;
		}

		// For B
		else if (block == "B" && column == 0) {
			actualColumn = 3;
		} else if (block == "B" && column == 1) {
			actualColumn = 4;
		} else if (block == "B" && column == 2) {
			actualColumn = 5;
		}
		// For C
		else if (block == "C" && column == 0) {
			actualColumn = 6;
		} else if (block == "C" && column == 1) {
			actualColumn = 7;
		} else if (block == "C" && column == 2) {
			actualColumn = 8;
		}
		// For D
		else if (block == "D" && column == 0) {
			actualColumn = 0;
		} else if (block == "D" && column == 1) {
			actualColumn = 1;
		} else if (block == "D" && column == 2) {
			actualColumn = 2;
		}
		// For E
		else if (block == "E" && column == 0) {
			actualColumn = 3;
		} else if (block == "E" && column == 1) {
			actualColumn = 4;
		} else if (block == "E" && column == 2) {
			actualColumn = 5;
		}
		// For F
		else if (block == "F" && column == 0) {
			actualColumn = 6;
		} else if (block == "F" && column == 1) {
			actualColumn = 7;
		} else if (block == "F" && column == 2) {
			actualColumn = 8;
		}
		// For G
		else if (block == "G" && column == 0) {
			actualColumn = 0;
		} else if (block == "G" && column == 1) {
			actualColumn = 1;
		} else if (block == "G" && column == 2) {
			actualColumn = 2;
		}
		// For H
		else if (block == "H" && column == 0) {
			actualColumn = 3;
		} else if (block == "H" && column == 1) {
			actualColumn = 4;
		} else if (block == "H" && column == 2) {
			actualColumn = 5;
		}

		// For I
		else if (block == "I" && column == 0) {
			actualColumn = 6;
		} else if (block == "I" && column == 1) {
			actualColumn = 7;
		} else if (block == "I" && column == 2) {
			actualColumn = 8;
		}

		return actualColumn;

	}

	public static int getActualColumn(){
		return actualColumn;
		
	}
	public static int getActualRow(){
		return actualRow;
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// run this line to set fileNameString
		commandFile();
//		System.out.println(getRule(tokeniseFile(fileName)));
//		System.out.println(getSubGridBlock(tokeniseFile(fileName)));
//		System.out.println(getRow(tokeniseFile(fileName)));
//		System.out.println(getColumn(tokeniseFile(fileName)));
		
		actualRow(getSubGridBlock(tokeniseFile(fileName)),getRow(tokeniseFile(fileName)));
		System.out.println(actualRow);

	}

}
