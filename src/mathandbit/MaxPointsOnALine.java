package mathandbit;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * @author evicqia
 * 
 */
class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	public Point(int a, int b) {
		x = a;
		y = b;
	}
}
public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
        if(points==null || points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int samex = 1;
            int samePoints = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){  //duplicated points
                        samePoints++;
                    }
                    if(points[j].x == points[i].x){ 
                        samex++;
                        continue;
                    }
					double k = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
					if (hm.containsKey(k)) {
						hm.put(k, hm.get(k) + 1);
					} else {
						hm.put(k, 2);
					}
                    result = Math.max(result, hm.get(k) + samePoints);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }
	
	public static void main(String[] args){
		MaxPointsOnALine m = new MaxPointsOnALine();
		Point p1 = new Point(2,3);
		Point p2 = new Point(2,3);
		Point p3 = new Point(2,3);
		System.out.println(m.maxPoints(new Point[]{p1,p2, p3}));
	}
}
