package mathandbit;
/**
 * Write a method to implement *, - , / operations. You should use only the + operator
 * @author evicqia
 *
 */
public class OperantUsingAdd {
	//use '+' to flip the nubmer,  5-> -5, -5->5
	private int flip(int a){
		if (a == 0)
			return 0;
		int b = 0;
		int v = 1;
		if (a > 0)
			v = -1;
		while (a != 0) {
			a += v;
			b += v;
		}
		return b;
	}
	//a-b = a+(-b)
	public int deduct(int a, int b) {
		return a + flip(b);
	}
	
	private boolean differentSign(int a, int b) {
		if ((a > 0 && b < 0) || (a < 0 && b > 0))
			return true;
		return false;
	}
	
	private int abs(int a){
		if(a<0) return flip(a);
		return a;
	}
	
	//a*b = a+a+...+a   or b+b+...+b
	public int multiple(int a, int b) {
		if(a<b) return multiple(b, a);
		int ret=0;
		boolean diffSign = differentSign(a,b);
		b = abs(b);
		a = abs(a);
		for(int i=0;i<b;i++){
			ret+=a;
		}
		if(diffSign){
			ret=flip(ret);
		}
		return ret;
	}
	//a/b 
	public int divide(int a, int b) {
		if(b==0) return -1; //invalid.
		int ret=0;
		boolean diffSign = differentSign(a,b);
		b = abs(b);
		a = abs(a);
		int div=b;
		while(div<=a){
			div+=b;
			ret+=1;
		}
		if(diffSign){
			ret=flip(ret);
		}
		return ret;
	}
	
	public static void main(String[] args){
		OperantUsingAdd o = new OperantUsingAdd();
		System.out.println(o.flip(100));
		System.out.println(o.deduct(100, 100));
		
		System.out.println(o.multiple(-5, -3));
		System.out.println(o.divide(128129128, 1));
	}
}
