package mathandbit;
/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 * @author VictorQian
 *
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if (n <= 0)
			return "";
		StringBuilder sb = new StringBuilder();
		 
	    while(n > 0){
	        n--;  //that's the key:  The minimum in 26-bit number is mapped to 1, not 0.
	        char ch = (char) (n % 26 + 'A');
	        n /= 26;
	        sb.append(ch);
	    }
	 
		return sb.reverse().toString();
	}
	
	public static void main(String[] args){
		ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
		System.out.println(e.convertToTitle(26));
		System.out.println(e.convertToTitle(28));
		System.out.println(e.convertToTitle(52));
		System.out.println(e.convertToTitle(53));
		System.out.println(e.convertToTitle(77));
	}
}
