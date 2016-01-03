package sort;

import java.util.Arrays;

public class FindMedianFromUnSortedArray {
	public static void main(String[] args) {
		FindMedianFromUnSortedArray f = new FindMedianFromUnSortedArray();
		int[] x = { 7, 2, 1, 6, 8, 5, 3, 4, 9};
		System.out.println(Arrays.toString(x));
		double median = -1d;
		if (x.length % 2 == 1) {
			median = f.findMedian(x, x.length / 2 + 1);
		} else {
			median = (f.findMedian(x, x.length / 2) + f.findMedian(x, x.length / 2) + 1) * 0.5;
		}
		System.out.println(median);
	}

	
	public int findMedian(int[] arr, int k) {
		if (arr == null || arr.length == 0)
			return -1;
		if (k > arr.length)
			return -1;
		return select(arr, k - 1, 0, arr.length - 1);
	}

	private int select(int[] arr, int k, int start, int end) {
		if (start >= end)
			return arr[start];
		int pIndex = partition(arr, start, end);
		if (pIndex == k) {
			return arr[pIndex];
		} else if (pIndex < k) {
			return select(arr, k, pIndex + 1, end);
		} else {
			return select(arr, k, start, pIndex - 1);
		}
		/**
		while (true) {
			int pIndex = partition(arr, start, end);
			if (pIndex == k) {
				return arr[pIndex];
			} else if (pIndex < k) {
				start = pIndex + 1;
			} else {
				end = pIndex - 1;
			}
		}
		*/
	}

	private int partition(int[] arr, int start, int end) {
		if (start == end)
			return start;
		int mid = start + (end - start) / 2;
		swap(arr, mid, end);
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (arr[i] <= arr[end]) {
				swap(arr, i, pIndex);
				pIndex++;
			}
		}
		swap(arr, pIndex, end);
		return pIndex;
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
