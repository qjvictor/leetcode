package ksum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note:
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <
 * b < c < d) The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 * 
 * @author VictorQian
 * 
 */
public class FourSum {
	public static void main(String[] args){
		FourSum f = new FourSum();
		System.out.println(f.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
	}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		return kSum(nums, target, 4);
	}

	private List<List<Integer>> kSum(int[] nums, int target, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < k)
			return res;
		Arrays.sort(nums);
		return help(nums, target, k, 0);
	}

	private List<List<Integer>> help(int[] nums, int target, int k, int index) {
		if (k == 2) {
			return twoSum(nums, index, target);
		} else {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			for (int i = index; i < nums.length - 1; i++) {
				if (i != index && nums[i] == nums[i - 1])
					continue;
				List<List<Integer>> tmp = help(nums, target - nums[i], k - 1, i + 1);
				for (List<Integer> curr : tmp) {
					curr.add(0, nums[i]);
					res.add(curr);
				}
			}
			return res;
		}
	}

	private List<List<Integer>> twoSum(int[] nums, int start, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int first = start, last = nums.length - 1;
		while (first < last) {
			if (nums[first] + nums[last] == target) {
				List<Integer> curr = new ArrayList<Integer>();
				curr.add(nums[first++]);
				curr.add(nums[last--]);
				res.add(curr);
				while (first < last && nums[first] == nums[first - 1]) {
					first++;
				}
				while (first < last && nums[last] == nums[last + 1]) {
					last--;
				}
			} else if (nums[first] + nums[last] < target) {
				first++;
				while (first < last && nums[first] == nums[first - 1]) {
					first++;
				}
			} else {
				last--;
				while (first < last && nums[last] == nums[last + 1]) {
					last--;
				}
			}
		}

		return res;
	}
	
	
	
	public List<List<Integer>> _fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int j = 0; j < nums.length; j++) {
			for (int i = j + 1; i < nums.length; i++) {
				int start = i + 1, end = nums.length - 1;
				while (start < end) {// Two pointers
					int sum = nums[j] + nums[i] + nums[start] + nums[end];

					if (sum == target) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(nums[j]);
						list.add(nums[i]);
						list.add(nums[start]);
						list.add(nums[end]);
						result.add(list);

						start++;
						end--;
						while ((start < end) && nums[start] == nums[start - 1])
							start++; // remove duplicates
						while ((start < end) && nums[end] == nums[end + 1])
							end--;
					} else if (sum < target) {
						start++;
						while ((start < end) && nums[start] == nums[start - 1])
							start++; // remove duplicates
					} else {
						end--;
						while ((start < end) && nums[end] == nums[end + 1])
							end--; // remove duplicates
					}
				}

				while (i + 1 < nums.length && nums[i + 1] == nums[i]) // remove duplicates
					i++;
			}

			while (j + 1 < nums.length && nums[j + 1] == nums[j]) // remove duplicates
				j++;
		}

		return result;
	}
}
