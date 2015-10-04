package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 * 
 * @author VictorQian
 * 
 */
public class MeetingRooms2 {
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals==null || intervals.length==0) return 0;
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2){
				return i1.start-i2.start;
			}
		});
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0].end);
        for(int i = 1;i < intervals.length;i++) {
            if(intervals[i].start >= pq.peek()) {//current meeting does no have conflict, can re-use this meeting room.
                pq.poll();
            } 
            pq.offer(intervals[i].end); //add current meeting's end time into heap.
        }
        return pq.size();
    }
	
	public static void main(String[] args){
		MeetingRooms2 m = new MeetingRooms2();
		Interval i1=new Interval(4,9);
		Interval i2=new Interval(4,17);
		Interval i3=new Interval(9,10);
		System.out.println(m.minMeetingRooms(new Interval[]{i1,i2,i3}));
		
		 i1=new Interval(4,10);
		 i2=new Interval(13,20);
		 i3=new Interval(10,15);
		 Interval i4=new Interval(16,19);
		System.out.println(m.minMeetingRooms(new Interval[]{i1,i2,i3, i4}));
	}
}
