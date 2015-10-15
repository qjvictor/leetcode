package backtracking;

import java.util.*;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author VictorQian
 * 
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		helper(nums, ret, new ArrayList<Integer>(), new boolean[nums.length]);
		return ret;
	}

	private void helper(int[] nums, List<List<Integer>> ret, List<Integer> list, boolean[] used) {
		if (list.size() == nums.length) {
			ret.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1])
				continue;
			if (!used[i]) {
				list.add(nums[i]);
				used[i] = true;
				helper(nums, ret, list, used);
				list.remove(list.size() - 1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		System.out.println(p.permute(new int[] { 1, 2, 3 }));
		System.out.println(p.permute(new int[] { 1, 2, 3, 3 }));
	}

}
