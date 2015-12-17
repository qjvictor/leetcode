package _important;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * click to show spoilers. Have you thought about this?
 * 
 * Here are some good questions to ask before coding. Bonus points for you if
 * you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * For the purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 * 
 * @author VictorQian
 * 
 */
public class ReverseInteger {
	public int reverse(int x) {
        int ret=0;
        while(x!=0){
        	if(Math.abs(ret)>Integer.MAX_VALUE/10){
        		return 0;
        	}
        	ret=ret*10+x%10;
        	x/=10;
        }
        return ret;
    }
	
	public static void main(String[] args){
		ReverseInteger r = new ReverseInteger();
    	System.out.println(r.reverse(43261596));
    	System.out.println(r.reverse(964176192));
    	System.out.println(r.reverse(Integer.MAX_VALUE));
    	System.out.println(r.reverse(Integer.MIN_VALUE));
    }
}
