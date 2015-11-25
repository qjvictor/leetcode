package binarysearch;
/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0 
 * @author VictorQian
 *
 */
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (nums[m] == target) {
				return m;
			} else if (nums[m] < target) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return l;
    }
	
	public static void main(String[] args){
		SearchInsertPosition s = new SearchInsertPosition();
		System.out.println(s.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
		System.out.println(s.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
		System.out.println(s.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
		System.out.println(s.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
		System.out.println(s.searchInsert(new int[] { 1, 2, 3 }, -5));
	}
}
