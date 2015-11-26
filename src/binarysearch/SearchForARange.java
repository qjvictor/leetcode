package binarysearch;
/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
 * @author evicqia
 *
 */
public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		int[] ret = new int[] { -1, -1 };
		if (nums == null || nums.length == 0)
			return ret;
		int l = 0;
		int r = nums.length - 1;
		int leftMost = -1;
		int rightMost = -1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (nums[m] == target) {// even find it, still go left, to find the leftmost.
				leftMost = m;
				r = m - 1;
			} else if (nums[m] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		l = 0;
		r = nums.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (nums[m] == target) {// even find it, still go right, to find the rightmost.
				rightMost = m;
				l = m + 1;
			} else if (nums[m] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		ret[0] = leftMost;
		ret[1] = rightMost;
		return ret;
    }
	
	public static void main(String[] args){
		SearchForARange s = new SearchForARange();
		System.out.println(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
	}
}
