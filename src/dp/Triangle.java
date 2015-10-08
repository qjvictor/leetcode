package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
 *
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		int[] min = new int[triangle.size()];

		for (int i = 0; i < triangle.size(); i++) {
			min[i] = triangle.get(triangle.size() - 1).get(i);
		}

		for (int i = triangle.size() - 2; i >= 0; i--) {
			List<Integer> list = triangle.get(i);
			for (int j =0; j <list.size(); j++) {
				min[j] = Math.min(min[j], min[j + 1]) + list.get(j);
			}
		}
		return min[0];
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);

		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		triangle.add(l4);
		Triangle t = new Triangle();
		System.out.println(t.minimumTotal(triangle));

	}
}
