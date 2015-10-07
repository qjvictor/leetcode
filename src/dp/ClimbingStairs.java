package dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @author VictorQian
 * 
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		//O(n)/O(1)
		if(n<0) return 1;
		int[] ways = new int[2];
		ways[0]=1;
		ways[1]=1;
		for(int i=2;i<n+1;i++){
			int way=ways[0]+ways[1];
			ways[0]=ways[1];
			ways[1]=way;
		}
		return ways[1];
	}
	
	public static void main(String[] args){
		ClimbingStairs c = new ClimbingStairs();
		System.out.println(c.climbStairs(10));
	}
}
