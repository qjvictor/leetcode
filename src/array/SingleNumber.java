package array;
/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * @author VictorQian
 *
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int ret=0;
        for(int i:nums){
        	ret^=i;
        }
        return ret;
    }
	
	public static void main(String[] args){
		SingleNumber s = new SingleNumber();
		System.out.println(s.singleNumber(new int[]{22,11,22,11,33,7,8,8,7}));
	}
}
