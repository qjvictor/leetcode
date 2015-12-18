package mathandbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"]. 
 * @author VictorQian
 *
 */
public class StrobogrammaticNumberIII {
	public int strobogrammaticInRange(String low, String high) {
        if(low==null || high==null || low.length()==0 || high.length()==0 || low.length()>high.length())
            return 0;
        List<String> all = new ArrayList<String>();
        for(int i=low.length();i<=high.length();i++){
            all.addAll(helper(i, i));
        }
        int ret=0;
        for(String s: all){
            if((s.length()==low.length() && s.compareTo(low)<0) ||(s.length()==high.length() && s.compareTo(high)>0)) continue;
            ret++;
        }
        return ret;
    }
    
    private List<String> helper(int cur, int max){
        if(cur <= 0) return new ArrayList<String>(Arrays.asList(""));
        if(cur == 1) return new ArrayList<String>(Arrays.asList("1", "8", "0"));
        List<String> rst = new ArrayList<String>();
        List<String> center = helper(cur - 2, max);
        for(int i = 0; i < center.size(); i++){
            String tmp = center.get(i);
            if(cur != max) rst.add("0" + tmp + "0");
            rst.add("1" + tmp + "1");
            rst.add("6" + tmp + "9");
            rst.add("8" + tmp + "8");
            rst.add("9" + tmp + "6");
        }
        return rst;
    }
	
	

    public static void main(String[] args){
    	StrobogrammaticNumberIII s = new StrobogrammaticNumberIII();
    	System.out.println(s.strobogrammaticInRange("50", "100"));
    }	
}
