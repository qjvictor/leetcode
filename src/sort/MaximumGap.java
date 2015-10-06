package sort;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 * 
 * @author VictorQian
 * 
 */
public class MaximumGap {
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;
		//find min and max
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			min=Math.min(nums[i], min);
			max=Math.max(nums[i], max);
		}
		if(max==min) return 0; //all same numbers.
		
		int gap = (int)Math.ceil((double)(max - min)/(nums.length - 1));
		//construct n-1 buckets and put the n-2 elements (without the max and the min) into the bucket
		int[] bucketsMIN = new int[nums.length - 1]; //n-1 buckets
        int[] bucketsMAX = new int[nums.length - 1];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put (n-2) numbers into buckets, then at least one of the bucket is empty.
        // so the maxGap is not possible from bucketsMAX-bucketsMIN in the same bucket.
        for (int i:nums) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap; // index of the right position in the buckets
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;//min is on the first.
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous); // max is on the last.
        return maxGap;
	}
	
	public static void main(String[] args){
		MaximumGap m = new MaximumGap();
		System.out.println(m.maximumGap(new int[]{1,2}));
	}
}
