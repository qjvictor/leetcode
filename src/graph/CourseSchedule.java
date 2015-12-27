package graph;
import java.util.*;
/**
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
and to take course 0 you should also have finished course 1. So it is impossible.
 * @author VictorQian
 *
 */
public class CourseSchedule {
	//O(V+E)
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 1)
			return true;
		List<Integer>[] in = new ArrayList[numCourses];
		List<Integer>[] out = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			in[i] = new ArrayList<Integer>();
			out[i] = new ArrayList<Integer>();
		}
		for (int[] pre : prerequisites) {
			in[pre[0]].add(pre[1]);   //inDegree   
			out[pre[1]].add(pre[0]);  //outDegree 
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < in.length; i++) {
			if (in[i].size() == 0) {
				queue.offer(i);
			}
		}
		int finishedCourses = queue.size();
		while (!queue.isEmpty()) {
			int finishedCourse = queue.poll();
			for(Integer i: out[finishedCourse]){
				in[i].remove((Integer)finishedCourse);
				if(in[i].size()==0){
					queue.offer(i);
					finishedCourses++;
				}
			}
		}
		return finishedCourses == numCourses;
    }
}
