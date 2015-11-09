package design;
import java.util.*;
/**
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 * 
 * For example, given two 1d vectors:
 * 
 * v1 = [1, 2] 
 * v2 = [3, 4, 5, 6]
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1, 3, 2, 4, 5, 6].
 * 
 * Follow up: What if you are given k 1d vectors? How well can your code be
 * extended to such cases?
 * 
 * Clarification for the follow up question - Update (2015-09-18): The "Zigzag"
 * order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag"
 * does not look right to you, replace "Zigzag" with "Cyclic". For example,
 * given the following input:
 * 
 * [1,2,3] 
 * [4,5,6,7] 
 * [8,9]
 * 
 * It should return [1,4,8,2,5,9,3,6,7].
 * 
 * @author VictorQian
 * 
 */
public class ZigzagIterator {
	List<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
	int pos = 0;
	int size=0;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		size+=add(v1, list);
		size+=add(v2, list);
	}
	
	private int add(List<Integer> v1, List<LinkedList<Integer>> list){
		if (v1 != null) {
			LinkedList<Integer> l1 = new LinkedList<>();
			l1.addAll(v1);
			list.add(l1);
			return l1.size();
		}
		return 0;
	}

	public int next() {
		if (!hasNext())
			return -1;
		while (list.get(pos).isEmpty()) {
			pos++;
			if(pos == list.size()){
				pos=0;
			}
		}
		int ret = list.get(pos).pop();
		//move to the next list.
		pos++;
		if (pos == list.size()) {
			pos = 0;
		}
		size--;
		return ret;
	}

	public boolean hasNext() {
		return size>0;
	}
	
	public static void main(String[] args){
		List<Integer> v1  = new ArrayList<>();
		v1.add(1);
		v1.add(2);
		v1.add(3);
		List<Integer> v2  = new ArrayList<>();
		v2.add(4);
		v2.add(5);
		v2.add(6);
		v2.add(7);
		ZigzagIterator z = new ZigzagIterator(v1, v2);
		while(z.hasNext()){
			System.out.print(z.next());
			System.out.print(" ");
		}
		
	}
}
