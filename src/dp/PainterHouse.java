package dp;

/**
 * There are a row of n houses, each house can be painted with one of the three
 * colors: red, blue or green. The cost of painting each house with a certain
 * color is different. You have to paint all the houses such that no two
 * adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color red; costs[1][2] is the cost of painting house 1 with color green, and
 * so on... Find the minimum cost to paint all houses.
 * 
 * @author VictorQian
 * 
 */
public class PainterHouse {
	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0 || costs[0].length != 3)
			return 0;
		int r=costs[costs.length - 1][0];
		int g=costs[costs.length - 1][1];
		int b=costs[costs.length - 1][2];
		for (int i = costs.length - 2; i >= 0; i--) {
			int rr=r, gg=g, bb=b;
			r = Math.min(gg,bb) + costs[i][0];
			g = Math.min(rr,bb) + costs[i][1];
			b = Math.min(rr,gg) + costs[i][2];
		}

		return Math.min(Math.min(r, g), b);
	}
	
	public int _minCost(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0 || costs[0].length != 3)
			return 0;
		int r=costs[0][0];
		int g=costs[0][1];
		int b=costs[0][2];
		for (int i = 1; i <costs.length; i++) {
			int rr=r, gg=g, bb=b;
			r = Math.min(gg,bb) + costs[i][0];
			g = Math.min(rr,bb) + costs[i][1];
			b = Math.min(rr,gg) + costs[i][2];
		}

		return Math.min(Math.min(r, g), b);
	}
	
	public static void main(String[] args){
		PainterHouse p = new PainterHouse();
		int[] cost1=new int[]{1,2,3};
		int[] cost2=new int[]{11,5,8};
		int[] cost3=new int[]{20,22,13};
		int[][] costs = new int[][]{cost1, cost2, cost3};
		System.out.println(p.minCost(costs));
		System.out.println(p._minCost(costs));
	}
}
