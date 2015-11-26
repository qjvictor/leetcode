package binarysearch;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

For example,

Consider the following matrix: 
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.
Given target = 20, return false.
 * @author evicqia
 *
 */
public class Search2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix[0] == null || matrix.length == 0
				|| matrix[0].length == 0)
			return false;
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			int val = matrix[row][col];
			if (val == target)
				return true;
			else if (val < target) {
				row++;
			} else {
				col--;
			}
		}
		return false;
    }
	
	public static void main(String[] args){
		Search2DMatrix s = new Search2DMatrix();
		System.out.println(s.searchMatrix(new int[][]{new int[]{1,4,7,11,15},new int[]{2,5,8,12,19},new int[]{3,6,9,16,22},new int[]{10,13,14,17,24},new int[]{18,21,24,26,30}}, 20));
	}
}
