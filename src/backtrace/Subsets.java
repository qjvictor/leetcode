package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a set of distinct integers, nums, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 * @author VictorQian
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return ret;
		Arrays.sort(nums);
		helper(nums, ret, new ArrayList<Integer>(), 0);
		ret.add(new ArrayList<Integer>());
		return ret;
	}

	private void helper(int[] nums, List<List<Integer>> ret, List<Integer> list, int index) {
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			ret.add(new ArrayList<Integer>(list));
			helper(nums, ret, list, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public List<List<Integer>> subsets_sollution2(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return ret;
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<Integer>();
		ret.add(list);
		for(int i=0;i<nums.length;i++){
			int size = ret.size();
			for(int j=0;j<size;j++){
				list = ret.get(j);
				list.add(nums[i]);
				ret.add(new ArrayList<>(list));
				list.remove(list.size()-1);
			}
		}
		return ret;
	}
	
	
	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return ret;
		Arrays.sort(nums);
		helper2(nums, ret, new ArrayList<Integer>(), 0);
		ret.add(new ArrayList<Integer>());
		return ret;
	}

	private void helper2(int[] nums, List<List<Integer>> ret, List<Integer> list, int index) {
		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[i - 1])  //this is the key:   when duplicated happens, only the first one is counted.
				continue;
			list.add(nums[i]);
			ret.add(new ArrayList<Integer>(list));
			helper2(nums, ret, list, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args){
		Subsets s = new Subsets();
		System.out.println(s.subsets_sollution2(new int[]{1,2,3}));
	}
}
