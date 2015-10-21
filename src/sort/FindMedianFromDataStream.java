package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value. Examples:
 * 
 * [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data
 * structure. double findMedian() - Return the median of all elements so far.
 * 
 * For example:
 * 
 * add(1) add(2) findMedian() -> 1.5 add(3) findMedian() -> 2
 * 
 * @author VictorQian
 * 
 */
public class FindMedianFromDataStream {
	Comparator<Integer> maxComp = new Comparator<Integer>(){
		@Override
		public int compare(Integer v1, Integer v2){
			return v2-v1;
		}
	};
	PriorityQueue<Integer> min = new PriorityQueue<Integer>();
	PriorityQueue<Integer> max = new PriorityQueue<Integer>(10, maxComp);
	
    // Adds a number into the data structure.
	public void addNum(int num) {
		if (max.isEmpty() || num <= max.peek()) {
			max.offer(num);
		} else {
			min.offer(num);
		}
		if (min.size() == max.size() + 2) {
			max.offer(min.poll());
		}
		if (max.size() == min.size() + 2) {
			min.offer(max.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (min.size() == 0 && max.size() == 0)
			return 0d;
		int total = min.size() + max.size();
		if (total % 2 == 0) {
			return (min.peek() + max.peek()) / 2d;
		} else {
			return min.size() > max.size() ? min.peek() : max.peek();
		}
	}


	public static void main(String[] args){
		FindMedianFromDataStream mf = new FindMedianFromDataStream();
		mf.addNum(-1);
		System.out.println(mf.findMedian());
		mf.addNum(-2);
		System.out.println(mf.findMedian());
		mf.addNum(-3);
		System.out.println(mf.findMedian());
		mf.addNum(-4);
		System.out.println(mf.findMedian());
		mf.addNum(-5);
		System.out.println(mf.findMedian());
	}
}
// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();