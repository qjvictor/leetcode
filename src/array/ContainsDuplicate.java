package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * 
 * @author VictorQian
 * 
 */
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length < 2)
			return false;
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (set.contains(i)) {
				return true;
			} else {
				set.add(i);
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		ContainsDuplicate c = new ContainsDuplicate();
		System.out.println(c.containsDuplicate(new int[]{1,2,3,4,5,4}));
		System.out.println(c.containsDuplicate(new int[]{1,2,3,4,5,6}));
	}
}
