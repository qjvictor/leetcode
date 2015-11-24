package binarysearch;
/**
 * Implement pow(x, n). 
 * @author VictorQian
 *
 */
public class Pow {
	public double _myPow(double x, int n) {
		if (n == 0)
			return 1.0;
		if (n == 1)
			return x;
		double half = myPow(x, n / 2); //get the half.
		if (n % 2 == 0) { //even number
			return half * half;
		} else if (n > 0) { //odd number, but n>0
			return half * half * x;
		} else { //odd number, n<0
			return half * half / x;  // 除以x is x的负1次方
		}
	}
	
	public double myPow1(double x, int n) {
	    // special case
		if (x == 0 || x == 1 || n == 1) {
			return x;
		} else if (n == 0) {
			return 1;
		}
		// negative result
		if (x < 0 && n % 2 != 0) {  
			return -myPow1(-x, n);
		} else if (x < 0 && n % 2 == 0) {
			return myPow1(-x, n);
		}
		// fractor result
		if (n < 0) {
			return 1 / myPow1(x, -n);
		}
		// main calculation
		return helper(x, n);
	}
	private double helper(double x, int n) {
	    // precondition: x > 0 && n > 0
	    if (n == 1) {return x;}
	    return (((n % 2) == 0)? helper(x*x, n/2): (helper(x*x, n/2)*x));
	}
	
	public double myPow(double x, int n) {
		//iterate
		return 0d;
	}
	
	public static void main(String[] args){
		Pow p = new Pow();
		System.out.println(p._myPow(-1.00000, -2147483648));
	}
}
