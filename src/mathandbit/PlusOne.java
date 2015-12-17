package mathandbit;
/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 * @author VictorQian
 *
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		if(digits==null || digits.length==0) return new int[]{1};
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--){
            int sum = digits[i]+carry;
            digits[i]=sum%10;
            carry=sum/10;
            if(carry==0) break;
        }
        if(carry==1){
            int[] ret = new int[digits.length+1];
            ret[0]=1;
            return ret;
        } else{
            return digits;
        }
    }
	
	public static void main(String[] args){
		PlusOne p = new PlusOne();
		int[] digits = new int[]{9,8,9,9,9};
		int[] ret = p.plusOne(digits);
		for(int i=0;i<ret.length;i++){
			System.out.print(ret[i]);
		}
	}
}
