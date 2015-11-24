package binarysearch;
/**
 * Implement int sqrt(int x).

Compute and return the square root of x.
 * @author VictorQian
 *
 */
public class Sqrt {
	//time O(logx), space O(1)
	public int mySqrt(int x) {
		if (x < 0)
			return -1;
		if (x <= 1)
			return x;
		int left = 1;
		int right = x / 2;
		while (left <= right) {
			int m = (left + right) / 2;
			if (m == x / m || (m < x / m && m + 1 > x / (m + 1)))  //condition:  m*m==x   or   m*m<x but (m+1)*(m+1)>x.  but m*m might cause overflow, so here use m==x/m.
				return m;
			else if (m < x / m) {
				left = m + 1;
			} else {
				right = m - 1;
			}
		}
		return 0;
    }
	//newton method. ???
	public int sqrt(int x) {
		if (x == 0)
			return 0;
		double lastY = 0;
		double y = 1;
		while (y != lastY) {
			lastY = y;
			y = (y + x / y) / 2;
		}
		return (int) (y);
	}
	
	public static void main(String[] args){
		Sqrt s = new Sqrt();
		System.out.println(s.mySqrt(10));
		System.out.println(s.mySqrt(14));
		System.out.println(s.mySqrt(19));
		
		System.out.println(s.sqrt(19));
	}
}
