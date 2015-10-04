package sort;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * @author VictorQian
 * 
 */
public class SortColors {
	public void _sortColors(int[] nums) {//one pass.
		if (nums == null || nums.length == 0)
			return;
		int p0 = 0, p1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[i] = 2;
				nums[p1++] = 1;
				nums[p0++] = 0;
			} else if (nums[i] == 1) {
				nums[i] = 2;
				nums[p1++] = 1;
			}
		}
	}
	
	public void sortColors(int[] nums) {//standard count sort
		int[] buckets = new int[3];
		for (int i : nums) {
			buckets[i]++;
		}
		int idx = 0;
		while (buckets[0]-- > 0)
			nums[idx++] = 0;
		while (buckets[1]-- > 0)
			nums[idx++] = 1;
		while (buckets[2]-- > 0)
			nums[idx++] = 2;
    }

	public static void main(String[] args) {
		SortColors s = new SortColors();
		int[] colors = new int[] { 2,1,0,0,2,2,2,1,1,0,2,1,0,1,1,2 };
		s.sortColors(colors);
		for (int i : colors) {
			System.out.print(i);
		}
	}
}
