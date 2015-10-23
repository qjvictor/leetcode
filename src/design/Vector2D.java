package design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6]. 
 * @author VictorQian
 *
 */
public class Vector2D {
	Queue<Integer> queue = new LinkedList<>();
	public Vector2D(List<List<Integer>> vec2d) {
		if(vec2d.size()==0) return;
        for(List<Integer> list: vec2d){
        	for(int e: list){
        		queue.offer(e);
        	}
        }
    }

    public int next() {
        if(hasNext()){
        	return queue.poll();
        }else{
        	return -1;
        }
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    
    
    public static void main(String[] args){
    	List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
    	List<Integer> l1 = new ArrayList<Integer>();
    	l1.add(1);
    	l1.add(2);
//    	List<Integer> l2 = new ArrayList<Integer>();
//    	l2.add(3);
//    	List<Integer> l3 = new ArrayList<Integer>();
//    	l3.add(4);
//    	l3.add(5);
//    	l3.add(6);
    	vec2d.add(l1);
//    	vec2d.add(l2);
//    	vec2d.add(l3);
//    	List<List<Integer>> vec2d1 = new ArrayList<List<Integer>>();
    	Vector2D v = new Vector2D(vec2d);
    	while (v.hasNext()) 
    		System.out.println(v.next());
    }
}



/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
