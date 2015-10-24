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
	public int _countDigitOne(int n) {
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
	
	public int countDigitOne(int n) {
		int res = 0, a = 1, b = 1;
		while (n > 0) {
			res += (n + 8) / 10 * a + ((n % 10 == 1) ? b : 0);
			b += n % 10 * a;
			a *= 10;
			n /= 10;
		}
		return res;
	}
	
	public static void main(String[] args){
		NumberOfDigitOne n = new NumberOfDigitOne();
		long b = System.currentTimeMillis();
		System.out.println(n.countDigitOne(1000000000));
		System.out.println(System.currentTimeMillis()-b);
		System.out.println(n.countDigitOne(13));
	}
}
