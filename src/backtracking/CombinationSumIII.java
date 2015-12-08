package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 

Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.

Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]


Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

 * @author VictorQian
 *
 */
public class CombinationSumIII {

	public static void main(String[] args){
		CombinationSumIII c = new CombinationSumIII();
		System.out.println(c.combinationSum3(3, 9));
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (n <= 0 || n > 45 || k <= 0 || k > 9)
			return ret;
		helper(ret, new ArrayList<Integer>(), n, k, 1, 0);
		return ret;
	}

	private void helper(List<List<Integer>> ret, ArrayList<Integer> list, int n, int k, int index, int sum) {
		if (list.size() > k || sum > n) {
			return;
		}
		if (list.size() == k && sum == n) {
			ret.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = index; i <= 9; i++) {
			list.add(i);
			helper(ret, list, n, k, i + 1, sum + i);
			list.remove(list.size() - 1);
		}
	}
}
