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
public class FindKthLargest2 {

	public int findKthLargest(int[] nums, int k) {
		return kthSmallest(nums, nums.length - k); // kthLargest is same as len-k smallest.
	}

	private int kthSmallest(int[] a, int k) {
		int l = 0, r = a.length - 1;
		while (true) {
			int index = partition(a, l, r);
			if (index == k)
				return a[k];
			if (index > k)
				r = index - 1;
			else
				l = index + 1;
		}

	}

	private int partition(int a[], int l, int r) {
		if (l == r)
			return l;
		int pivotIndex = (l + r) >> 1; // l+(r-l)/2;
		int pivot = a[pivotIndex];
		
		swap(a, pivotIndex, r);//move the pivot to the right most.

		int index = l;
		for (int i = l; i < r; i++) {
			if (a[i] < pivot) {
				swap(a, i, index);
				index++;
			}
		}
		swap(a, index, r);//move the pivot value to the right place.
		return index;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		FindKthLargest2 f = new FindKthLargest2();
		System.out.println(f.findKthLargest(new int[] { 2,13,14,5 }, 2));
	}
}
