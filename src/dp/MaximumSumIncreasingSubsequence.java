package dp;

public class MaximumSumIncreasingSubsequence {
	/**
	 * Given an array, find maximum sum increasing subsequence in this array.
	 */
	public int maximumSum(int[] nums){
		if (nums == null || nums.length == 0)
			return 0;
		int[] max = new int[nums.length];
		int ret = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max[i] = nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					max[i] = Math.max(max[i], max[j] + nums[i]);
				}
			}
			ret = Math.max(max[i], ret);
		}
		return ret;
	}
	
	public static void main(String[] args){
		MaximumSumIncreasingSubsequence m = new MaximumSumIncreasingSubsequence();
		System.out.println(m.maximumSum(new int[]{4,6,1,3,8,4,6}));
		
		int arr[] = {1,101,10,2,3,100,4};
        int r = m.maximumSum(arr);
        System.out.print(r);
	}
	
}
