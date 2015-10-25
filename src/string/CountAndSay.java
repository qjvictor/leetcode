package string;
/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. 
 * @author VictorQian
 *
 */
public class CountAndSay {
	public static void main(String[] args){
		CountAndSay c = new CountAndSay();
		System.out.println(c.countAndSay(5));
	}
	
	
	public String countAndSay(int n) {
        if(n<0) return "";
        int start=1;
        String nStr = new String("1");
        while(start<n){
        	nStr = helper(nStr);
        	start++;
        }
        return nStr;
    }
	
	private String helper(String n){
		Character curNum=null;
		int count=0;
		StringBuilder sb=new StringBuilder();
		char[] cs = n.toCharArray();
		for(int i=0;i<cs.length;i++){
			char num = cs[i];
			if(curNum!=null && curNum==num){
				count++;
			}else{
				if(curNum!=null){
					sb.append(count).append(curNum);
				}
				curNum = num;
				count=1;
			}
		}
		return sb.append(count).append(curNum).toString();
	}
}
