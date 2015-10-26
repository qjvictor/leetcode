package string;
/**
 *  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 *  (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


 * @author VictorQian
 *
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0)
			return "";
		if (numRows <= 1 || numRows >= s.length())
			return s;
		int numCols = s.length();

		char[][] cs = new char[numRows][numCols];
		char[] sChars = s.toCharArray();
		int index = 0;

		for (int col = 0; col < numCols; col++) {
			for (int row = 0; row < numRows; row++) {
				if (index >= sChars.length)
					break;
				if (col % 2 == 0) {
					cs[row][col] = sChars[index++];
				} else {
					if (row != 0 && row != numRows - 1) {
						cs[numRows-1-row][col] = sChars[index++];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (cs[row][col] != 0)
					sb.append(cs[row][col]);
			}
		}
		return sb.toString();
    }
	
	public static void main(String[] args){
		ZigZagConversion z = new ZigZagConversion();
		System.out.println(z.convert("PAYPALISHIRING", 4));
	}
}
