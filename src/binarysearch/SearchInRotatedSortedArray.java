package binarysearch;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 * @author VictorQian
 *
 */
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (nums[m] == target) {
				return m;
			}
			if (nums[m] < nums[r]) {// right is sorted
				if(nums[m]<target && target<=nums[r]){ // target is in right side
					l=m+1;
				}else{
					r=m-1;
				}
			} else {// left is sorted
				if(nums[l]<=target && target<nums[m]){ // target is in left side
					r=m-1;
				}else{
					l=m+1;
				}
			} 
		}
		return -1;
    }
	
	public int _search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (nums[m] == target) {
				return m;
			}
			if (nums[l] <= nums[m]) {// left is sorted 
				if (nums[l] <= target && target < nums[m]) { // target is in left side
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else {// right is sorted
				if (nums[m] < target && target <= nums[r]) { // target is in right side
					l = m + 1;
				} else {
					r = m - 1;
				}
			} 
		}
		return -1;
    }
	
	public static void main(String[] args){
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		System.out.println(s.search(new int[]{3,1}, 1));
		System.out.println(s._search(new int[]{3,1}, 1));
		System.out.println(s.search(new int[]{4,5,6,7,8,9,0,1,2,3}, 17));
		System.out.println(s.search(new int[]{4,5,6,7,8,9,0,1,2,3}, 1));
		System.out.println(s.search(new int[]{4,5,6,7,8,9,0,1,2,3}, 4));
		System.out.println(s.search(new int[]{4,5,6,7,8,9,0,1,2,3}, 3));
		System.out.println(s.search(new int[]{4,5,6,7,8,9,0,1,2,3}, 8));
	}
}
