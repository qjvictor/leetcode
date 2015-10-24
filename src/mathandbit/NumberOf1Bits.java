package mathandbit;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1'
 * bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer '11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 * 
 * @author VictorQian
 * 
 */
public class NumberOf1Bits {
	// you need to treat n as an unsigned value
//    public int _hammingWeight(int n) {
//		int ret = 0;
//		int i = 0;
//		while (i < 32) {
//			ret += (n & (1 << i)) == 0 ? 0 : 1;
//			i++;
//		}
//		return ret;
//    }
    
    public int hammingWeight(int n) {
		int ret = 0;
		while (n != 0) {
			ret += (n - (n >> 1 << 1));
			n >>>= 1;
		}
		return ret;
    }
    
    public static void main(String[] args){
    	NumberOf1Bits n = new NumberOf1Bits();
    	System.out.println(n.hammingWeight(Integer.MAX_VALUE));
    }
}
