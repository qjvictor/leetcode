package dp;
/**
 * Given a set of non negative numbers and a total, find if there exists a subset in this set whose sum is same as total.
 * @author VictorQian
 *total: 11
 *[2,3,7,8,10]
 *
 * * Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
 * to given total. Another variation is given an array is it possible to split it up into 2 equal
 * sum partitions. Partition need not be equal sized. Just equal sum.
 *
 * Time complexity - O(input.size * total_sum)
 * Space complexity - O(input.size*total_sum)
 */
public class SubsetSum {
	public boolean subsetSum(int[] nums, int total){
		if (nums == null || nums.length == 0)
			return false;
		boolean[][] exists = new boolean[nums.length + 1][total + 1];
		for (int i = 0; i <= nums.length; i++) {
			exists[i][0] = true;
		}
		exists[0][nums[0]] = true;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (nums[i - 1] > j) {
					exists[i][j] = exists[i - 1][j];
				} else {
					exists[i][j] = exists[i - 1][j] || exists[i - 1][j - nums[i - 1] + 1];
				}
			}
		}
		return exists[nums.length - 1][total];
		
	}
	
	public static void main(String[] args){
		SubsetSum sss = new SubsetSum(); 
		System.out.println(sss.subsetSum(new int[]{2,3,7,8, 10}, 11));
		System.out.println(sss.subsetSum(new int[]{2,3,7,8, 10}, 16));
		System.out.println(sss.subsetSum(new int[]{2,3,7,8, 10}, 27));
	}
}
