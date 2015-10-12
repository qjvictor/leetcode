package array;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than n/2 times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * @author VictorQian
 * 
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int count = 1;
		int ret = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != ret) {
				count--;
				if (count == 0) {
					ret = nums[i];
					count = 1;
				}
			} else {
				count++;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		MajorityElement m = new MajorityElement();
		System.out.println(m.majorityElement(new int[] { 2, 2, 3, 4, 5, 3, 2, 7, 3, 3, 1, 3, 3, 3, 2 }));
	}
}
