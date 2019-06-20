package com.jslightham.chess;

import java.util.ArrayList;

public class Piece {
	private String type, playerColour;
	private ArrayList<String> possibleMoves;
	public boolean firstMove;
	
	public Piece(String type, String playerColour) {
		this.type = type;
		this.playerColour = playerColour;
		this.firstMove = true;
		this.possibleMoves = new ArrayList<String>();
	}
	
	public String getType() {
		return type;
	}
	
	public String getPlayerColour() {
		return playerColour;
	}
	
	public ArrayList<String> getPossibleMoves() {
		return possibleMoves;
	}
	
	public void refreshPossibleMoves(String newCol, String newRow) {
		possibleMoves.removeAll(possibleMoves);
		if(type.equals("pawn")) {
			if(firstMove)
				possibleMoves.add(newRow+2);
			possibleMoves.add(newRow+1);
		}
		// TODO Finish
	}
	
	public String getSymbol() {
		return type.substring(0, 1).toUpperCase();
	}
}
