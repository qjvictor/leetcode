package graph;
import java.util.*;
/**
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]

There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
Both courses 1 and 2 should be taken after you finished course 0. 
So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * @author VictorQian
 *
 */
public class CourseScheduleII {
	public static void main(String[] args){
		CourseScheduleII c2 = new CourseScheduleII();
		int[] ret = c2.findOrder(4, new int[][]{new int[]{1,0},new int[]{2,0},new int[]{3,1},new int[]{3,2}});
		for(int i: ret){
			System.out.print(i);
		}
		ret = c2.findOrder(2, new int[][]{new int[]{1,0},new int[]{0,1}});
		for(int i: ret){
			System.out.print(i);
		}
	}
	
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0)
			return null;
		int[] ret = new int[numCourses];
		List<Integer>[] inDegrees = new ArrayList[numCourses];
		List<Integer>[] outDegrees = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			inDegrees[i] = new ArrayList<Integer>();
			outDegrees[i] = new ArrayList<Integer>();
		}
		for (int[] pre : prerequisites) {
			inDegrees[pre[0]].add(pre[1]);
			outDegrees[pre[1]].add(pre[0]);
		}
		int index = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < inDegrees.length; i++) {
			List<Integer> inDegree = inDegrees[i];
			if (inDegree.isEmpty()) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int fin = queue.poll();
			ret[index++] = fin;
			List<Integer> out = outDegrees[fin];
			for (Integer o : out) {
				inDegrees[o].remove((Integer) fin);
				if (inDegrees[o].isEmpty()) {
					queue.add(o);
				}
			}
		}

		if (index != numCourses) {
			return new int[0];
		} else {
			return ret;
		}
    }
}
