import java.util.Arrays;
public class Testing {
	
	// Method for calculating all possibilities at specific position
	public int[] getPossibilities(int [] [] board, int row, int col){
	    int [] alreadyInUse;
	    int [] unsorted = new int[9];
	    int currentIndex = 0;
	    int size = 0;
	    boolean match;
	    if(board[row][col] != 0){
	        return  new int[]{board[col][row]};
	    }
	    else{
	        alreadyInUse = new int[26];
	        //Go into Row x and store all available numbers in alreadyInUse
	        for(int i=0; i<board.length; i++){
	            if(board[row][i] !=0){
	                alreadyInUse[currentIndex] = board[row][i];
	                currentIndex++;
	            }
	        }
	        //Go into Column y and store all available numbers in alreadyInUse
	        for(int j=0; j<board.length; j++){
	            if(board[j][col] !=0){
	                alreadyInUse[currentIndex] = board[j][col];
	                currentIndex++;
	            }
	        }
	        //Go into subarray and store all available numbers in alreadyInUse
	        int x_left = row - (row%3);
	        int y_top = col - (col%3);
	        for(int i=0; i<3; i++){
	            for(int j=0; j<3; j++){
	                if(board[i+x_left][j+y_top] != 0){
	                    alreadyInUse[currentIndex] = board[i+x_left][j+y_top];
	                }
	            }
	        }
	        //compare 1-9 with the numbers stored in alreadyInUse array
	        for(int i=1; i<10; i++){
	            match = false;
	            //if a pair matches, break;
	            for(int j=0; j<alreadyInUse.length; j++){
	                if(alreadyInUse[j] == i ){
	                    match = true;
	                    break;
	                }
	            }
	            //If no pair matches, store the number (i) in an unsorted array
	            if(!match){
	                size++;
	                unsorted[i-1] = i;
	            }
	        }
	        //Re-use alreadyInUse array
	        alreadyInUse = new int[size];
	        size = 0;
	        //Remove the zeros and store the rest of the numbers in alreadyInUse array
	        for(int i=0; i<unsorted.length; i++){
	            if(unsorted[i] != 0){
	                alreadyInUse[size] = unsorted[i];
	                size++;
	            }
	        }
	        return alreadyInUse;    
	    }   
	}
	
	public static void main(String[] args){
	    Sudoku sudoku;
	    String sud = "250030901010004000407000208005200000000098100040003000000360072070000003903000604";
	    sudoku = new Sudoku(sud);
	    System.out.println(sudoku.getPossibilities(3,4));
	    System.out.println(Arrays.toString(sudoku.getPossibilities(3,4)));
	
	
	}

}
