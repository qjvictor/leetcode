package array;
/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Rectangle Area

Assume that the total area is never beyond the maximum possible value of int.

 * @author VictorQian
 *
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if (A >= G || E >= C || B >= H || F >= D) return (C - A) * (D - B) + (G - E) * (H - F);
	    int x1 = Math.max(A, E);
	    int y1 = Math.max(B, F);
	    int x2 = Math.min(C, G);
	    int y2 = Math.min(D, H);
	    return (C - A) * (D - B) + (G - E) * (H - F) - (x2 - x1) * (y2 -y1);
    }
	
	public static void main(String[] args){
		RectangleArea r = new RectangleArea();
		System.out.println(r.computeArea(0,0,0,0,-1,-1,1,1));
	}
}
