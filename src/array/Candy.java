package array;

import java.util.Arrays;

/**
 *  There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give? 
 * @author VictorQian
 *
 */
public class Candy {
	public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;
        int[] left=new int[ratings.length];
        left[0]=1;
        for(int i=1;i<ratings.length;i++){
        	if(ratings[i]>ratings[i-1]){
        		left[i]=left[i-1]+1;
        	}else{
        		left[i]=1;
        	}
        }
        int ret=0;
        int[] right=new int[ratings.length];
        right[ratings.length-1]=1;
        ret=left[ratings.length-1];
        for(int i=ratings.length-2;i>=0;i--){
        	if(ratings[i]>ratings[i+1]){
        		right[i]=right[i+1]+1;
        	}else{
        		right[i]=1;
        	}
        	ret+=Math.max(right[i], left[i]);
        }
        return ret;
    }
	
	public int _candy(int[] ratings) {

		int candies[] = new int[ratings.length];
		Arrays.fill(candies, 1);// Give each child 1 candy

		for (int i = 1; i < candies.length; i++) {// Scan from left to right, to
													// make sure right higher
													// rated child gets 1 more
													// candy than left lower
													// rated child
			if (ratings[i] > ratings[i - 1])
				candies[i] = (candies[i - 1] + 1);
		}
		for (int i = candies.length - 2; i >= 0; i--) {// Scan from right to
														// left, to make sure
														// left higher rated
														// child gets 1 more
														// candy than right
														// lower rated child
			if (ratings[i] > ratings[i + 1]){
				candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
			}	
		}

		int sum = 0;
		for (int candy : candies)
			sum += candy;
		return sum;
	}
	
	
	public static void main(String[] args) {
		Candy p = new Candy();
		System.out.println(p.candy(new int[] { 1, 2, 1,2, 1, 4 }));
	}
}
