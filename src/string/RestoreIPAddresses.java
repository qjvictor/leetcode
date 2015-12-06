package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
 * @author evicqia
 *
 */
public class RestoreIPAddresses {
	public static void main(String[] args){
		RestoreIPAddresses r = new RestoreIPAddresses();
		System.out.println(r.restoreIpAddresses("25525511135"));
		System.out.println(r.restoreIpAddresses("1111"));
	}
	
	
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0 || s.length() > 12){
            return result;
        }
        helper(result, s, "", 0, 0);
        return result;
    }

	private void helper(List<String> result, String s, String ips, int start,
			int ipSegment) {
		if (start == s.length() && ipSegment == 4) {
			result.add(ips);
			return;
		}
		for (int i = start + 1; i <= s.length(); i++) {
			String tmp = s.substring(start, i);
			if (tmp.length() > 3 
					|| tmp.length() > 1 && tmp.charAt(0) == '0'
					|| Integer.parseInt(tmp) > 255) {
				return;
			}
			if (ips.length() != 0) {
				helper(result, s, ips + "." + tmp, i, ipSegment + 1);
			} else {
				helper(result, s, tmp, i, ipSegment + 1);
			}
		}
	}
}
