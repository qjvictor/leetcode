package _important;
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
		double half = myPow(x, n / 2); // get the half.
		if (n % 2 == 0) { // even number
			return half * half;
		} else { //odd number
			if (n > 0) { // n>0
				return half * half * x;
			} else { // n<0
				return half * half / x; // 除以x is x的负1次方
			}
		}
	}
	
	//best solution.
	public double pow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}

	private double power(double x, int n) {
		if (n == 0)
			return 1;
		double v = power(x, n / 2);
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
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
		if (n == 0)
			return 1;
		if (n < 0) {//n==Integer.MIN_VALUE,  -n would be Integer.MIN_VALUE, same as n.
			n = -n;
			x = 1 / x;
		}
		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
	
	public static void main(String[] args){
		Pow p = new Pow();
		System.out.println(p.pow(7.00000, -5));
	}
}
