package array;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * 
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5
 * 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3
 * -1 -3 5 [3 6 7] 7
 * 
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note: You may assume k is always valid, ie: 1 <= k <= input array's size for
 * non-empty array.
 * 
 * @author evicqia
 * 
 */
public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length==0 || nums.length < k || k<=0)	return new int[]{};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10,
				new Comparator<Integer>() {
					@Override
					public int compare(Integer v1, Integer v2) {
						return v2 - v1;
					}
				});
		int[] ret = new int[nums.length - k + 1];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (pq.size() == k - 1) {
				pq.add(nums[i]);
				ret[index++] = pq.peek();
			} else if (pq.size() < k - 1) {
				pq.add(nums[i]);
			} else {
				pq.remove(nums[i-k]);
				pq.add(nums[i]);
				ret[index++] = pq.peek();
			}
		}
		return ret;
	}
	
	public int[] _maxSlidingWindow(int[] nums, int k) {
	    if(nums.length==0) return new int[0];
	    Deque<Integer> deque = new LinkedList<Integer>();
	    int[] res = new int[nums.length-k+1];
	    for(int i=0;i<nums.length;i++){
	        if(i>=k && deque.getLast()==nums[i-k]) 
	        	deque.removeLast();  
	        while(!deque.isEmpty() && deque.getFirst()<nums[i]) 
	        	deque.removeFirst();
	        deque.addFirst(nums[i]);
	        if(i+1>=k) 
	        	res[i-k+1] = deque.getLast();
	    }
	    return res;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum s = new SlidingWindowMaximum();
		int[] ret = s._maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
		for (int i : ret) {
			System.out.print(i+" ");
		}
		System.out.println();
		ret = s.maxSlidingWindow(new int[] { 1 }, 1);
		for (int i : ret) {
			System.out.print(i+" ");
		}
		System.out.println();
		ret = s.maxSlidingWindow(new int[] {9,10,9,-7,-4,-8,2,-6}, 5);
		for (int i : ret) {
			System.out.print(i+" ");
		}
	}
}
