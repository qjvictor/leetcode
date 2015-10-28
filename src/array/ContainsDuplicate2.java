package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 * 
 * @author VictorQian
 * 
 */
public class ContainsDuplicate2 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length < 2 || k <= 0) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
				return true;
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ContainsDuplicate2 c = new ContainsDuplicate2();
		System.out.println(c.containsNearbyDuplicate(new int[] { 2,2 }, 3));
		System.out.println(c.containsNearbyDuplicate(new int[] { 1, 2, 3, 4, 5, 6, 3 }, 3));
	}
}
