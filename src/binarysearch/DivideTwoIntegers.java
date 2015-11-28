package binarysearch;
/**
 *  Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT. 
 * @author VictorQian
 *
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
		boolean isNegative = false;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			isNegative = true;
		}
		long dvd = Math.abs((long)dividend);
		long div = Math.abs((long)divisor);
		int ret=0;
		while (dvd >= div) {
	        long x = 1;
	        long ndiv = div;
	        while ((ndiv<<1) < dvd) {
	            x <<= 1;
	            ndiv <<= 1;
	        }

	        ret += x;
	        dvd = dvd - ndiv;
	    }

	    return isNegative?(0-ret):ret;
    }
//
//	private int helper(long d1, long d2) {
//		if (d1 < d2)
//			return 0;
//		long tmp = d2;
//		int bit = 0;
//		while (d1 >= d2) {
//			d2 = d2 << 1;
//			bit = bit == 0 ? 1 : (bit << 1);
//		}
//		d2 = d2 >> 1;
//		return bit + helper(d1 - d2, tmp);
//	}
	
	public static void main(String[] args){
		DivideTwoIntegers d = new DivideTwoIntegers();
		
		System.out.println(d.divide(Integer.MIN_VALUE, -1));
		System.out.println(d.divide(3, Integer.MIN_VALUE));
		System.out.println(d.divide(-54, 3));
	}
}
