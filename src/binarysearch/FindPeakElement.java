package binarysearch;
/**
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * @author VictorQian
 *
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int l=0, r=nums.length-1;
        while(l<=r){
        	if(l==r) return l;
        	int m = l+(r-l)/2;
            if(nums[m]<nums[m+1])
                l=m+1;  
            else  
                r=m;  
        }
        return l;
    }
	
	public int _findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] > nums[mid + 1]) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
    }
	
	public static void main(String[] args){
		FindPeakElement f = new FindPeakElement();
		System.out.println(f._findPeakElement(new int[]{1,2,3,1}));
	}
}
