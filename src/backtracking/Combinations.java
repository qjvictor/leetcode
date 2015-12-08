package backtracking;
import java.util.*;
/**
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 * @author VictorQian
 *
 */
public class Combinations {
	
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(n==0 || k==0 || n<k) return ret;
        helper(ret, new ArrayList<Integer>(), n, k, 1);
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, ArrayList<Integer> list, int n, int k, int index){
        if(list.size()==k){
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=index;i<=n;i++){
            list.add(i);
            helper(ret, list, n, k, i+1);
            list.remove(list.size()-1);
        }
    }
}
