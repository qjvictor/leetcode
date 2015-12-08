package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
 * @author VictorQian
 *
 */
public class CombinationSumII {
	public static void main(String[] args){
		CombinationSumII c = new CombinationSumII();
		System.out.println(c.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
			if(i!=index && candidates[i]==candidates[i-1]) continue;
			list.add(candidates[i]);
			helper(ret, list, candidates, target - candidates[i], i + 1);
			list.remove(list.size() - 1);
		}
	}
}
