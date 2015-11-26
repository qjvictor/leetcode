package binarysearch;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true
 * @author evicqia
 *
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix[0] == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int rTop = 0;
		int rBottom = matrix.length - 1;
		int cols = matrix[0].length - 1;
		while (rTop <= rBottom) {
			int rMid = (rTop + rBottom) / 2;
			if (matrix[rMid][0] <= target && target <= matrix[rMid][cols]) {// find
																			// it.
				int colL = 0, colR = cols;
				while (colL <= colR) {
					int colMid = (colL + colR) / 2;
					if (matrix[rMid][colMid] == target) {
						return true;
					} else if (matrix[rMid][colMid] > target) {
						colR = colMid - 1;
					} else {
						colL = colMid + 1;
					}
				}
				return false;
			} else if (matrix[rMid][0] > target) {// too big
				rBottom = rMid - 1;
			} else {
				rTop = rMid + 1;
			}
		}
		return false;
    }
	

	public static void main(String[] args){
		Search2DMatrix s = new Search2DMatrix();
		System.out.println(s.searchMatrix(new int[][]{new int[]{1,3,5,7},new int[]{10,11,27,28},new int[]{31,33,35,37},new int[]{41,43,45,47}}, 26));
	}
}
