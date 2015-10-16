package array;

import java.util.*;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author VictorQian
 * 
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		int max = 0;
		for (int i : nums) {
			if (!set.contains(i))   //if might be already removed in previous loop.
				continue;
			int count = 1;
			int left = i - 1;
			int right = i + 1;
			while (set.contains(left)) {
				count++;
				set.remove(left);  //that's the key, remove the connected number.
				left--;
			}
			while (set.contains(right)) {
				count++;
				set.remove(right);  //that's the key, remove the connected number.
				right++;
			}
			max = Math.max(max, count);
		}
		return max;
    }
	
	public static void main(String[] args) {
		LongestConsecutiveSequence l = new LongestConsecutiveSequence();
		System.out.println(l.longestConsecutive(new int[] { 100, -1, 0, 4, 5, 200, 1, 3, 2 }));
	}
}
