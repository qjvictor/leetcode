package matrix;
/**
 * ou are given a m x n 2D grid initialized with these three possible values.

    -1 - A wall or an obstacle.
    0 - A gate.
    INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 * @author VictorQian
 *
 */
public class WallsAndGates {
	public static void main(String[] args){
		WallsAndGates w = new WallsAndGates();
		int INF = Integer.MAX_VALUE;
		int[] col1=new int[]{INF, -1, 0, INF};
		int[] col2=new int[]{INF, INF, INF, -1};
		int[] col3=new int[]{INF, -1, INF, -1};
		int[] col4=new int[]{0, -1, INF, INF};
		int[][] rooms=new int[][]{col1, col2, col3, col4};
		w.wallsAndGates(rooms);
		System.out.println(rooms);
	}
	
	
	public void wallsAndGates(int[][] rooms) {
        if(rooms==null || rooms.length==0 || rooms[0].length==0) return;
        int row = rooms.length;
        int col = rooms[0].length;
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
        		if(rooms[i][j]==0){
        			helper(rooms, i, j, 0);
        		}
        	}
        }
    }
	
	private void helper(int[][] rooms, int iPos, int jPos, int distance){
		 if(iPos>0 && rooms[iPos-1][jPos]!=0 && rooms[iPos-1][jPos]>distance+1){
        	rooms[iPos-1][jPos]=distance+1;
        	helper(rooms, iPos-1, jPos, distance+1);
        }
        if(iPos<rooms.length-1 && rooms[iPos+1][jPos]!=0 && rooms[iPos+1][jPos]>distance+1){
        	rooms[iPos+1][jPos]=distance+1;
        	helper(rooms, iPos+1, jPos, distance+1);
        }
        if(jPos>0 && rooms[iPos][jPos-1]!=0 && rooms[iPos][jPos-1]>distance+1){
        	rooms[iPos][jPos-1]=distance+1;
        	helper(rooms, iPos, jPos-1, distance+1);
        }
        if(jPos<rooms[0].length-1 && rooms[iPos][jPos+1]!=0 && rooms[iPos][jPos+1]>distance+1){
        	rooms[iPos][jPos+1]=distance+1;
        	helper(rooms, iPos, jPos+1, distance+1);
        }
	}
	
	
}
