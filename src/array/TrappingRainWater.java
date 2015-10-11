package array;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped.
 * 
 * @author VictorQian
 * 
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		if (height == null || height.length < 3)
			return 0;
		int[] left = new int[height.length];
		left[0] = 0; // the highest of its left hand.
		for (int i = 1; i < height.length; i++) {
			left[i] = Math.max(left[i - 1], height[i - 1]);
		}

		int[] right = new int[height.length]; // the highest of its right hand.
		right[height.length - 1] = 0;
		for (int i = height.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i + 1]);
		}
		int ret = 0;
		for (int i = 0; i < height.length; i++) {
			int diff = Math.min(left[i], right[i]) - height[i];
			ret += diff < 0 ? 0 : diff;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		TrappingRainWater p = new TrappingRainWater();
		System.out.println(p.trap(new int[] { 0,1,0,2,1,0,1,3,2,1,2,1}));
	}
}
