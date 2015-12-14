package _important;

public class Reverse {
	public int reverseInteger(int x) {
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
	
	public int reverseBits(int n) {
    	int ret=0;
        for(int i=0;i<32;i++){
            ret=(ret<<1) + (n&1);
            n>>=1;
        }
        return ret;
    }
}
