package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  You are given coins of different denominations and a total amount of money amount. 
 *  Write a function to compute the fewest number of coins that you need to make up that amount. 
 *  If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin. 
 * @author VictorQian
 *
 */
public class CoinChange {
	public static void main(String[] args){
		CoinChange cc = new CoinChange();
		System.out.println(cc._coinChange(new int[]{1,2,5},11));
		System.out.println(cc.coinChange(new int[]{1,2,5},11));
		System.out.println(cc.coinChange(new int[]{2},3));
		System.out.println(cc.totalWays_CoinChange(new int[]{1,2,3},5));
		System.out.println(cc.Ways_CoinChange(new int[]{1,2,3},5));
	}
	
	public int _coinChange(int[] coins, int amount) {
		if (coins == null || amount < 0)
			return -1;
		if (amount == 0)
			return 0;
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j] && dp[i - coins[j]] != -1)
					min = Math.min(min, 1 + dp[i - coins[j]]);
			}
			dp[i] = min == Integer.MAX_VALUE ? -1 : min;
		}
		return dp[amount];
    }
	
	public int coinChange(int[] coins, int amount) {
		if (coins == null || amount < 0)
			return -1;
		if (amount == 0)
			return 0;
		int BIG_NUMBER = Integer.MAX_VALUE - 1;
		int[][] dp = new int[coins.length][amount + 1];
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j >= coins[i]) {
					dp[i][j] = Math.min((i == 0 ? BIG_NUMBER : dp[i - 1][j]), dp[i][j - coins[i]] + 1);
				} else {
					dp[i][j] = (i == 0 ? BIG_NUMBER : dp[i - 1][j]);
				}
			}
		}
		return dp[coins.length - 1][amount] == BIG_NUMBER ? -1 : dp[coins.length - 1][amount];
	}
	
	
	public int totalWays_CoinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount < 0)
			return -1;
		int[][] dp = new int[coins.length][amount + 1];
		for (int i = 0; i < coins.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j >= coins[i]) {
					dp[i][j] = (i == 0 ? 0 : dp[i - 1][j]) + dp[i][j - coins[i]];
				} else {
					dp[i][j] = i == 0 ? 0 : dp[i - 1][j];
				}
			}
		}
		return dp[coins.length - 1][amount];
	}
	
	public List<List<Integer>> Ways_CoinChange(int[] coins, int amount) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (coins == null || coins.length==0 || amount < 0)
			return ret;
		helper(ret, new ArrayList<Integer>(), coins, amount);
		return ret;
	}

	private void helper(List<List<Integer>> ret, ArrayList<Integer> list, int[] coins, int amount) {
		if(amount==0){
			ret.add(new ArrayList<Integer>(list));
			return;
		}
		
		for(int i=0;i<coins.length;i++){
			if(amount>=coins[i]){
				list.add(coins[i]);
				helper(ret, list, coins, amount-coins[i]);
				list.remove(list.size()-1);
			}
		}
	}
	
	
}
