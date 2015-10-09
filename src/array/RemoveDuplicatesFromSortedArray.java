package array;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 * 
 * @author VictorQian
 * 
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;
		int pos = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[pos] = nums[i];
				pos++;
			}
		}
		return pos;
	}

	/**
	 * What if duplicates are allowed at most twice?
	 * 
	 * For example, Given sorted array nums = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, with the first five elements of
	 * nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the
	 * new length.
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length <3)
			return nums.length;
		int pos = 2;
		int pre=nums[1];
		int prepre=nums[0];
		for (int i = 2; i < nums.length; i++) {
			if(nums[i]!=pre || (nums[i]==pre && nums[i]!=prepre)){
				prepre=pre;
				pre=nums[i];
				nums[pos++]=nums[i];
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
		int[] nums = new int[] { 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 6, 7, 7 };
		int ret1 = r.removeDuplicates(nums);
		System.out.println(ret1);
		for (int i : nums) {
			System.out.print(i);
		}
		System.out.println();
		nums = new int[] { 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 6, 7, 7 };
		int ret2 = r.removeDuplicates2(nums);
		System.out.println(ret2);
		for (int i : nums) {
			System.out.print(i);
		}
	}
}
