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
public class FindKthLargest {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return -1;
		return quickSelect(nums, k - 1, 0, nums.length - 1);
	}

	private int quickSelect(int[] arr, int k, int left, int right) {
		// pick the pivot
		int pivot = arr[(left + right) / 2];
		int i = left;
		int j = right;
		// make left < pivot and right > pivot
		while (i <= j) {
			while (arr[i] > pivot) {
				i++;
			}
			while (arr[j] < pivot) {
				j--;
			}

			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		// selection
		if (left < j && k <= j)
			return quickSelect(arr, k, left, j);
		if (i < right && k >= i)
			return quickSelect(arr, k, i, right);
		return arr[k];

	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		FindKthLargest f = new FindKthLargest();
		System.out.println(f.findKthLargest(new int[] { 5, 2, 12, 4, 8, 7, 16, 20, 199, 21 }, 3));
	}
}
