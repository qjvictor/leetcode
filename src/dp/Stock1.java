package dp;


/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author evicqia
 * 
 */
public class Stock1 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int local = 0;
		int global = 0;
		for (int i = 1; i < prices.length; i++) {
			local = local + prices[i] - prices[i - 1];
			if (local < 0)
				local = 0;
			global = Math.max(global, local);
		}
		return global;
    }
	
	public static void main(String[] args){
		Stock1 s = new Stock1();
		System.out.println(s.maxProfit(new int[] { 1,4,2 })); //3
		System.out.println(s.maxProfit(new int[] { 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 2, 3, 9 }));//8
		System.out.println(s.maxProfit(new int[] { 10, 2, 3, 4, 5, 4, 2, 5, 6, 7, 8, 2, 3, 9 }));//7
	}
}
