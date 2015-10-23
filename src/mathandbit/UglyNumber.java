package mathandbit;

/**
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another
 * prime factor 7.
 * 
 * Note that 1 is typically treated as an ugly number.
 * 
 * @author VictorQian
 * 
 */
public class UglyNumber {
	public boolean isUgly(int num) {
		if (num < 1)
			return false;
		while (num != 1) {
			if (num % 5 == 0) {
				num = num / 5;
			} else if (num % 3 == 0) {
				num = num / 3;
			} else if (num % 2 == 0) {
				num = num / 2;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		UglyNumber u = new UglyNumber();
		for(int i=-1;i<20;i++){
			System.out.println(i+":"+u.isUgly(i));
		}
	}
}
