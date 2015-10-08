package dp;

/**
 * There is a fence with n posts, each post can be painted with one of the k
 * colors.
 * 
 * You have to paint all the posts such that no more than two adjacent fence
 * posts have the same color.
 * 
 * Return the total number of ways you can paint the fence.
 * 
 * @author VictorQian
 * 
 */
public class PaintFence {
	public int _numWays(int n, int k) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return k;

		int[] ways = new int[2];
		ways[0] = k;
		ways[1] = k * k;
		for (int i = 2; i < n; i++) {
			// if posts[i-1] is same color as post[i-2], post[i] could have k-1
			// color choice, so the way is ways[i-2]*(k-1)
			// if posts[i-1] is different color as post[i-2], post[i] could have
			// same color as post[i-1], or different color (k-1) as post[i-1].
			// so the total way is ways[1]+way[1]*(k-1)
			int way = ways[0] * (k - 1) + ways[1] * (k - 1);
			ways[0] = ways[1];
			ways[1] = way;
		}
		return ways[1];
	}

	/**
	 * We divided it into two cases.
	 * 
	 * the last two posts have the same color, the number of ways to paint in
	 * this case is sameColorCounts.
	 * 
	 * the last two posts have different colors, and the number of ways in this
	 * case is diffColorCounts.
	 * 
	 * The reason why we have these two cases is that we can easily compute both
	 * of them, and that is all I do. When adding a new post, we can use the
	 * same color as the last one (if allowed) or different color. If we use
	 * different color, there're k-1 options, and the outcomes shoule belong to
	 * the diffColorCounts category. If we use same color, there's only one
	 * option, and we can only do this when the last two have different colors
	 * (which is the diffColorCounts). There we have our induction step.
	 * 
	 */
	public int numWays(int n, int k) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return k;
		int diffColorCounts = k * (k - 1);
		int sameColorCounts = k;
		for (int i = 2; i < n; i++) {
			int temp = diffColorCounts;
			diffColorCounts = (diffColorCounts + sameColorCounts) * (k - 1);
			sameColorCounts = temp;
		}
		return diffColorCounts + sameColorCounts;
	}

	public static void main(String[] args) {
		PaintFence p = new PaintFence();
		System.out.println(p._numWays(5, 5));
	}
}
