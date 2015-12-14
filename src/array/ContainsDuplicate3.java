package array;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 * 
 * @author VictorQian
 * 
 */
public class ContainsDuplicate3 {
	//O^2, TLE
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length < 2)
			return false;

		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			while (j < nums.length && j <= i + k) {
				if (Math.abs(nums[j] - nums[i]) <= t) {
					return true;
				}
				j++;
			}
		}
		return false;
    }
	
	
	
	
	public static void main(String[] args){
		ContainsDuplicate3 c = new ContainsDuplicate3();
		System.out.println(c.containsNearbyAlmostDuplicate(new int[] { 10, 20, 30, 40, 50, 60, 70,80 }, 3, 8));
		
		
		TreeSet<Integer> tree = new TreeSet<>();
		tree.add(10);
		tree.add(15);
		tree.add(5);
		System.out.println(tree);
	}
}
