package binarysearch;

/**
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author VictorQian
 * 
 */
public class TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
		int[] ret = new int[2];
		int l = 0, r = numbers.length - 1;
		while (l < r) {
			int sum = numbers[l] + numbers[r];
			if (sum == target) {
				ret[0] = l + 1;
				ret[1] = r + 1;
				return ret;
			} else if (sum < target) {
				l++;
			} else {
				r--;
			}
		}
		return ret;
    }
	
	public static void main(String[] args){
		TwoSumII t = new TwoSumII();
		int[] ret = t.twoSum(new int[]{2, 7, 11, 15}, 14);
		System.out.println(ret[0]);
		System.out.println(ret[1]);
	}
}
