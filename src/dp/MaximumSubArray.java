package dp;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [-2, 1, -3, 4, -1, 2, 1, -5, 4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * click to show more practice. More practice:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 * @author evicqia
 * 
 */
public class MaximumSubArray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int local = nums[0];
		int global = local;
		for (int i = 1; i < nums.length; i++) {
			local = Math.max(local + nums[i], nums[i]);
			global = Math.max(global, local);
		}
		return global;
	}

	public int _maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int[] dp = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			dp[i] = Math.max(nums[i - 1], nums[i - 1] + dp[i - 1]);
			// dp[] store the value of max subarray which much include the ith element;
			max = Math.max(max, dp[i]);
			// max is the real max subarray value;
		}
		return max;
	}

/**
	1) Divide the given array in two halves
	2) Return the maximum of following three
	….a) Maximum subarray sum in left half (Make a recursive call)
	….b) Maximum subarray sum in right half (Make a recursive call)
	….c) Maximum subarray sum such that the subarray crosses the midpoint
*/
	public int maxSubArrayDivideAndConquer(int[] nums){
		if(nums==null || nums.length==0) return 0;
		return divideAndConquer(nums, 0, nums.length-1);
	}
	
	private int divideAndConquer(int[] nums, int left, int right){
		if(left==right){
			return nums[left];
		}
		int mid = (left+right)/2;
		return Math.max(Math.max(divideAndConquer(nums, left, mid), divideAndConquer(nums, mid+1, right)), maxAcrossMid(nums, left, mid, right));
	}
	
	
	private int maxAcrossMid(int[] nums, int left, int mid, int right) {
		int leftSum=Integer.MIN_VALUE;
		int rightSum=Integer.MIN_VALUE;
		int max=0;
		for(int i=mid;i>=left; i--){
			max+=nums[i]; 
			leftSum=Math.max(max, leftSum);
		}
		max=0;
		for(int i=mid+1;i<=right; i++){
			max+=nums[i]; 
			rightSum=Math.max(max, rightSum);
		}
		return leftSum+rightSum;
	}

	public static void main(String[] args) {
		MaximumSubArray m = new MaximumSubArray();
		System.out.println(m.maxSubArrayDivideAndConquer(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}
}
