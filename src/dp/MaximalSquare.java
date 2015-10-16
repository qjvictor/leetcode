package dp;
/**
 *  Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 4. 
 * @author VictorQian
 *
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
			return 0;
		int m = matrix.length, n = matrix[0].length, maxLen = 0;
		int[][] b = new int[m + 1][n + 1]; //b[i][j] represent the edge length of the largest square ENDING at position (i, j)
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;
					maxLen = Math.max(b[i][j], maxLen); // update max length
				}
			}
		}
		return maxLen * maxLen;
	}
}
