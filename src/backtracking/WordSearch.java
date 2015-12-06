package backtracking;
/**
 *  Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 * @author evicqia
 *
 */
public class WordSearch {
	public static void main(String[] args){
		WordSearch w = new WordSearch();
		char[][] board = new char[3][4];
		board[0]= new char[]{'A','B','C','E'};
		board[1]= new char[]{'S','F','C','S'};
		board[2]= new char[]{'A','D','E','E'};
		System.out.println(w.exist(board, "ABCCED"));
		System.out.println(w.exist(board, "SEE"));
		System.out.println(w.exist(board, "ABCB"));
		
		char[][] board1 = new char[1][1];
		board1[0]= new char[]{'A'};
		System.out.println(w.exist(board1, "A"));
	}
	
	
	public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0]==null || board[0].length==0)
        	return false;
        if(word==null || word.length()==0) 
        	return true;
        
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		boolean found= helper(board, word, used, 0, i, j);
        		if(found) return true;
        	}
        }
        return false;
    }

	private boolean helper(char[][] board, String word, boolean[][] used, int index, int row, int col) {
		if(index==word.length()){
			return true;
		}
        char c = word.charAt(index);
        if(row<0 || row>=board.length || col<0 || col>=board[0].length 
            || used[row][col] || c!=board[row][col])
        return false;
        used[row][col]=true;
        boolean isExisted = helper(board, word, used, index+1,row-1, col)
                            || helper(board, word, used, index+1,row+1, col)
                            || helper(board, word, used, index+1,row, col-1)
                            || helper(board, word, used, index+1,row, col+1);
        used[row][col]=false;
                            
        return isExisted;
	}
}
