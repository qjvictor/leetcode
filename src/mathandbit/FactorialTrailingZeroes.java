package mathandbit;
/**
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 * @author VictorQian
 *
 */
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		//if(n < 5) return 0;
	    //return n / 5 + trailingZeroes(n / 5);
		int count = 0;
		while (n > 0) {
			n = n / 5;
			count += n;
		}
		return count;
    }
	
	public static void main(String[] args){
		FactorialTrailingZeroes f = new FactorialTrailingZeroes();
		System.out.println(f.trailingZeroes(10));
		System.out.println(f.trailingZeroes(1808548329)); //434051598   452137076
	}
}
