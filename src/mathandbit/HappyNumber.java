package mathandbit;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 * @author VictorQian
 *
 */
public class HappyNumber {
	public boolean isHappy(int n) {
        if(n<=0) return false;
        Set<Integer> set = new HashSet<>();
        return helper(n, set);   
    }
	
	private boolean helper(int n, Set<Integer> set){
		if(set.contains(n)) 
			return false;
		else
			set.add(n);
		int ret=0;
		while(n!=0){
			ret+=(n%10)*(n%10);
			n=n/10;
		}
		if(ret==1) {
			return true;
		} else{
			return helper(ret, set);
		}	
	}
	
	public boolean _isHappy(int n) {
        if(n==1) return true;
        HashSet<Integer> hs = new HashSet<Integer>();
        while(n!=1){
            hs.add(n);
            int sum=0;
            while(n!=0){
                int tmp = n%10;
                sum+=tmp*tmp;
                n=n/10;
            }
            n=sum;
            if(hs.contains(n))
                return false;
        }
        return true;
    }
	
	
	public static void main(String[] args){
		HappyNumber h = new HappyNumber();
		h.isHappy(19);
		for(int i=1;i<100;i++){
			System.out.println(i+"="+h.isHappy(i));
		}
	}
}
