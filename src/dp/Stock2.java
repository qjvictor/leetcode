package dp;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 * @author evicqia
 * 
 */
public class Stock2 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int ret = 0;
		for (int i = 1; i < prices.length; i++) {
			ret += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
		}
		return ret;
	}

	public static void main(String[] args) {
		Stock2 s = new Stock2();
		System.out.println(s.maxProfit(new int[] { 1, 4, 2 })); // 3
		System.out.println(s.maxProfit(new int[] { 1, 2, 3, 4, 5, 4, 5, 6, 7,8, 2, 3, 9 }));// 15
		System.out.println(s.maxProfit(new int[] { 10, 2, 3, 4, 5, 4, 2, 5, 6,7, 8, 2, 3, 9 }));// 16
	}
}
