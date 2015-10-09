package array;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author VictorQian
 * 
 */
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0) return 0;
        int pos=0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]!=val){
        		nums[pos++]=nums[i];
        	}
        }
        return pos;
    }
	
	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int ret = r.removeElement(nums, 3);
		System.out.println(ret);
		for (int i : nums) {
			System.out.print(i);
		}
	}
}
