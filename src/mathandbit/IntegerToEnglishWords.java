package mathandbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,

123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * @author VictorQian
 *
 */
public class IntegerToEnglishWords {
	public static void main(String[] args){
		IntegerToEnglishWords i = new IntegerToEnglishWords();
		System.out.println(i.numberToWords(1234567));
		System.out.println(i.numberToWords(12345));
		System.out.println(i.numberToWords(100));
		System.out.println(i.numberToWords(101));
		System.out.println(i.numberToWords(111));
		System.out.println(i.numberToWords(30));
		System.out.println(i.numberToWords(45));
	}
	
	public String numberToWords(int num) {
		List<Integer> list = new ArrayList<>();
		if (num == 0)
			return "Zero";
		while (num != 0) {  // 3 by 3
			list.add(num % 1000);
			num = num / 1000;
		}
		HashMap<Integer, String> map = new HashMap<Integer, String> ();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");     
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
		
		StringBuilder sb = new StringBuilder();
		for (int i = list.size() - 1; i >= 0; i--) {
			int curVal = list.get(i);
			sb.append(helper(curVal, map));
			if (curVal > 0) {
				if (i == 3)
					sb.append(" Billion");
				else if (i == 2)
					sb.append(" Million");
				else if (i == 1)
					sb.append(" Thousand");
			}
		}

		return sb.toString().trim();
    }

	public String helper(int num, HashMap<Integer, String> map) {
		StringBuilder sb = new StringBuilder();
		int n = num / 100;
		if (n > 0) {
			sb.append(" "+map.get(n));
			sb.append(" Hundred");
		}
		num = num % 100;
		if (num != 0) {
			if (num <= 20)
				sb.append(" " + map.get(num));
			else {
				n = num / 10;
				sb.append(" " + map.get(n * 10));
				if (num % 10 != 0)
					sb.append(" " + map.get(num % 10));
			}
		}
		return sb.toString();
	}

}
