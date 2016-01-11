package dp;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author VictorQian
 * 
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0)
            return 0;
        int[][] sum = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0){
                    sum[0][0]=grid[0][0];
                }else if(i==0){
                    sum[0][j]=grid[0][j]+sum[0][j-1];
                }else if(j==0){
                    sum[i][0]=grid[i][0]+sum[i-1][0];
                }else{
                    sum[i][j]=grid[i][j]+Math.min(sum[i-1][j], sum[i][j-1]);
                }
            }
        }
        return sum[grid.length-1][grid[0].length-1];
    }
}
