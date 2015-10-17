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
		System.out.println(b.rangeBitwiseAnd(5,7));
		System.out.println(b.rangeBitwiseAnd(2,3));
	}
	//solution:  find the common prefix of m and n in binary.
	public int rangeBitwiseAnd(int m, int n) {
		if (m < 0 || n < 0 || m > n)
			return 0;
		if (m == n)
			return m;
		int factor = 1;
		while (m != n) {
			m = m >> 1;
			n = n >> 1;
			factor *= 2;
		}
		return factor * m;
	}
}
