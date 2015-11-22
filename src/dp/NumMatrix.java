package dp;
/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:

Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]
[[3, 3, 4, 8, 10], 
 [8, 14, 18, 24, 27], 
 [9, 17, 21, 28, 36], 
 [13, 22, 26, 34, 49], 
 [14, 23, 30, 38, 58]]
sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12

Note:

    You may assume that the matrix does not change.
    There are many calls to sumRegion function.
    You may assume that row1 ≤ row2 and col1 ≤ col2.

 * @author evicqia
 *
 */
public class NumMatrix {
	int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) 
        	return;
        sumMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 && j == 0) {
					sumMatrix[0][0] = matrix[0][0];
				} else if (i == 0) {
					sumMatrix[0][j] = sumMatrix[0][j - 1] + matrix[0][j];
				} else if (j == 0) {
					sumMatrix[i][0] = sumMatrix[i - 1][0] + matrix[i][0];
				} else {
					sumMatrix[i][j] =  sumMatrix[i - 1][j] 
									+ sumMatrix[i][j - 1]
									+ matrix[i][j] - sumMatrix[i - 1][j - 1];
				}
			}
		}
    }

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (row1 < 0 || row2 < 0 || col1 < 0 || col2 < 0 || row1 > row2
				|| col1 > col2)
			return -1;
		if (row1 == 0 && col1 == 0)
			return sumMatrix[row2][col2];
		return sumMatrix[row2][col2] - (col1>0?sumMatrix[row2][col1 - 1]:0) - (row1>0?sumMatrix[row1 - 1][col2]:0) + ((row1>0 && col1>0)?sumMatrix[row1 - 1][col1 - 1]:0);
	}
    
    public static void main(String[] args){
    	int[][] matrix = new int[][]{new int[]{3, 0, 1, 4, 2}, new int[]{5, 6, 3, 2, 1}, new int[]{1, 2, 0, 1, 5}, new int[]{4, 1, 0, 1, 7}, new int[]{1, 0, 3, 0, 5}};
    	NumMatrix n = new NumMatrix(matrix);
    	System.out.println(n.sumRegion(2, 1, 4, 3));
    	System.out.println(n.sumRegion(1, 1, 2, 2));
    	System.out.println(n.sumRegion(1, 2, 2, 4));
    	
    	int[][] matrix1 = new int[][]{new int[]{-4,-5}};
    	NumMatrix n1 = new NumMatrix(matrix1);
    	System.out.println(n1.sumRegion(0,0,0,0));
    	System.out.println(n1.sumRegion(0,0,0,1));
    	System.out.println(n1.sumRegion(0,1,0,1));
    }
//    sumRegion(2, 1, 4, 3) -> 8
//    sumRegion(1, 1, 2, 2) -> 11
//    sumRegion(1, 2, 2, 4) -> 12

 // Your NumMatrix object will be instantiated and called as such:
 // NumMatrix numMatrix = new NumMatrix(matrix);
 // numMatrix.sumRegion(0, 1, 2, 3);
 // numMatrix.sumRegion(1, 2, 3, 4);
}
