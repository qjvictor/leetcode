package binarysearch;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 * @author evicqia
 *
 */
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return Integer.MIN_VALUE;
		int left = 0;
		int right = nums.length - 1;
		int ret = Integer.MAX_VALUE;
		while (left <= right) {
			if (left == right)
				return Math.min(nums[left], ret);
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[right]) {// mid->right is sorted
				ret = Math.min(nums[mid], ret);
				right = mid - 1;
			} else { // left->mid is sorted
				ret = Math.min(nums[left], ret);
				left = mid + 1;
			}
		}
		return ret;
    }
	
	public static void main(String[] args){
		FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
		System.out.println(f.findMin(new int[]{3,1,2}));
		System.out.println(f.findMin(new int[]{2,1}));
		System.out.println(f.findMin(new int[]{4,5,6,7,0,1,2}));
		System.out.println(f.findMin(new int[]{8,9,10, 0,1,2,3, 4,5,6,7}));
	}
}
