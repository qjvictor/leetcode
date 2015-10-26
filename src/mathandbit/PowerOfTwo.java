package mathandbit;
/**
 *  Given an integer, write a function to determine if it is a power of two. 
 * @author VictorQian
 *
 */
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		//one line solution.
		return n > 0 && (n&(n-1)) == 0;
//		if (n < 0)
//			return false;
//		int count = 0;
//		int i = 0;
//		while (i < 32) {
//			count += (n & (1 << i)) != 0 ? 1 : 0;
//			if (count > 1)
//				return false;
//			i++;
//		}
//		return count == 1;
    }
	
	public static void main(String[] args){
		PowerOfTwo  p = new PowerOfTwo();
		for(int i=0;i<100;i++){
			System.out.println(i+" - "+p.isPowerOfTwo(i));
		}
	}
}
