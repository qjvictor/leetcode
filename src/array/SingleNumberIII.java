package array;

import java.util.HashSet;

/**
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note:
 * 
 * The order of the result is not important. So in the above example, [5, 3] is
 * also correct. Your algorithm should run in linear runtime complexity. Could
 * you implement it using only constant space complexity?
 * 
 * @author VictorQian
 * 
 */
public class SingleNumberIII {
	public int[] _singleNumber(int[] nums) {
		if (nums == null)
			return null;
		HashSet<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (set.contains(i))
				set.remove(i);
			else
				set.add(i);
		}
		int[] ret = new int[2];
		int index = 0;
		for (int i : set.toArray(new Integer[0])) {
			ret[index++] = i;
		}
		return ret;
	}
	
	public int[] singleNumber(int[] nums) {
		if (nums == null)
			return null;
		int ret=0;
		for(int i: nums){
			ret^=i;
		}
		return null;
		
		
	}	

	public static void main(String[] args) {
		SingleNumberIII s = new SingleNumberIII();
		int[] ret = s._singleNumber(new int[] { 1, 1, 3, 3, 6, 7, 7, 8 });
		System.out.println(ret[0]+"-"+ret[1]);
		
		System.out.println(Integer.toBinaryString(5));
		System.out.println(Integer.toBinaryString(-5));
		System.out.println(5&-5);
	}
}
