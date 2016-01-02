package sort;

import java.util.Arrays;

public class WiggleSort {
	/**
	 *  Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

	For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4]. 
	 * @author VictorQian
	 *
	 */
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		//rule 1): odd position,  greater or equals than previous one.
		//rule 2): even position, less or equal than previous one.
		for (int i = 1; i < nums.length; i++) {
			if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) { //if breaking the rules, do the swap.
				int tmp = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = tmp;
			}
		}

		for (int i : nums) {
			System.out.print(i);
		}
    }
	/**
	 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

	 Example:
	 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
	 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

	 Note:
	 You may assume all input has valid answer.

	 Follow Up:
	 Can you do it in O(n) time and/or in-place with O(1) extra space? 
	*/
	
	public void wiggleSort2(int[] nums) {
		// nlogn
		if (nums == null || nums.length < 2)
			return;
		Arrays.sort(nums); // nlogn
		int[] tmp = new int[nums.length];
		System.arraycopy(nums, 0, tmp, 0, tmp.length);
		int mid = (tmp.length - 1) / 2;
		for (int i = 0; i <= mid; i++) {
			nums[2 * i] = tmp[i];
			if ((2 * i + 1) < tmp.length)
				nums[2 * i + 1] = tmp[mid + 1 + i];
		}
		for (int i : nums) {
			System.out.print(i);
		}
    }
	
	public static void main(String[] args){
		WiggleSort w = new WiggleSort();
		w.wiggleSort(new int[]{3,5,2,1,6,4});
		System.out.println();
		w.wiggleSort2(new int[]{4,5,5,6});
		
	}
}
