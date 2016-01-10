package dp;
/**
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. 
 * @author VictorQian
 *
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length <= 1)
			return true;
		int distance = 0;
		for (int i = 0; i < nums.length && i <= distance; i++) {
			distance = Math.max(nums[i] + i, distance);
		}
		return distance >= nums.length - 1;
    }
	
	public boolean _canJump(int[] nums) {
		int furthest = 0;
		for (int i = 0; i < nums.length; i++) {
			if (furthest < i)
				return false;
			furthest = Math.max(furthest, i + nums[i]);
		}
        return true;
    }
	
	public static void main(String[] args){
		JumpGame jg = new JumpGame();
		System.out.println(jg.canJump(new int[]{2,3,1,1,4}));
		System.out.println(jg._canJump(new int[]{2,3,1,1,4}));
		System.out.println(jg.canJump(new int[]{3,2,1,0,4}));
		System.out.println(jg._canJump(new int[]{3,2,1,0,4}));
	}
}
