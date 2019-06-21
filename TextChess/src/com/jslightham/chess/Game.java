package com.jslightham.chess;

public class Game {
	private static Piece[][] board = new Piece[8][8];
	public static void main(String[] args) {
		play();
	}
	
	public static void play() {
		board[0][1] = new Piece("pawn", "white");
		boolean isFinished = false;
		while(!isFinished) {
			
			Command command = Parser.getCommand();
			isFinished = processCommand(command);
			printBoard();
			
		}
		
	}
	
	public static void printBoard() {
		System.out.println("Player 1 \n");
		System.out.println("  a b c d e f g h");
		for(int i=0; i<board.length; i++) {
			System.out.print(i + " ");
			for(int j = 0; j<board[i].length; j++) {
				try {
				System.out.print(board[i][j].getSymbol());
				}catch(Exception e) {
					System.out.print("X");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static boolean processCommand(Command c) {
		
	}
}
