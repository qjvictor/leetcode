package matrix;
/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000

Answer: 1

Example 2:

11000
11000
00100
00011

Answer: 3
 * @author VictorQian
 *
 */
public class NumberOfIslands {
	public static void main(String[] args){
		NumberOfIslands w = new NumberOfIslands();
		char[] col1=new char[]{'1','1','1','1','0'};
		char[] col2=new char[]{'1','1','0','0','0'};
		char[] col3=new char[]{'0','0','1','0','0'};
		char[] col4=new char[]{'0','0','0','1','1'};
		char[][] square=new char[][]{col1, col2, col3, col4};
		System.out.println(w.numIslands(square));
	}
	
	public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        int ret=0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length;j++){
        		if(grid[i][j]=='1'){
        			ret++;
        			grid[i][j]='2';
        			helper(grid, i, j);
        		}
        	}
        }
        return ret;
    }

	private void helper(char[][] grid, int i, int j) {
		if(i>0 && grid[i-1][j]=='1'){
			grid[i-1][j]='2';
			helper(grid, i-1, j);
		}
		if(i<grid.length-1 && grid[i+1][j]=='1'){
			grid[i+1][j]='2';
			helper(grid, i+1, j);
		}
		if(j>0 && grid[i][j-1]=='1'){
			grid[i][j-1]='2';
			helper(grid, i, j-1);
		}
		if(j<grid[0].length-1 && grid[i][j+1]=='1'){
			grid[i][j+1]='2';
			helper(grid, i, j+1);
		}
	}
}
