package kthLargest;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * @author VictorQian
 * 
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null && nums2==null) return 0d;
        int len = nums1.length+nums2.length;
        if(len%2==0){
        	int i1=helper(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, len/2);
        	int i2=helper(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, len/2+1);
            return (i1+i2)/2d;
        } else{
            return helper(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, len/2+1)*1d;
        }
    }
    
    private int helper(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        if(len1>len2){
            return helper(nums2, start2, end2, nums1, start1, end1, k);
        }
        //edge case 1
        if(len1==0){
            return nums2[start2+k-1];
        }
        //edge case 1
        if(k==1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        //normal case:
        int posA = Math.min(k/2,len1);  
        int posB = k-posA;
        if(nums1[start1+posA-1]==nums2[start2+posB-1]){
            return nums1[start1+posA-1];
        } else if(nums1[start1+posA-1]<nums2[start2+posB-1]){
            return helper( nums1, start1+posA, end1, nums2, start2, start2+posB-1, k-posA);
        } else{
            return helper( nums1, start1, start1+posA-1, nums2, start2+posB, end2, k-posB);
        }
    }
}
