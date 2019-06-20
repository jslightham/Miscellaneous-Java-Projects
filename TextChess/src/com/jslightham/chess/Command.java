package com.jslightham.chess;

public class Command {
	private String fromCol, fromRow, toCol, toRow;
	
	public Command(String fromCol, String fromRow, String toCol, String toRow) {
		this.fromCol = fromCol;
		this.fromRow = fromRow;
		this.toCol = toCol;
		this.toRow = toRow;
	}
	
	public String getFromCol() {
		return fromCol;
	}
	
	public String getFromRow() {
		return fromRow;
	}
	
	public String getToCol() {
		return toCol;
	}
	
	public String getToRow() {
		return toRow;
	}
}
