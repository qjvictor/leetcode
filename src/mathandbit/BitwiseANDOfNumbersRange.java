package mathandbit;
/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4. 
 * @author VictorQian
 *
 */
public class BitwiseANDOfNumbersRange {
	public static void main(String[] args){
		BitwiseANDOfNumbersRange b = new BitwiseANDOfNumbersRange();
		System.out.println(b.rangeBitwiseAnd(14,17));
		System.out.println(b.rangeBitwiseAnd(2,3));
	}
	//solution:  find the common prefix of m and n in binary.
	//直接平移m和n，每次向右移一位，直到m和n相等，记录下所有平移的次数i，然后再把m左移i位即为最终结果
	public int rangeBitwiseAnd(int m, int n) {
		if (m < 0 || n < 0 || m > n)
			return 0;
		if (m == n)
			return m;
		int factor = 0;
		while (m != n) {
			m = m >> 1;
			n = n >> 1;
			factor++;
		}
		return m << factor;
	}
}
