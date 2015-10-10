package dp;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @author evicqia
 * 
 */
/**
 * Let us denote that:

f(k) = Largest product subarray, from index 0 up to k.

Similarly,

g(k) = Smallest product subarray, from index 0 up to k.

Then,

f(k) = max( f(k-1) * A[k], A[k], g(k-1) * A[k] )
g(k) = min( g(k-1) * A[k], A[k], f(k-1) * A[k] )

 * @author evicqia
 *
 */
public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
    	if (nums == null || nums.length == 0)
 			return 0;
 		int max = nums[0], min = nums[0], ret = nums[0];
 		for (int i = 1; i < nums.length; i++) {
 			int mx = max, mn = min;
 			max = Math.max(Math.max(nums[i], mx * nums[i]), mn * nums[i]);
 			min = Math.min(Math.min(nums[i], mx * nums[i]), mn * nums[i]);
 			ret = Math.max(max, ret);
 		}
 		return ret;
    }
    
	public static void main(String[] args) {
		MaximumProductSubArray m = new MaximumProductSubArray();
		System.out.println(m.maxProduct(new int[] { -2, 1, -3 }));
	}
}
