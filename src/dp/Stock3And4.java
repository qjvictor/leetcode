package dp;

/**
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author evicqia
 * 
 */
public class Stock3And4 {
	/**
	 * local[i][j]为在到达第i天时最多可进行j次交易并且最后一次交易在最后一天卖出的最大利润，此为局部最优。
	 * 然后我们定义global[i][j]为在到达第i天时最多可进行j次交易的最大利润，此为全局最优
	 * local[i][j] = max(global[i - 1][j - 1] + max(diff, 0), local[i - 1][j] + diff)
	   global[i][j] = max(local[i][j], global[i - 1][j])
	 */
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int ret = 0;
		if (k >= prices.length / 2) {// as many transaction as possible.
			for (int i = 1; i < prices.length; i++) {
				int diff = prices[i] - prices[i - 1];
				ret += diff > 0 ? diff : 0;
			}
			return ret;
		}
		int[] global = new int[k + 1];
		int[] local = new int[k + 1];
		for (int i = 0; i < prices.length - 1; ++i) {
			int diff = prices[i + 1] - prices[i];
			for (int j = k; j >= 1; j--) {
				local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
				global[j] = Math.max(global[j], local[j]);
			}
		}
		return global[k];
	}
	
	public int maxProfit2D(int k, int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int ret = 0;
		if (k >= prices.length / 2) {// as many transaction as possible.
			for (int i = 1; i < prices.length; i++) {
				int diff = prices[i] - prices[i - 1];
				ret += diff > 0 ? diff : 0;
			}
			return ret;
		}
		int[][] local = new int[prices.length][k + 1];
		int[][] global = new int[prices.length][k + 1];
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = 1; j <= k; j++) {
				local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
				global[i][j] = Math.max(global[i - 1][j], local[i][j]);
			}
		}
		return global[prices.length - 1][k];
	}

	public static void main(String[] args) {
		Stock3And4 s = new Stock3And4();
		System.out.println(s.maxProfit(2,new int[] { 1, 4, 2 }));
		System.out.println(s.maxProfit(3,new int[] { 1, 2, 3, 4, 5, 4, 5, 6, 7,8, 2, 3, 9 }));
		System.out.println(s.maxProfit(4,new int[] { 10, 2, 3, 4, 5, 4, 2, 5, 6,7, 8, 2, 3, 9 }));
	}
}
