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
            if(intervals[i].start >= pq.peek()) {//current meeting does no have conflict with earliest-finished meeting, can re-use this meeting room.
                pq.poll();
            } 
            pq.offer(intervals[i].end); //add current meeting's end time into heap.
        }
        return pq.size();
    }
	/**
	 * # Very similar with what we do in real life. Whenever you want to start a meeting,
		# you go and check if any empty room available (available > 0) and
		# if so take one of them ( available -=1 ). Otherwise,
		# you need to find a new room someplace else ( numRooms += 1 ). 
		# After you finish the meeting, the room becomes available again ( available += 1 ). 
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms2(Interval[] intervals) {  
        if (intervals == null || intervals.length == 0)  
            return 0;  
        int N = intervals.length;  
        int[] starts = new int[N];  
        int[] ends = new int[N];  
        for (int i = 0; i < intervals.length; i++) {  
            starts[i] = intervals[i].start;  
            ends[i] = intervals[i].end;  
        }  
        Arrays.sort(starts);  
        Arrays.sort(ends);  
        int e = 0, rooms = 0, available = 0;  
        for (int start : starts) {  
            while (ends[e] <= start) {  //free the finished meetings.
                available++;  
                e++;  
            }  
            if (available > 0)  //take one from available.
                available--;  
            else  //no more free, have to get a new room.
                rooms++;  
        }  
        return rooms;  
    }  
	
	public static void main(String[] args){
		MeetingRooms2 m = new MeetingRooms2();
		Interval i1=new Interval(4,9);
		Interval i2=new Interval(4,17);
		Interval i3=new Interval(9,10);
		System.out.println(m.minMeetingRooms2(new Interval[]{i1,i2,i3}));
		
		 i1=new Interval(4,10);
		 i2=new Interval(13,20);
		 i3=new Interval(10,15);
		 Interval i4=new Interval(16,19);
		System.out.println(m.minMeetingRooms2(new Interval[]{i1,i2,i3, i4}));
	}
}
