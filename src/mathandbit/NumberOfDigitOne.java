package mathandbit;
/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13. 
 * @author VictorQian
 *
 */
public class NumberOfDigitOne {
	//naive method.
	public int countDigitOne1(int n) {
		int ret=0;
        for(int i=1;i<=n;i++){
        	ret+=getDigitOne(i);
        }
        return ret;
    }
	private int getDigitOne(int n){
		int ret=0;
		while(n!=0){
			ret+=(n%10==1?1:0);
			n=n/10;
		}
		return ret;
	}
	
	public int countDigitOne2(int n) {
		int res = 0, a = 1, b = 1;
		while (n > 0) {
			res += (n + 8) / 10 * a + ((n % 10 == 1) ? b : 0);
			b += n % 10 * a;
			a *= 10;
			n /= 10;
		}
		return res;
	}
	
	 /**
	 * Calculate occurance on every digit, from
	 * least important digit to most important digit
	 * number = 1432
	 * One's digit: n/10=143 143*1+1
	 * Ten's digit: n/100=14 14*10+10
	 * Hun's digit: n/1000=1 1*100+100
	 * Tho's digit: 1432%1000+1=433
	 * Sum all occurance on digits together
	 */
	public static int countDigitOne(int n) {
		int count = 0, factor = 1, k = n;
		while (k > 0) {
			int m = k / 10, r = k % 10, amount;
			if (r == 0)
				amount = 0;
			else if (r > 1)
				amount = factor;
			else
				amount = n % factor + 1;

			count += m * factor + amount;
			factor *= 10;
			k = k / 10;
		}
		return count;
	}


	
	public static void main(String[] args){
		NumberOfDigitOne n = new NumberOfDigitOne();
		long b = System.currentTimeMillis();
		System.out.println(n.countDigitOne(1432));
		System.out.println(System.currentTimeMillis()-b);
		System.out.println(n.countDigitOne(13));
	}
}
