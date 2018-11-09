package p4;

public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] grid = new String[3];//single dimension array
		grid[0] = "-";
		grid[1] = "-";
		grid[2] = "-";
		
		String[][] board = new String[3][3];//create 2D array 3 rows 3 cols
		board[0][0] = "-";
		board[1][1] = "-"; //fill middle index
		board[0][2] = "-";
		
		for(int i = 0; i < grid.length;i++) {//prints out rows only
			System.out.println(grid[i]);
		}
		
		//fill and print 2d array
		System.out.println("fill and print 2d array");
		for(int row = 0; row < board.length; row++) {//prints down (rows)
			
			//prints each column
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = "-";
				System.out.print(	board[row][col] );
			}
			
			System.out.println();//prints a new line after the row is done
		}//end for loop to print rows
		
		board[1][1] = "X";

for(int row = 0; row < board.length; row++) {//prints down (rows)
			//prints each column
			for(int col = 0; col < board[row].length; col++) {
//				board[row][col] = "-"; //fills in the board with dashes
				System.out.print(	board[row][col] );
			}
			System.out.println();//prints a new line after the row is done
		}//end for loop to print rows

int player = 1;
//take input player
//place the token
//switch players
player = 2;


	}// main

}
