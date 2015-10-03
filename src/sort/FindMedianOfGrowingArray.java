package sort;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Random;

public class FindMedianOfGrowingArray {
	PriorityQueue<Integer> max = new PriorityQueue<Integer>(10,
			new Comparator<Integer>() {
				public int compare(Integer a, Integer b) {
					if (b > a)
						return 1;
					else if (a == b)
						return 0;
					else
						return -1;
				}
			}); // all integers less than median, biggest number on top.

	PriorityQueue<Integer> min = new PriorityQueue<Integer>(); // all integers greater than median, smallest number on top.
	ArrayList<Integer> nums = new ArrayList<>();
	double currentMedian = 0d;
	public void getMedian(int num) {
		nums.add(num);
		if(nums.size()==1) {
			currentMedian = num;
			max.offer(num);
		} else {
			max.offer(num);
			if(!min.isEmpty() && max.peek()>min.peek()){
				int tmp = min.poll();
				min.offer(max.poll());
				max.offer(tmp);
			}	
			if(max.size()-min.size()>1){
			  min.offer(max.poll());
			}
		}
		if(nums.size()%2==0){
			currentMedian = (min.peek()+max.peek())/2d;
		} else {
			currentMedian = max.peek();
		}
		for(int i:nums){
			System.out.print(i+" ");
		}
		System.out.println(" - "+currentMedian+", max="+max+", min="+min);
	}
	
	public static void main(String[] args){
		FindMedianOfGrowingArray f = new FindMedianOfGrowingArray();
		Random r = new Random();
		int i=0;
		while(i<20){
			f.getMedian(r.nextInt(20));
			i++;
		}
	}
}
