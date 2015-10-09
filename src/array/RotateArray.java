package array;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 * @author VictorQian
 * 
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length < k)
			return;
		k = k % nums.length;
		swap(nums, 0, nums.length - 1);
		swap(nums, 0, k - 1);
		swap(nums, k, nums.length - 1);
	}

	private void swap(int[] nums, int left, int right) {
		while (left < right) {
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		RotateArray r = new RotateArray();
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		r.rotate(nums, 3);
		for (int i : nums) {
			System.out.print(i);
		}
	}
}
