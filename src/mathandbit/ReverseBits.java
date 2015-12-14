package mathandbit;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * @author VictorQian
 * 
 */
public class ReverseBits {
	// you need treat n as an unsigned value
    public int reverseBits(int n) {
    	int ret=0;
        for(int i=0;i<32;i++){
            ret=(ret<<1) + (n&1);
            n>>=1;
        }
        return ret;
    }
    
    public static void main(String[] args){
    	ReverseBits r = new ReverseBits();
    	System.out.println(r.reverseBits(43261596));
    	System.out.println(r.reverseBits(964176192));
    	System.out.println(r.reverseBits(Integer.MAX_VALUE));
    	System.out.println(r.reverseBits(Integer.MIN_VALUE));
    }
}
