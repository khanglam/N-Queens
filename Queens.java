package Project2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Queens {
	int[] board;
	int size;
	PriorityQueue<SuccessorNode> pq = new PriorityQueue<SuccessorNode>();
	
	public Queens(int[] board, int size)
	{
		this.board = board;
		this.size = size;
		pq.add(new SuccessorNode(board, get_H(board)));
//		SteepHillClimb(new SuccessorNode(board, get_H(board)));
	}
	
	public SuccessorNode SteepHillClimb(SuccessorNode current)
	{
		SuccessorNode neighbor;
		while(true)
		{
			neighbor = pq.poll();//takes the best child with best heuristic
			pq.clear(); // then delete the rest
			
			if(Arrays.equals(current.getSequence(), this.board) || 
					(current.get_h() > neighbor.get_h()))
			{
				current = neighbor;
				generateSuccessors(current.getSequence());
			}
			else
				return current;
		}
	}
	
	public void generateSuccessors(int[] current)
	{
		int[] board_clone;
		int size = current.length;
			for(int col = 0; col < size; col++)
			{
				for(int row = 0; row < size; row++)
				{
					if(board[col] == row) continue;
					board_clone = current.clone();
					board_clone[col] = row;
					pq.add(new SuccessorNode(board_clone,get_H(board_clone)));
				}
			}
	}
	
	public int get_H(int[] board)
	{
		int h = 0;
		int offset;
		int size = board.length;
		for(int i = 0; i < size; i++)
			for(int j = i + 1; j < size; j++)
			{
				if(board[i] == board[j])
					h++;
				offset = j - i;
				if((board[i] == board[j] + offset) ||
						board[i] == board[j] - offset)
					h++;
			}
		return h;
	}
	public int get_Fitness(int[] board)
	{
		int h = get_H(board);
		int max = ((board.length) * (board.length - 1))/2;
		int fn = max - h;
		return fn;
		
	}
	
}
