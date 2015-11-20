package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other. Given an integer n, return all
 * distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * 
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 * 
 * @author VictorQian
 * 
 */
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		int[] usedColumns = new int[n];
		Arrays.fill(usedColumns, -1);
		DFS(0, usedColumns, res);
		return res;
	}

	void DFS(int row, int[] usedColumns, List<List<String>> res) {
		int n = usedColumns.length;
		if (row == n) {
			res.add(drawChess(usedColumns));
			return;
		}
		// Check Possible columns for the inputed row.
		for (int i = 0; i < n; i++) {
			if (isValid(usedColumns, row, i)) {
				usedColumns[row] = i;
				DFS(row + 1, usedColumns, res);
			}
		}
	}

	ArrayList<String> drawChess(int[] usedColumns) {
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < usedColumns.length; i++) {
			char[] line = new char[usedColumns.length];
			Arrays.fill(line, '.');
			line[usedColumns[i]] = 'Q';
			res.add(String.valueOf(line));
		}
		return res;
	}

	// Check if the column is valid to place queen for the row.
	boolean isValid(int[] usedColumns, int row, int col) {
		boolean isValid = true;
		for (int j = 0; j < row; j++) {
			// Excludes used columns and diagonal positions
			if (usedColumns[j] == col || row - j == Math.abs(col - usedColumns[j])) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}
}
