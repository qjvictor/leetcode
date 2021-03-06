package _important;
import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <=
 * c) The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author VictorQian
 * 
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3)
			return ret;
		Arrays.sort(nums); // don't forget.
		for (int i = 0; i < nums.length - 1; i++) {
			// only the first occurrence of duplicated number will be used.
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					ret.add(list);
					list = new ArrayList<Integer>();
					// ignore all duplicated number.
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				} else if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args){
		ThreeSum t = new ThreeSum();
		System.out.println(t.threeSum(new int[]{-4,-1,-1,-1, 0,1,2,3}));
		System.out.println(t.threeSum(new int[]{-2,0,0,2,2}));
	}
}
