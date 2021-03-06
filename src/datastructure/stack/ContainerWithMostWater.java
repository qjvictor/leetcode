package datastructure.stack;

public class ContainerWithMostWater {
	// solution:
	// scan from both sides, move the shorter end.
	public int maxArea(int[] height) {
		if (height == null || height.length < 2)
			return 0;
		int left = 0, right = height.length - 1;
		int max = 0;
		while (left < right) {
			int area = (right - left) * Math.min(height[right], height[left]);
			max = Math.max(area, max);
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		ContainerWithMostWater c = new ContainerWithMostWater();
		System.out.println(c.maxArea(new int[] { 5, 4, 2, 1, 7, 3, 8, 1, 4, 2 }));
	}
}
