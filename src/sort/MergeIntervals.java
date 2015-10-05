package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author VictorQian
 * 
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ret = new ArrayList<>();
		if (intervals == null || intervals.size() == 0)
			return ret;
		//customized comparator.
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		ret.add(intervals.get(0));

		for (Interval i : intervals) {
			Interval j = ret.get(ret.size() - 1);
			if (i.start > j.end) {
				ret.add(i);
			} else {
				j.end = Math.max(j.end, i.end);
			}
		}
		return ret;
    }
	
	public static void main(String[] args){
		MergeIntervals m = new MergeIntervals();
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(8,10);
		Interval i4 = new Interval(15,18);
		Interval i5 = new Interval(19,20);
		List<Interval> intervals = new ArrayList<>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i5);
		List<Interval> ret = m.merge(intervals);
		for(Interval i:ret){
			System.out.println(i.start+" - "+i.end);
		}
	}
}
