package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than n/3
 * times. The algorithm should run in linear time and in O(1) space.
 * 
 * @author VictorQian
 * 
 */
public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> ret=new ArrayList<>();
		if(nums==null || nums.length==0) return ret;
		if(nums.length==1) {
			ret.add(nums[0]);
			return ret;
		}
		int ret1=Integer.MAX_VALUE;
		int ret2=Integer.MAX_VALUE;
		int c1=0;
		int c2=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==ret1){
				c1++;
			}else if(nums[i]==ret2){
				c2++;
			}else if(c1==0){
				ret1=nums[i];
				c1=1;
			}else if(c2==0){
				ret2=nums[i];
				c2=1;
			}else{
				c1--;
				c2--;
			}
		}
		
		c1=c2=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==ret1) c1++;
			if(nums[i]==ret2) c2++;
		}
		
		if(c1>nums.length/3){
			ret.add(ret1);
		}
		if(c2>nums.length/3){
			ret.add(ret2);
		}
		return ret;
	}
	
	public static void main(String[] args){
		MajorityElementII m = new MajorityElementII();
		System.out.println(m.majorityElement(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1,2}));
	}
}
