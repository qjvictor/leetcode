package backtracking;

import java.util.*;

/**
 *  Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]
 * @author VictorQian
 *
 */
public class CombinationSum {
	
	public static void main(String[] args){
		CombinationSum c = new CombinationSum();
		System.out.println(c.combinationSum(new int[]{2,3,6,7}, 7));
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0)
			return ret;
		Arrays.sort(candidates);
		helper(ret, new ArrayList<Integer>(), candidates, target, 0);
		return ret;
	}

	private void helper(List<List<Integer>> ret, ArrayList<Integer> list, int[] candidates, int target, int index) {
		if (target == 0) {
			ret.add(new ArrayList<Integer>(list));
			return;
		} else if (target < 0) {
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			helper(ret, list, candidates, target - candidates[i], i);
			list.remove(list.size() - 1);
		}
	}
}
