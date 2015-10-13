package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators. The
 * valid operators are +, - and *.
 * 
 * Example 1
 * 
 * Input: "2-1-1".
 * 
 * ((2-1)-1) = 0 (2-(1-1)) = 2
 * 
 * Output: [0, 2]
 * 
 * Example 2
 * 
 * Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34 ((2*3)-(4*5)) = -14 ((2*(3-4))*5) = -10 (2*((3-4)*5)) =
 * -10 (((2*3)-4)*5) = 10
 * 
 * Output: [-34, -14, -10, -10, 10]
 * 
 * @author VictorQian
 * 
 */
public class DifferentWaystoAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> ret = new ArrayList<>();
		if (input == null || input.length() == 0)
			return ret;
		boolean onlyNumber = true;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				onlyNumber = false;
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				for (int x : left) { // get all combinations.
					for (int y : right) {
						if (c == '-') {
							ret.add(x - y);
						} else if (c == '+') {
							ret.add(x + y);
						} else if (c == '*') {
							ret.add(x * y);
						}
					}
				}
			}
		}
		if (onlyNumber)
			ret.add(Integer.valueOf(input));// very important: for case left or right only contains a number, return it.
		return ret;
    }
	
	public static void main(String[] args){
		DifferentWaystoAddParentheses d = new DifferentWaystoAddParentheses();
		System.out.println(d.diffWaysToCompute("2*3-4*5"));
	}
}
