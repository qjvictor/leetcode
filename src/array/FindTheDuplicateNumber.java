package array;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note:
 * 
 * You must not modify the array (assume the array is read only). You must use
 * only constant, O(1) extra space. Your runtime complexity should be less than
 * O(n2). There is only one duplicate number in the array, but it could be
 * repeated more than once.
 * 
 * @author VictorQian
 * 
 */
public class FindTheDuplicateNumber {
	public int _findDuplicate(int[] nums) {
		int slow = 0, fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
    }
	//binary search - O(n).
	public int findDuplicate(int[] nums) {
	    int low = 1, high = nums.length - 1;
	    while (low <= high) {
	        int mid = (int) (low + (high - low) * 0.5);
	        int cnt = 0;
	        for (int a : nums) {
	            if (a <= mid) cnt++;
	        }
	        if (cnt <= mid) 
	        	low = mid + 1;
	        else 
	        	high = mid - 1;
	    }
	    return low;
	}
	
	public static void main(String[] args){
		FindTheDuplicateNumber f = new FindTheDuplicateNumber();
		System.out.println(f.findDuplicate(new int[]{1,2,6,3,4,5,6,7,8}));
	}
}
