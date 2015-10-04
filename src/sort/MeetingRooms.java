package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 * 
 * @author VictorQian
 * 
 */
public class MeetingRooms {


	public boolean canAttendMeetings(Interval[] intervals) {
		if(intervals==null || intervals.length==0) return true;
		//solution: sort by start time, check the each end time is less than next start time.
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2){
				return i1.start-i2.start;
			}
		});
		
		for(int i=0;i<intervals.length-1;i++){
			if(intervals[i].end>intervals[i+1].start) return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		MeetingRooms m = new MeetingRooms();
		Interval i1=new Interval(0,30);
		Interval i2=new Interval(5,10);
		Interval i3=new Interval(15,20);
		System.out.println(m.canAttendMeetings(new Interval[]{i1,i2,i3}));
		
		 i1=new Interval(0,3);
		 i2=new Interval(5,10);
		 i3=new Interval(15,20);
		System.out.println(m.canAttendMeetings(new Interval[]{i1,i2,i3}));
	}
}
