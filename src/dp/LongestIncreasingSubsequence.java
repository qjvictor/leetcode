package dp;

/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author VictorQian
 * 
 */
public class LongestIncreasingSubsequence {
	//O(n^2) time, O(n) space.
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int ret = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ret = Math.max(ret, dp[i]);
		}
		return ret;
    }
	
	
	public int BinarySearch(int[] a, int l, int r, int key) {
        while (l <= r) {
            int m = l+(r-l)/2;
            if (a[m] >= key)
                r = m-1;
            else l = m+1;
        }
        return l;
    }
    public int lengthOfLIS_BinarySearch(int[] nums) {
    	if (nums == null || nums.length == 0)
			return 0;
        int len = 0, n = nums.length;
        int[] a = new int[n];
        for (int i: nums) {
            int j = BinarySearch(a, 0, len-1, i);
            a[j] = i;
            if (j == len) 
            	len++;
        }
        return len;
    }
	
	public static void main(String[] args){
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		System.out.println(l.lengthOfLIS_BinarySearch(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
	}
}
