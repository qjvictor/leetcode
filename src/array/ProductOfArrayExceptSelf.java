package array;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up: Could you solve it with constant space complexity? (Note: The
 * output array does not count as extra space for the purpose of space
 * complexity analysis.)
 * 
 * @author VictorQian
 * 
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		int[] ret = new int[nums.length];
		int pre=1; //pre = product of previous nums.
		for (int i = 0; i < nums.length; i++) {
			ret[i] = pre; 
			pre=pre*nums[i];
		}

		int post=1;//pre = product of afterward nums.
		for (int i = nums.length - 1; i >= 0; i--) {
			ret[i]=ret[i]*post;
			post=post*nums[i];
		}
		return ret;
	}
	

	public static void main(String[] args) {
		ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
		int[] ret = p.productExceptSelf(new int[] { 1, 2, 3, 4 });
		for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i]);
		}
	}
}
