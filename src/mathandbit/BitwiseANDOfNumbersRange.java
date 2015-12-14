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
		System.out.println(b.rangeBitwiseAnd(5,7));
	}
	//solution:  find the common prefix of m and n in binary.
	public int rangeBitwiseAnd(int m, int n) {
		if (m < 0 || n < 0 || m > n)
			return 0;
		if (m == n)
			return m;
		int diffBits = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            diffBits++;
        }
        return n<<diffBits;
	}
}
