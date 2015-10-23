package mathandbit;
/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 * @author VictorQian
 *
 */
public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int ret = 0;
		for (int i = 0; i < s.length(); i++) {
			ret = ret * 26 + (s.charAt(i) - 'A' + 1);
		}
		return ret;
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
		System.out.println(e.titleToNumber("AB"));
		System.out.println(e.titleToNumber("Z"));
		System.out.println(e.titleToNumber("AZ"));
		System.out.println(e.titleToNumber("F"));
	}
}
