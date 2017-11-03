package Project2;

import java.util.Scanner;
import java.util.Random;

public class NQueens {

	public static void main(String[] args) 
	{
		Scanner k = new Scanner(System.in);
		System.out.print("How Many Queens? ");
		int[] board = new int[k.nextInt()];
		initializeBoard(board);
		printBoard(board);
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
	        System.out.println();

	}

}