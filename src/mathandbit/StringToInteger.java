package mathandbit;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author VictorQian
 * 
 */
public class StringToInteger {
	public int myAtoi(String str) {
        if(str==null || str.length()==0) return 0;
        int sign=1;
        int ret=0;
        int i=0;
        int len=str.length();
        //leading space
        while(i<len && str.charAt(i)==' '){
        	i++;
        }
        //sign
        if(i<len && (str.charAt(i)=='+' || str.charAt(i)=='-')){
        	if(str.charAt(i)=='-'){
        		sign=-1;
        	}
        	i++;
        }
        //number.
        while(i<len && (str.charAt(i)>='0' && str.charAt(i)<='9')){
			if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && str.charAt(i) >= '8')) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;// overflow
			}
        	ret=ret*10+str.charAt(i)-'0';
        	i++;
        }
        
        return sign*ret;
    }
	
	public static void main(String[] args){
		StringToInteger s = new StringToInteger();
		System.out.println(s.myAtoi(" 121a2.21"));
		System.out.println(s.myAtoi(" -121 a2.21"));
		
		System.out.println(s.myAtoi(" 12 1a2.21"));
	}
}
