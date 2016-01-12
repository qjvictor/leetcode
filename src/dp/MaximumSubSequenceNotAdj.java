package dp;
/**
 * Given an array of positive number, find maximum sum subsequence such that elements in this subsequence are not adjacent to each other.
 * @author VictorQian
 *
 */
public class MaximumSubSequenceNotAdj {
	public int maxSubSeqNotAdj(int[] nums){
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int include = nums[0]; // include current;
		int exclude = 0; // not include current;

		for (int i = 1; i < nums.length; i++) {
			int tmp = include;
			include = Math.max(exclude + nums[i], include);
			exclude = tmp;
		}

		return Math.max(include, exclude);
	}
	
	public static void main(String[] args){
		MaximumSubSequenceNotAdj hr = new MaximumSubSequenceNotAdj();
		System.out.println(hr.maxSubSeqNotAdj(new int[]{2,3,8,7,10,11,8,6,3,2}));
	}
}
