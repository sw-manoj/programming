package Medium;

public class GameLife {
	
//	https://leetcode.com/problems/game-of-life/discuss/73217/Infinite-board-solution/201780
	
	
	
	// python code for infinite matrix reading from file and updating the state.
	
//	from copy import deepcopy
//
//	def findLives(live):
//	    count = collections.Counter()
//	    for i, j in live:
//	        for x in range(i-1, i+2):
//	            for y in range(j-1, j+2):
//	                if x == i and y == j: 
//	                    continue
//	                count[x, y] += 1
//	    result = {}
//	    for i, j in count:
//	        if count[i, j] == 3:
//	            result.add((i, j))
//	        elif count[i, j] == 2 and (i, j) in live:
//	            result.add((i, j))
//	    return result
//
//	def updateBoard(board):
//	    live = {(i, j) for i, row in enumerate(board) for j, v in enumerate(row) if v == 1}
//	    live = findLives(live)
//	    for r, row in enumerate(board):
//	        for c, v in enumerate(row):
//	            board[r][c] = int((r, c) in live)
//	    for row in board:
//	        print(" ".join(row))
//	            
//	with open("input.txt") as f1:
//	    prev = f1.readline()
//	    pointer = f1.readline()
//	    cur = next_ = None
//	    while pointer:
//	        if not cur:
//	            cur = pointer
//	            pointer = f1.readline()
//	            continue
//	        
//	        if next_ == None:
//	            next_ = pointer
//	            pointer = f1.readline()
//	        if prev == None:
//	            tmpBoard = [ cur, next_]
//	            nextStateBoard = updateBoard(tmpBoard)
//	        else:
//	            tmpBoard = [deepcopy(prev), cur, next_]
//	            nextStateBoard =  updateBoard(tmpBoard)
//	            
//	        prev = cur
//	        cur = next_
//	        next_ = None
	
	public static void main(String[] args) {
		int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		GameLife obj = new GameLife();
		obj.gameOfLife(board);
		obj.print(board);
		
	}
	
	void print(int[][] board)
	{
		for(int i = 0 ; i < board.length;i++)
        {
        	for(int j = 0; j < board[0].length;j++)
        	{
        		System.out.print(board[i][j] + " " );
        	}
        	System.out.println();
        }
	}

	public void gameOfLife(int[][] board) {
        int res[][] = new int [board.length][board[0].length];
        
        // using below representation for inplace arr updation.
        // 0 -> 1 denoted by 2
        // 1 -> 0 denoted by -1.
        
        for(int i = 0 ; i < board.length;i++)
        {
        	for(int j = 0; j < board[0].length;j++)
        	{
        		int sum = getSum(i, j, board);
//        		System.out.println(i + "==" + j + "==" + sum);
//        		if(sum < 2)
//        		{
//        			res[i][j] = 0;
//        		}
//        		else if(sum > 3)
//        		{
//        			res[i][j] = 0;
//        		}
//        		else if(sum == 3)
//        		{
//        			res[i][j] = 1;
//        		}
//        		else
//        		{
//        			res[i][j] = board[i][j];
//        		}
        		
        		if( (sum < 2 || sum > 3) && board[i][j] == 1)
        		{
        			board[i][j] = -1;
        		}
        		
        		if( (sum == 3) && board[i][j] == 0)
        		{
        			board[i][j] = 2;
        		}
        	}
        }
        
//        for(int i = 0 ; i < board.length;i++)
//        {
//        	for(int j = 0; j < board[0].length;j++)
//        	{
//        		board[i][j] = res[i][j];
//        		
//        	}
//        }
        
        for(int i = 0 ; i < board.length;i++)
        {
        	for(int j = 0; j < board[0].length;j++)
        	{
        		if(board[i][j] > 1)
        		{
        			board[i][j] = 1;
        		}
        		else if(board[i][j] < 0 )
        		{
        			board[i][j] = 0;
        		}
        		
        	}
        }
    }
	
	public int getSum(int i , int j , int[][] board)
	{
		return getValue(i, j+1, board) 
				+ getValue(i+1, j+1, board)
				+ getValue(i+1, j, board)
				+ getValue(i+1, j-1, board)
				+ getValue(i, j-1, board)
				+ getValue(i-1, j+1, board)
				+ getValue(i-1, j, board)
				+ getValue(i-1, j-1, board);
	}
	
	public int getValue(int i , int j , int[][] board)
	{
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length )
		{
			return 0;
		}
		
		if(board[i][j] > 1)
		{
			return 0;
		}
		
		return Math.abs(board[i][j]);
		
	}
}
