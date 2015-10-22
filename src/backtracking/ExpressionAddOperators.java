package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a string that contains only digits 0-9 and a target value, 
 *  return all possibilities to add binary operators (not unary) +, -, 
 *  or * between the digits so they evaluate to the target value.

Examples:

"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []

 * @author VictorQian
 *
 */
public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<String>();
        if(num==null || num.length()==0) return ret;
        helper(ret, num, target);
        return ret;
    }
	
	private void helper(List<String> ret, String num, int target){
		
	}
}
