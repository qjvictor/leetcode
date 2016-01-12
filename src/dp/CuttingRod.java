package dp;
/**
 * Given a rod of length and prices at which different length of this rod can sell, how do you cut this rod to maximize profit
 * @author VictorQian
 *
 */
public class CuttingRod {
	public int getMaxProfit(int length, int[] prices){
		if (length <= 0 || prices == null || prices.length == 0)
			return 0;
		int[][] max = new int[prices.length + 1][length + 1];
		int ret = 0;
		for (int i = 1; i <= prices.length; i++) {
			for (int j = 1; j <= length; j++) {
				if (i <= j) {
					max[i][j] = Math.max(max[i - 1][j], prices[i - 1] + max[i][j - i]);
				} else {
					max[i][j] = max[i - 1][j];
				}
				ret = Math.max(ret, max[i][j]);
			}
		}
		return ret;
	}
	
	public static void main(String[] args){
		CuttingRod c = new CuttingRod();
		System.out.println(c.getMaxProfit(5, new int[]{2,5,7,8}));
		System.out.println(c.getMaxProfit(8, new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
		System.out.println(c.getMaxProfit(8, new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
	}
}
