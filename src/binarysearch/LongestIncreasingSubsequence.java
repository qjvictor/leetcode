package binarysearch;


/**
 *  Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity? 
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = 0;
		int[] a = new int[nums.length];
		for (int i : nums) {
			int j = BinarySearch(a, 0, len - 1, i);
			a[j] = i;
			if (j == len)
				len++;
		}
		return len;
	}

	public int BinarySearch(int[] a, int l, int r, int key) {
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (a[m] >= key)
				r = m - 1;
			else
				l = m + 1;
		}
		return l;
	}
	
	public static void main(String[] args){
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		System.out.println(l.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));  //[1,3,6,7,9,4,10,5,6]
	}
}
