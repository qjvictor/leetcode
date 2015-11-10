package dp;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example:
 * 
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1 
 * sumRange(2, 5) -> -1 
 * sumRange(0, 5) -> -3
 * 
 * Note:
 * 
 * You may assume that the array does not change. 
 * There are many calls to sumRange function.
 * 
 * @author VictorQian
 * 
// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
 */
public class NumArray {
	int[] diff;
	public NumArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		diff = new int[nums.length];
		diff[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			diff[i] = diff[i - 1] + nums[i];
		}
    }

    public int sumRange(int i, int j) {
		if (diff == null || diff.length == 0 || i < 0 || j >= diff.length || i>j)
			return -1;
		if (i == 0)
			return diff[j];
		else
			return diff[j] - diff[i-1];
    }
    
    public static void main(String[] args){
    	NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    	System.out.println(numArray.sumRange(0,2));
    	System.out.println(numArray.sumRange(2,5));
    	System.out.println(numArray.sumRange(0,5));
    	System.out.println(numArray.sumRange(1,3));
    	System.out.println(numArray.sumRange(2,3));
    	System.out.println(numArray.sumRange(2,4));
    }
}
