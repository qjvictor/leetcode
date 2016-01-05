package dp;

import java.util.Arrays;

public class LongestBitonicSubsequence {
	
	public int lengthOfBitonicSubsequence(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int ret = 1;
		int[] incre = new int[nums.length];
		Arrays.fill(incre, 1);
		for (int i = 1; i < nums.length; i++) {
			incre[i]=1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					incre[i] = Math.max(incre[i], incre[j] + 1);
				}
			}
		}

		int[] dec = new int[nums.length];
		Arrays.fill(dec, 1);
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j] < nums[i]) {
					dec[i] = Math.max(dec[i], dec[j] + 1);
				}
			}
		}

		for (int i = 0; i < incre.length; i++) {
			ret = Math.max(ret, incre[i] + dec[i] - 1);
		}
		return ret;
	}
	
	public static void main(String[] args){
		LongestBitonicSubsequence l = new LongestBitonicSubsequence();
		System.out.println(l.lengthOfBitonicSubsequence(new int[] { 2, -1, 4, 3, 5, -1, 3, 2 }));
	}
}
