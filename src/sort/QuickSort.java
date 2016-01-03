package sort;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		int[] x = { 7,2,1,6,8,5,3,4};
		System.out.println(Arrays.toString(x));

		int low = 0;
		int high = x.length - 1;

		sort.quickSort(x, low, high);
		System.out.println(Arrays.toString(x));
	}
	
	public void quickSort(int[] arr, int start, int end) {
		if (arr == null || arr.length == 0)
			return;
		if (start >= end)
			return;
		int pIndex = partition(arr, start, end);
		quickSort(arr, start, pIndex - 1);
		quickSort(arr, pIndex + 1, end);
	}

	private int partition(int[] arr, int start, int end) {
		//select the mid as pivot.
		//int pivotIndex = start + (end - start) / 2;  
		//select random index as pivot.
		Random r = new Random();
		int randomIndex = r.nextInt(end-start) + start;
		int pivotIndex = randomIndex;
		int pivotValue = arr[pivotIndex];
		// swap the pivot and last.
		swap(arr, pivotIndex, end);                   
		
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivotValue) {
				swap(arr, pIndex, i);
				pIndex++;
			}
		}
		//swap the pivot (end) with the pIndex.   pIndex is the right place for the pivot.
		swap(arr, pIndex, end);						
		return pIndex;
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public void _quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		System.out.println(pivot+":"+Arrays.toString(arr));
		// recursively sort two sub parts
		if (low < j)
			_quickSort(arr, low, j);

		if (high > i)
			_quickSort(arr, i, high);
	}
	
	

}