package array;

/**
 * You are given an array of n+2 elements. All elements of the array are in
 * range 1 to n. And all elements occur once except two numbers which occur
 * twice. Find the two repeating numbers.
 * 
 * For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5
 * 
 * The above array has n + 2 = 7 elements with all elements occurring once
 * except 2 and 4 which occur twice. So the output should be 4 2.
 * 
 * @author VictorQian
 * 
 */
public class FindRepeated2Elements {
	public int[] findRepeated2(int[] nums, int n) {
		if (nums == null)
			return null;
		int[] ret = new int[nums.length-n];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[Math.abs(nums[i])] < 0) {
				ret[index++] = Math.abs(nums[i]);
			} else {
				nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		FindRepeated2Elements f = new FindRepeated2Elements();
		int[] ret = f.findRepeated2(new int[] { 4, 2, 4, 5, 2, 3, 1 }, 5);
		System.out.println(ret[0] + " - " + ret[1]);
		ret = f.findRepeated2(new int[] { 1, 2, 3, 1, 3, 6, 6 }, 7);
		System.out.println(ret[0] + " - " + ret[1]);
		
	}
	
}
