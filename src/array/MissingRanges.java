package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [lower, upper]
 * inclusive, return its missing ranges.
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2",
 * "4->49", "51->74", "76->99"].
 * 
 * @author VictorQian
 * 
 */
public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		ArrayList<String> res = new ArrayList<String>();
	    if (nums == null || nums.length == 0) {
	        makeRange(res, lower, upper);
	        return res;
	    }
	    if (nums[0] != lower) {//head
	        makeRange(res, lower, nums[0] - 1);
	    }
	    for (int i = 1; i < nums.length; i++) {
	        if (nums[i] != nums[i - 1] + 1) {
	            makeRange(res, nums[i - 1] + 1, nums[i] - 1);
	        }
	    }
	    if (nums[nums.length - 1] != upper) {//tail
	        makeRange(res, Math.min(upper, nums[nums.length - 1] + 1), upper);
	    }
	    return res;
	}
	private void makeRange(ArrayList<String> res, int start, int end) {
	    if (start == end) {
	        res.add(String.valueOf(start));
	    } else {
	        res.add(start+"->"+end);
	    }
	}
	
	public static void main(String[] args){
		MissingRanges m = new MissingRanges();
		System.out.println(m.findMissingRanges(new int[]{-1}, -2, -1));
		System.out.println(m.findMissingRanges(new int[]{0, 1, 3, 50, 75}, -1, 99));
	}
}
