package mathandbit;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * @author VictorQian
 * 
 */
public class SingleNumberII {
	public int singleNumber(int[] nums) {
		int[] bitmap = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++) {
				bitmap[i] += (nums[j] >> i) & 1;
			}
		}
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			ret += (bitmap[i] % 3) << i;
		}
		return ret;
	}

	public static void main(String[] args) {
		SingleNumberII s = new SingleNumberII();
		System.out.println(s.singleNumber(new int[] { 1, 1, 1, 3, 3, 3, 6, 7, 7, 7 }));

		System.out.println(Integer.toBinaryString(12)); // 1100
		System.out.println(Integer.toBinaryString(12 >> 2)); // 0011
		System.out.println(Integer.toBinaryString(12 << 2));// 110000

	}
}
