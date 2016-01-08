package dp;

import java.util.Arrays;

/**
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
 * @author VictorQian
 *
 */
public class JumpGameII {
	//O(n^2) - DP.
	//Time Limit Exceeded in OJ
	public int _jump(int[] nums) {
		if (nums == null || nums.length <= 1)
			return 0;
		int[] steps = new int[nums.length];
		Arrays.fill(steps, Integer.MAX_VALUE);
		steps[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] + j >= i) {
					steps[i] = Math.min(steps[i], steps[j] + 1);
				}
			}
		}
		return steps[nums.length - 1];
    }
	
	//O(n) - Greedy.
	public int jump(int[] nums) {
		if (nums == null || nums.length <= 1)
			return 0;
		int jumps = 0, curFurthest = 0, nextFurthest = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > curFurthest) {
				jumps++;
				curFurthest = nextFurthest;
			}
			nextFurthest = Math.max(nextFurthest, i + nums[i]);
		}
		return jumps;
	}	
	
	public static void main(String[] args){
		JumpGameII jg = new JumpGameII();
		System.out.println(jg.jump(new int[]{2,3,1,1,4}));
		System.out.println(jg.jump(new int[]{1,3,5,3,2,2,6,1,6,8,9}));
	}
}
