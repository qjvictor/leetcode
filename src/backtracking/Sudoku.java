package backtracking;

import java.util.HashSet;
import java.util.Set;


public class Sudoku {
	/**
	 * Write a program to solve a Sudoku puzzle by filling the empty cells.

		Empty cells are indicated by the character '.'.
	 * @param board
	 */
	public void solveSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0] == null || board[0].length != 9)
			return;
		solve(board);
	}

	public boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					continue;
				}
				for (int k = 1; k <= 9; k++) {
					board[i][j] = (char) (k + '0');
					if (isValid(board, i, j) && solve(board)) {
						return true;
					}
					board[i][j] = '.';
				}
				return false;
			}
		}
		return true;
	}

	public boolean isValid(char[][] board, int a, int b) {
		Set<Character> contained = new HashSet<Character>();
		for (int j = 0; j < 9; j++) {
			if (contained.contains(board[a][j]))
				return false;
			if (board[a][j] > '0' && board[a][j] <= '9')
				contained.add(board[a][j]);
		}

		contained = new HashSet<Character>();
		for (int j = 0; j < 9; j++) {
			if (contained.contains(board[j][b])) {
				return false;
			}
			if (board[j][b] > '0' && board[j][b] <= '9') {
				contained.add(board[j][b]);
			}
		}

		contained = new HashSet<Character>();
		for (int m = 0; m < 3; m++) {
			for (int n = 0; n < 3; n++) {
				int x = a / 3 * 3 + m, y = b / 3 * 3 + n;
				if (contained.contains(board[x][y])) {
					return false;
				}
				if (board[x][y] > '0' && board[x][y] <= '9') {
					contained.add(board[x][y]);
				}
			}
		}

		return true;
	}
	
	/**
	 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

	The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


	A partially filled sudoku which is valid.

	Note:
	A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated. 
	 * @author evicqia
	 *
	 */
	public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length!=9 || board[0]==null || board[0].length!=9)
        	return false;
        Set<Character> set = new HashSet<Character>();
        for (int a = 0; a < board.length; a++) { //each row.
            set.clear();
            for (char c : board[a]) {
                if (c == '.') continue;
                if (!set.add(c)) return false;
            }
        }

        for (int a = 0; a < board[0].length; a++) {//each col.
            set.clear();
            for (int b = 0; b < board.length; b++) {
                if (board[b][a] == '.') continue;
                if (!set.add(board[b][a])) return false;
            }
        }

        for (int a = 0; a < board.length / 3; a++) {//each 3X3 blocks.
            int y = 3 * a;
            for (int b = 0; b < board[0].length / 3; b++) {
                int x = 3 * b;
                set.clear();
                for (int v = 0; v < 3; v++) {
                    for (int h = 0; h < 3; h++) {
                        if (board[v + y][h + x] == '.') continue;
                        if (!set.add(board[v + y][h + x])) return false;
                    }
                }
            }
        }

        return true;
    }
	
	
}
