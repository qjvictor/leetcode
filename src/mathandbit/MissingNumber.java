package mathandbit;
/**
 *  Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

 * @author VictorQian
 *
 */
public class MissingNumber {
	public int _missingNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int n = nums.length;
		int total = (1 + n) * n / 2;
		for (int num : nums) {
			total -= num;
		}
		return total;
    }
	
	public int missingNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int n = 0;
		for (int i=0;i<nums.length;i++) {
			n^=nums[i]^i;
		}
		return n^nums.length;
    }
	

	public static void main(String[] args){
		MissingNumber s = new MissingNumber();
		System.out.println(s.missingNumber(new int[]{0,1,2,3,5,6,7}));
	}
	
}
