package matrix;
/**
 *  According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state.

Follow up:

    Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

 * @author VictorQian
 *
 */
public class GameOfLife {
	/**
	 [2nd bit, 1st bit] = [next state, current state]

	- 00 dead (current) -> dead (next)
	- 01 live (current) -> dead (next)
	- 10 dead (current) -> live (next)
	- 11 live (current) -> live (next)
	 */
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		//create a wrapper to make getLivingNeighbors() easier. 
		int[][] wrapper = new int[board.length + 2][board[0].length + 2];
		for (int i = 1; i <= board.length; i++) {
			for (int j = 1; j <= board[0].length; j++) {
				wrapper[i][j] = board[i - 1][j - 1];
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int n = getLivingNeighbors(wrapper, i + 1, j + 1);
				if((board[i][j]&1)==1){// live cell
					if (n == 2 || n == 3) {
						board[i][j] = board[i][j] + 2; // Make the 2nd bit 1: 01 ---> 11
					} 
				}else{//dead cell
					if(n==3){
						board[i][j] = board[i][j] + 2; // Make the 2nd bit 1: 00 ---> 10
					}
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = board[i][j] >> 1;
			}
		}
	}

	private int getLivingNeighbors(int[][] wrapper, int i, int j) {
		return (wrapper[i - 1][j - 1] & 1) + (wrapper[i - 1][j] & 1) + (wrapper[i - 1][j + 1] & 1) 
				+ (wrapper[i][j - 1] & 1) + (wrapper[i][j + 1] & 1) 
				+ (wrapper[i + 1][j - 1] & 1)
				+ (wrapper[i + 1][j] & 1) + (wrapper[i + 1][j + 1] & 1);
	}
}
