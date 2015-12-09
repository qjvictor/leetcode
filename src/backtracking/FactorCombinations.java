package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.

Write a function that takes an integer n and return all possible combinations of its factors.

Note:

    Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
    You may assume that n is always positive.
    Factors should be greater than 1 and less than n.

Examples:
input: 1
output:

[]

input: 37
output:

[]

input: 12
output:

[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]

input: 32
output:

[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]

 * @author VictorQian
 *
 */
public class FactorCombinations {
	public static void main(String[] args){
		FactorCombinations f = new FactorCombinations();
		System.out.println(f._getFactors(32));
	}
	
	public List<List<Integer>> _getFactors(int n) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (n <= 3)
			return ret;
		helper(ret, new ArrayList<Integer>(), n, 2);
		return ret;
    }

	private void helper(List<List<Integer>> ret, ArrayList<Integer> list, int n, int index) {
		for(int i=index;i<=Math.sqrt(n);i++){
			if(n%i==0){
				list.add(i);
				list.add(n/i);
				ret.add(new ArrayList<>(list));
				list.remove(list.size()-1);
				helper(ret, list, n/i, i);
				list.remove(list.size()-1);
			}
		}
	}
	
	public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 3) return result;
        helper(n, -1, result, new ArrayList<Integer>());
        return result; 
    }
    
    public void helper(int n, int lower, List<List<Integer>> result, List<Integer> cur) {
        if (lower != -1) {
            cur.add(n);
            result.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1);
        }
        int upper = (int) Math.sqrt(n);
        for (int i = Math.max(2, lower); i <= upper; ++i) {
            if (n % i == 0) {
                cur.add(i);
                helper(n / i, i, result, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
	
}
