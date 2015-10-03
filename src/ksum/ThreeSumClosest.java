package ksum;
import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author VictorQian
 * 
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3)
			return Integer.MAX_VALUE;
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int ret = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == target) { // no need to continue.
					return sum;
				} else {
					int diff = Math.abs(sum - target);
					if (diff < min) {
						min = diff;
						ret = sum;
					}
					if (sum > target) {
						right--;
						if (left < right && nums[right] == nums[right + 1]) // skip
																			// duplicated.
							right--;
					} else {
						left++;
						if (left < right && nums[left] == nums[left - 1]) // skip
																			// duplicated.
							left++;
					}
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args){
		ThreeSumClosest t = new ThreeSumClosest();
		System.out.println(t.threeSumClosest(new int[]{0,2,1,-3}, 2));
		System.out.println(t.threeSumClosest(new int[]{-2,0,0,2,2}, 2));
	}
}
