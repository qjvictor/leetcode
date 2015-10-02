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
		System.out.println(f.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
	}
}
