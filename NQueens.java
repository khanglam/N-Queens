package Project2;

import java.util.Scanner;
import java.util.Random;

public class NQueens {

	public static void main(String[] args) 
	{
		int[] board = userInput();
//		int[] board = {3,2,1,4,3,2,1,2};
		initializeBoard(board);
		Queens q = new Queens(board, board.length);
		SuccessorNode result = q.SteepHillClimb(new SuccessorNode(board, q.get_H(board)));
		printBoard(result.getSequence());
//		printBoard(board);
		System.out.println(q.get_H(result.getSequence()));
//		k.close();
	}
	
	public static int[] userInput()
	{
		Scanner k = new Scanner(System.in);
		int[] board;
		while(true)
		{
			try{
				System.out.print("How Many Queens? ");
				int input = k.nextInt();
				board = new int[input];
				k.close();
				return board;
			}catch(Exception e)
			{
				System.out.println("Integers Only");
				k.nextLine();
			}
		}
		
	}
	
	public static void initializeBoard(int[] board)
	{
		Random rand = new Random();
		int size = board.length;
		for(int i = 0; i < size; i++)
			board[i] = i;
		for(int i = 0; i < size; i++)
		{
			int x = rand.nextInt(size);
			int temp = board[i];
			board[i] = board[x];
			board[x] = temp;
		}
	}
	
	public static void printBoard(int[] board)
	{
	       int N = board.length;
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if (board[i] == j) {
	                    System.out.print("Q ");
	                } else {
	                    System.out.print("* ");
	                }
	            }
	            System.out.println();
	        }
	        for (int i = 0; i < N; i++)
	        	System.out.print(board[i]);
	        System.out.println();

	}

}