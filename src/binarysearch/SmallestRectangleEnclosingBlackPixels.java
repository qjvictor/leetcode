package binarysearch;

import java.util.ArrayList;
import java.util.List;

import matrix.NumberOfIslands;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. 
 * The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. 
 * Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle 
 * that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]

and x = 0, y = 2,

Return 6. 
 * @author evicqia
 *
 */
public class SmallestRectangleEnclosingBlackPixels {
	public static void main(String[] args){
		SmallestRectangleEnclosingBlackPixels w = new SmallestRectangleEnclosingBlackPixels();
		char[] col0 = new String("0000001111111100011111100000000000000000000000").toCharArray();
		char[] col1 = new String("0000001111111100111111100000000000000000000000").toCharArray();
		char[] col2 = new String("0000001111111110111111110000000000000000000000").toCharArray();
		char[] col3 = new String("0000001111111110111111110000000000000000000000").toCharArray();
		char[] col4 = new String("0000000111110111111111110000000000000000000000").toCharArray();
		char[] col5 = new String("0000000111000111111000010000000000000000000000").toCharArray();
		char[][] square = new char[][] { col0, col1, col2, col3, col4, col5};
		System.out.println(w._minArea(square, 5, 7));
	}
	//DFS
	public int _minArea(char[][] image, int x, int y) {
		if (image == null || image[0] == null || image.length == 0|| image[0].length == 0)
			return 0;
		List<Integer> arr = new ArrayList<>();
		arr.add(Integer.MAX_VALUE);// left
		arr.add(Integer.MIN_VALUE);// right
		arr.add(Integer.MAX_VALUE);// top
		arr.add(Integer.MIN_VALUE);// bottom
		helper(image, x, y, arr);
		return (arr.get(1) - arr.get(0) + 1) * (arr.get(3) - arr.get(2) + 1);
    }
	
	//binary search, much faster than DFS.
	public int minArea(char[][] image, int x, int y) {
	    int m = image.length, n = image[0].length;
	    int colMin = binarySearch(image, true, 0, y, 0, m, true);
	    int colMax = binarySearch(image, true, y + 1, n, 0, m, false);
	    int rowMin = binarySearch(image, false, 0, x, colMin, colMax, true);
	    int rowMax = binarySearch(image, false, x + 1, m, colMin, colMax, false);
	    return (rowMax - rowMin) * (colMax - colMin);
	}
	
	public int binarySearch(char[][] image, boolean horizontal, int lower, int upper, int min, int max, boolean goLower) {
	    while(lower < upper) {
	        int mid = lower + (upper - lower) / 2;
	        boolean inside = false;
	        for(int i = min; i < max; i++) {
	            if((horizontal ? image[i][mid] : image[mid][i]) == '1') {
	                inside = true; 
	                break;
	            }
	        }
	        if(inside == goLower) {
	            upper = mid;
	        } else {
	            lower = mid + 1;
	        }
	    }
	    return lower;
	}

	private void helper(char[][] image, int x, int y, List<Integer> arr) {
		if ((x < 0 || x >= image.length) || (y < 0 || y >= image[0].length))
			return;
		if (image[x][y] == '0') {
			return;
		} else {
			arr.set(0, Math.min(arr.get(0), y));// L
			arr.set(1, Math.max(arr.get(1), y));// R
			arr.set(2, Math.min(arr.get(2), x));// T
			arr.set(3, Math.max(arr.get(3), x));// B
			image[x][y] = '0'; //key
			helper(image, x + 1, y, arr);
			helper(image, x - 1, y, arr);
			helper(image, x, y - 1, arr);
			helper(image, x, y + 1, arr);
		}
	}
}
