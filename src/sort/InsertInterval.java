package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
 * @author VictorQian
 *
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> ret = new ArrayList<Interval>();
		if(intervals==null || intervals.size()==0) {
			ret.add(newInterval);
			return ret;
		}
		
		int i=0;
		//all intervals less than of the newInterval
		while(i<intervals.size() && intervals.get(i).end<newInterval.start){
			ret.add(intervals.get(i));
			i++;
		}
		
		if(i<intervals.size()){ //overlapping happens.
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
			while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
				newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
				i++;
			}
		}
		ret.add(newInterval);  
		
		//all intervals greater than of the newInterval
		while(i<intervals.size()){
			ret.add(intervals.get(i));
			i++;
		}
		
		return ret;
    }
	
	public static void main(String[] args){
		InsertInterval m = new InsertInterval();
		Interval i1 = new Interval(1,2);
		Interval i2 = new Interval(3,5);
		Interval i3 = new Interval(6,7);
		Interval i4 = new Interval(8,10);
		Interval i5 = new Interval(12,16);
		
		Interval newInterval = new Interval(4,9);
		List<Interval> intervals = new ArrayList<>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i5);
		List<Interval> ret = m.insert(intervals, newInterval);
		for(Interval i:ret){
			System.out.println(i.start+" - "+i.end);
		}
	}
}
