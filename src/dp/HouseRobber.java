package dp;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author VictorQian
 * 
 */
public class HouseRobber {
	public int rob(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		int pre=nums[0];
		int cur=Math.max(nums[0], nums[1]);
		
		for(int i=2;i<nums.length;i++){
			int tmp = Math.max(nums[i]+pre, cur);
			pre=cur;
			cur=tmp;
		}
		
		return cur;
    }
	
	public int rob1(int[] nums) {
        // edge case
        if(nums == null || nums.length == 0) return 0;
        int[] opt = new int[nums.length+1];
        // initial condition
        opt[0] = 0;
        opt[1] = nums[0];

        // iteration
        for(int i = 2;i < opt.length;i++){
          opt[i] = Math.max(opt[i-2] + nums[i-1], opt[i-1]);
        }

        return opt[opt.length-1];
    }
	
	public int rob2(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		int include=nums[0];
		int exclude = 0;
		
		for(int i=1;i<nums.length;i++){
			int tmp = include;
			include=Math.max(exclude+nums[i], include);
			exclude = tmp;
		}
		
		return Math.max(include, exclude);
    }
	
	public static void main(String[] args){
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(new int[]{2,3,8,7,10,11,8,6,3,2}));
		System.out.println(hr.rob2(new int[]{2,3,8,7,10,11,8,6,3,2}));
	}
}
