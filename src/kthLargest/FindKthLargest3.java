package kthLargest;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 <= k <= array's length.
 * 
 * @author VictorQian
 * 
 */
import java.util.PriorityQueue;

public class FindKthLargest3 {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return -1;
		if (k > nums.length)
			return -1;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
		for (int i = 0; i < nums.length; i++) {
			if (i < k) {
				heap.add(nums[i]);
			} else {
				if (nums[i] > heap.peek()) {
					heap.poll();
					heap.offer(nums[i]);
				}
			}
		}
		return heap.peek();
	}

	public static void main(String[] args) {
		FindKthLargest3 f = new FindKthLargest3();
		System.out.println(f.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
	}
}
