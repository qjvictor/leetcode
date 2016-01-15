package _important;

import java.util.Stack;

/**
 *  Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area. 
 * @author VictorQian
 *
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0)
        	return 0;
        int iLen = matrix.length;
        int jLen = matrix[0].length;
        int[] histogram = new int[jLen];
        int ret=0;
        for(int i=0;i<iLen;i++){
        	for(int j=0;j<jLen;j++){
        		if(matrix[i][j]=='0'){
        			histogram[j]=0;
        		}else{
        			histogram[j]=histogram[j]+1;
        		}
        	}
        	ret=Math.max(ret, maximalHistogram(histogram));
        }
        return ret;
    }

	public int maximalHistogram(int[] histogram) {
		Stack<Integer> stk = new Stack<>();
		int max=0;
		int len = histogram.length;
		for(int i=0;i<histogram.length;i++){
			while(!stk.isEmpty() && histogram[i]<=histogram[stk.peek()]){
				int index = stk.pop();
				int area = stk.isEmpty()?histogram[index]*i:(i-stk.peek()-1)*histogram[index];
				max=Math.max(max, area);
			}
			stk.push(i);
		}
		while(!stk.isEmpty()){
            int index=stk.pop();
            int area = stk.isEmpty()?histogram[index]*len:(len-stk.peek()-1)*histogram[index];
            max=Math.max(area, max);
        }
        return max;
	}
	
	public static void main(String[] args){
		MaximalRectangle m = new MaximalRectangle();
		System.out.println(m.maximalHistogram(new int[]{1,0}));
	}
}
