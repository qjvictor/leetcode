package mathandbit;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one.
 * 
 * @author VictorQian
 * 
 */
public class ValidNumber {
	public boolean isNumber(String s) {
        if(s==null || s.length()==0) return false;
        int i=0;
        int len=s.length();
        boolean isNumber=false;
        //leading spaces.
        while(i<len && s.charAt(i)==' '){
        	i++;
        }
        //Sign part.
        if(i<len && (s.charAt(i)=='+' || s.charAt(i)=='-')){
        	i++;
        }
        //Integer part.
        while(i<len && s.charAt(i)>='0' && s.charAt(i)<='9'){
        	i++;
        	isNumber=true;
        }
        //Dot: should be dealt with point part together.
		if (i < len && s.charAt(i) == '.') {  //how come '3.' is a valid number?
			i++;
			while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {// point part
				i++;
				isNumber = true;
			}
		}
       
        //Scientific number part;
        if(i<len && s.charAt(i)=='e' && isNumber){
        	i++;
        	isNumber=false;
        	if(i<len && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            	i++;
            }
        	while(i<len && s.charAt(i)>='0' && s.charAt(i)<='9'){
            	i++;
            	isNumber=true;
            }
        }
        
        //trailing spaces.
        while(i<len && s.charAt(i)==' '){
        	i++;
        }
        return isNumber && i==len;
    }
	
	public static void main(String[] args){
		ValidNumber v = new ValidNumber();
		System.out.println(v.isNumber("3."));//how come this is valid???
		System.out.println(v.isNumber("e9"));
		System.out.println(v.isNumber("3"));
		System.out.println(v.isNumber("0 "));
		System.out.println(v.isNumber(" 0.9 "));
		System.out.println(v.isNumber(" +0.3 "));
		System.out.println(v.isNumber("abc"));
		System.out.println(v.isNumber(" 10a"));
		System.out.println(v.isNumber(" 10e22 3"));
		System.out.println(v.isNumber(" 10e+2"));
		System.out.println(v.isNumber(" 10e"));
	}
}
