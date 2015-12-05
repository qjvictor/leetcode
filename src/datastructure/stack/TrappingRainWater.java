package datastructure.stack;

import java.util.Stack;

/**
 *  Given n non-negative integers representing an elevation map where the 
 *  width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
 * @author evicqia
 *
 */
public class TrappingRainWater {
	public int trap_best(int[] height) {
		int i = 0, j = height.length - 1;
		int lMax = 0;
		int rMax = 0;
		int ret = 0;
		while (i <= j) {
			lMax = Math.max(lMax, height[i]); // max within [0..i]
			rMax = Math.max(rMax, height[j]); // max within [j..n-1]
			if (lMax < rMax) {
				ret += lMax - height[i++];
			} else {
				ret += rMax - height[j--];
			}
		}
		return ret;
	}
	//2 pointers.
	public int trap(int[] height) {
		if (height == null || height.length < 3)
			return 0;
		int[] left = new int[height.length];
		for (int i = 1; i < height.length; i++) {
			left[i] = Math.max(left[i - 1], height[i - 1]);
		}

		int[] right = new int[height.length];
		int ret = 0;
		for (int i = height.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i + 1]);
			int diff = Math.min(left[i], right[i]) - height[i];  //diff could be negative: when current height is the highest
			ret += diff < 0 ? 0 : diff;
		}
		return ret;
    }
	
	//time limit exceed.
	public int _trap(int[] height) {
		if (height == null || height.length < 3)
			return 0;
		int len = height.length;
		int water = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			if (stack.isEmpty() || height[stack.peek()] >= height[i]) { //if current is lower, push its index into stack.
				stack.push(i);
			} else { // if current is higher,
				int tmp = stack.pop();
				if (!stack.isEmpty()) {
					water += (Math.min(height[stack.peek()], height[i]) - height[tmp]) * (i - stack.peek() - 1);
				}
				i--; //go back one step, to repeat.
			}
		}
		return water;
	}
	
	public static void main(String[] args){
		TrappingRainWater t = new TrappingRainWater();
		System.out.println(t.trap_best(new int[]{7,1,4,5,4}));
		System.out.println(t.trap(new int[]{7,1,4,5,4}));
	}
}
